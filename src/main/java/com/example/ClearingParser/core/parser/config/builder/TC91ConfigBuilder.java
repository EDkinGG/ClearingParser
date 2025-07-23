package com.example.ClearingParser.core.parser.config.builder;


import com.example.ClearingParser.core.model.dto.FieldDefinition;
import com.example.ClearingParser.core.model.dto.ParserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/20/2025 at 3:10 PM
 ******************************************
 */

@Component
@Slf4j
public class TC91ConfigBuilder {

    public ParserConfig getTc91Config(){

        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROCESSING_DATE").position(11).length(5).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("DESTINATION_AMOUNT").position(16).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NUMBER_OF_MONETARY_TRANSACTIONS").position(31).length(12).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BATCH_NUMBER").position(43).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NUMBER_OF_TCRS").position(49).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("CENTER_BATCH_ID").position(67).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NUMBER_OF_TRANSACTIONS").position(75).length(9).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("SOURCE_AMOUNT").position(102).length(15).type(FieldDefinition.FieldType.AMOUNT).build()
        );

        log.debug("Created TC91 configuration with {} fields", fields.size());
        return ParserConfig.create("TC91", fields);
    }
}
