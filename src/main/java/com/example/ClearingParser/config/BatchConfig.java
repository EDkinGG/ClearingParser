package com.example.ClearingParser.config;


import com.example.ClearingParser.config.listener.CustomJobExecutionListener;
import com.example.ClearingParser.config.validator.ParametersValidator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 10:58 AM
 ******************************************
 */

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    public static final FlowExecutionStatus VISA_CLEARING = new FlowExecutionStatus("VISA_CLEARING");
    public static final FlowExecutionStatus MASTERCARD_CLEARING = new FlowExecutionStatus("MASTERCARD_CLEARING");
    public static final FlowExecutionStatus UNKNOWN = new FlowExecutionStatus("UNKNOWN");

    @Bean
    public Job clearingJob(JobRepository jobRepository,
                           Step initStep,
                           Step visaClearingStep,
                           Step mastercardClearingStep,
                           ParametersValidator jobParametersValidator) {

        return new JobBuilder("clearing-job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(initStep)
                .next(jobExecutionDecider())
                .on(getStatus(VISA_CLEARING))
                .to(visaClearingStep)
                .from(jobExecutionDecider())
                .on(getStatus(MASTERCARD_CLEARING))
                .to(mastercardClearingStep)
                .from(jobExecutionDecider())
                .on(getStatus(UNKNOWN)).end()
                .end()
                .validator(jobParametersValidator)
                .listener(customJobExecutionListener())
                .build();
    }

    @Bean
    public Step initStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("initStep", jobRepository)
                .tasklet((contribution, chunkContext) -> RepeatStatus.FINISHED, transactionManager)
                .build();
    }

    @Bean
    JobExecutionDecider jobExecutionDecider(){
        return (jobExecution, stepExecution) -> {
            String jobName = jobExecution.getJobParameters().getString("jobName");
            if (VISA_CLEARING.getName().equals(jobName) ){
                return VISA_CLEARING;
            } else if (MASTERCARD_CLEARING.getName().equals(jobName)){
                return MASTERCARD_CLEARING;
            } else {
                return UNKNOWN;
            }
        };
    }

    private String getStatus(FlowExecutionStatus flowExecutionStatus) {
        return flowExecutionStatus.getName();
    }

    @Bean
    public CustomJobExecutionListener customJobExecutionListener(){
        return new CustomJobExecutionListener();
    }
}
