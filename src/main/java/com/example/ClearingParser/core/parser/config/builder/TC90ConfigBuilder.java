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
 * @date - 7/20/2025 at 3:06 PM
 ******************************************
 */

@Component
@Slf4j
public class TC90ConfigBuilder {

    public ParserConfig getTc90Config(){
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("PROCESSING_BIN").position(3).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROCESSING_DATE").position(9).length(5).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(20).length(5).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("RELEASE_NUMBER").position(27).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TEST_OPTION").position(30).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SECURITY_CODE").position(63).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INCOMING_FILE_ID").position(77).length(3).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TC90 configuration with {} fields", fields.size());
        return ParserConfig.create("TC90", fields);
    }

}
