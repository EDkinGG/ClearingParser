package com.example.ClearingParser.core.model.repository;


import com.example.ClearingParser.core.model.entity.VisaFileDetailsEntity;
import com.example.ClearingParser.enumeration.FileStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 3:09 PM
 ******************************************
 */

@Repository
public interface VisaFileDetailsRepository extends JpaRepository<VisaFileDetailsEntity, Long>, JpaSpecificationExecutor {
    boolean existsByUniqueKeyAndFileStatus(String uniqueKey, FileStatus status);
}
