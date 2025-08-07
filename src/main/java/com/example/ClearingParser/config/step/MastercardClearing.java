package com.example.ClearingParser.config.step;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 11:23 AM
 ******************************************
 */

@Configuration
@Slf4j
public class MastercardClearing {

    @Bean(name = "mastercardClearingStep")
    public Step mastercardClearingStep(){
        return null;
    }
}
