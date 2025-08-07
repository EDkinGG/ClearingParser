package com.example.ClearingParser.core.model.dao;


import com.example.ClearingParser.core.model.entity.VisaFileDetailsEntity;
import com.example.ClearingParser.core.model.repository.VisaFileDetailsRepository;
import com.example.ClearingParser.enumeration.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 2:46 PM
 ******************************************
 */

@Service
public class FileDetailsDao {

    @Autowired
    private VisaFileDetailsRepository visaFileDetailsRepository;

    public VisaFileDetailsEntity save(VisaFileDetailsEntity visaFileDetailsEntity) {
        return visaFileDetailsRepository.saveAndFlush(visaFileDetailsEntity);
    }

    public boolean existsByUniqueKeyAndStatus(String uniqueKey, FileStatus status) {
        return visaFileDetailsRepository.existsByUniqueKeyAndFileStatus(uniqueKey, status);
    }

    public Optional<VisaFileDetailsEntity> findById(Long id) {
        return visaFileDetailsRepository.findById(id);
    }

}
