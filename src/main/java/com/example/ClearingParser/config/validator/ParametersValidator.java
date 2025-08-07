package com.example.ClearingParser.config.validator;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.stereotype.Component;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 3:38 PM
 ******************************************
 */

@Component
@Slf4j
public class ParametersValidator implements JobParametersValidator {

    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        String jobName = parameters.getString("jobName");
        log.info("JobName: {}", jobName);

        if(StringUtils.isEmpty(jobName)){
            throw new JobParametersInvalidException("jobName is empty");
        }
    }
}
