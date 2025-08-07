package com.example.ClearingParser.config.step;


import com.example.ClearingParser.config.partitioner.VisaFilePartitioner;
import com.example.ClearingParser.core.model.entity.VisaFileDetailsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 11:22 AM
 ******************************************
 */

@Configuration
@Slf4j
public class VisaClearing {

    @Value("${providers.visa.file-chunk-size}")
    private Integer fileChunkSize;

    @Value("${providers.visa.grid-size}")
    private Integer gridSize;

    @Value("${providers.visa.concurrency-limit}")
    private Integer concurrencyLimit;

    @Bean(name = "visaClearingStep")
    public Step visaClearingMainStep(JobRepository jobRepository, Step compositeStep) {
        return new StepBuilder("visaClearingMainStep", jobRepository)
                .partitioner("visaWorkerStep", visaFilePartitioner())
                .step(compositeStep)
                .taskExecutor(taskExecutor())
                .gridSize(gridSize)
                .build();
    }

    @Bean
    public VisaFilePartitioner visaFilePartitioner(){
        return new VisaFilePartitioner();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor("visaClearingTaskExecutor");
        executor.setConcurrencyLimit(concurrencyLimit);
        return executor;
    }

    @Bean
    public Step compositeStep(JobRepository jobRepository,
                              PlatformTransactionManager transactionManager,
                              ObjectProvider<VisaBatchReader> visaBatchReader,
                              VisaRecrodProcessor visaRecrodProcessor,
                              VisaRecordWriter visaRecordWriter,
                              Step moveFileStep,
                              VisaProcessStepListener visaProcessStepListener) {

        Step processStep = new StepBuilder("processFileInnerStep", jobRepository)
                .<VisaBatchRecord, VisaBatchDetails>chunk(fileChunkSize, transactionManager)
                .reader(visaBatchReader.getObject())
                .processor(processor)
                .writer(writer)
                .faultTolerant()
                .listener(visaProcessStepListener)
                .build();

        Flow flow = new FlowBuilder<Flow>("workerFlow")
                .start(processStep)
                .next(moveFileStep)
                .build();

        return new StepBuilder("compositeStep", jobRepository)
                .flow(flow)
                .build();
    }

    @Bean
    @StepScope
    public VisaTransactionReader visaTransactionReader(@Qualifier("flatFileItemReader") FlatFileItemReader<VisaRecordMetadta> rawLineReader) {

    }



}
