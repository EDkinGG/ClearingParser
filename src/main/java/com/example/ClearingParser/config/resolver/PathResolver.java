package com.example.ClearingParser.config.resolver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Fidelity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 12:02 PM
 ******************************************
 */

@Component
@Slf4j
public class PathResolver {

    @Value("${providers.visa.input-file}")
    private String visaInputFile;

    @Value("${providers.visa.input-directory}")
    private String visaInputFileDirectory;

    @Value("${providers.visa.processed-directory}")
    private String visaProcessedFileDirectory;

    public Resource[] loadVisaInputFile() {
        String pattern = visaInputFile + "/*.txt";
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            return resolver.getResources(pattern);
        } catch (IOException e) {
            log.error("Visa Input File Not Found", e);
            throw new RuntimeException("Visa Input File Not Found");
        }
    }

    public Path loadVisaInputDirectory(){
        Path path = Paths.get(visaInputFileDirectory);
        if(!Files.exists(path)){
            log.warn("Visa Input Directory Not Found");
        }
        return path;
    }

    public Path loadVisaProcessedDirectory(){
        Path path = Paths.get(visaProcessedFileDirectory);
        try{
            if(!Files.exists(path)){
                Files.createDirectories(path);
                log.info("Visa Processed Directory Created");
            }
        } catch(IOException e){
            log.error("Visa Processed Directory creation failed", e);
        }
        return path;
    }


}
