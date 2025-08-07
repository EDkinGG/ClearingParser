package com.example.ClearingParser.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 10:58 AM
 ******************************************
 */

@Configuration
public class JobLauncherConfig {
    @Bean
    public CommandLineRunner runJob(JobLauncher jobLauncher, @Qualifier("clearingJob")Job job) {
        return args -> {
            String jobName = Arrays.stream(args)
                    .filter(arg -> arg.startsWith("jobName"))
                    .map(arg -> arg.split("=", 2)[1])
                    .findFirst().orElse(null);

            if (jobName == null) {
                return;
            }

            jobLauncher.run(job, new JobParametersBuilder()
                    .addString("jobName", jobName)
                    .addLong("startTime", System.currentTimeMillis())
                    .toJobParameters());
        };
    }
}
