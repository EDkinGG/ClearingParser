package com.example.ClearingParser.config.partitioner;


import com.example.ClearingParser.config.resolver.PathResolver;
import com.example.ClearingParser.core.model.dao.FileDetailsDao;
import com.example.ClearingParser.core.model.entity.VisaFileDetailsEntity;
import com.example.ClearingParser.enumeration.FileStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 11:46 AM
 ******************************************
 */

@Slf4j
public class VisaFilePartitioner implements Partitioner {

    @Autowired
    private PathResolver pathResolver;

    @Autowired
    private FileDetailsDao fileDetailsDao;

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        Resource[] ctfFiles = pathResolver.loadVisaInputFile();
        Map<String, ExecutionContext> partitions = new HashMap<>();

        int partitionNo = 0;
        for( Resource file : ctfFiles ) {
            VisaFileDetailsEntity fileDetailsEntity = new VisaFileDetailsEntity();
            fileDetailsEntity.setFileName(file.getFilename());
            fileDetailsEntity.setFileStatus(FileStatus.PROCESSING);
            fileDetailsEntity.setParseTime(new Date());

            VisaFileDetailsEntity visaFileDetailsEntity = fileDetailsDao.save(fileDetailsEntity);
            ExecutionContext executionContext = new ExecutionContext();
            executionContext.putString("fileName", file.getFilename());
            executionContext.putLong("fileId",visaFileDetailsEntity.getFileId());
            try {
                executionContext.putString("filePath", file.getURL().toString());
            } catch (Exception e) {
                log.error("Failed to get file path", e);
            }
            partitions.put("partition" + partitionNo, executionContext);
            partitionNo++;
        }

        return partitions;
    }
}
