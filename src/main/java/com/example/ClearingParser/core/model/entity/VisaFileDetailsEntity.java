package com.example.ClearingParser.core.model.entity;


import com.example.ClearingParser.enumeration.FileStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/31/2025 at 2:50 PM
 ******************************************
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VISA_FILE_DETAILS")
public class VisaFileDetailsEntity {

    @Id
    @SequenceGenerator(name = "visa_file_details_seq_gen", sequenceName = "visa_file_details_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visa_file_details_seq")
    @Column(name = "FILE_ID", nullable = false)
    private int fileId;

    @Column(name = "FILE_NAME", length = 100)
    private String fileName;

    @Column(name = "PROCESSING_DATE", length = 5)
    private String processingDate;

    @Column(name = "INCOMING_FILE_ID", length = 3)
    private String incomingFileId;

    @Enumerated(EnumType.STRING)
    @Column(name = "FILE_STATUS")
    private FileStatus fileStatus;

    @Column(name = "UNIQUE_KEY")
    private String uniqueKey;

    @Column(name = "PARSE_TIME")
    private Date parseTime;



}
