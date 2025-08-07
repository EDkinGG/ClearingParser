package com.example.ClearingParser.config.listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 3:53 PM
 ******************************************
 */

@Component
@Slf4j
public class CustomJobExecutionListener implements JobExecutionListener {

    private long startTime;
    private long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();

        log.info("Job execution started for JobName:[{}] startAt[{}]",
                jobExecution.getJobParameters().getString("jobName"),
                jobExecution.getJobParameters().getLong("startAt"));

    }


    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();

        log.info("Job execution ended jobName:[{}], StartAt [{}], Status[{}] Elasped[{}]ms",
                jobExecution.getJobParameters().getString("jobName"),
                jobExecution.getJobParameters().getLong("startAt"),
                jobExecution.getExitStatus().getExitCode(),
                endTime - startTime);

        if (jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("Job execution completed successfully");

            new Thread(()->{
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }).start();
        } else if ( jobExecution.getStatus() == BatchStatus.FAILED){
            log.info("Job execution failed");
            new Thread(()->{
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(1);
            }).start();
        }

    }
}
