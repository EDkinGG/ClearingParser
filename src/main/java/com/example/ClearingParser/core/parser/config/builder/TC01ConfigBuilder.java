package com.example.ClearingParser.core.parser.config.builder;


import com.example.ClearingParser.core.model.dto.FieldDefinition;
import com.example.ClearingParser.core.model.dto.ParserConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/22/2025 at 12:37 PM
 ******************************************
 */
@Slf4j
public class TC01ConfigBuilder {

    public ParserConfig getTcr0Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TCR_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CONTENTS_OF_RETURNED_TCR").position(5).length(164).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created Returned Item configuration with {} fields", fields.size());
        return ParserConfig.create("TC01-TCR0", fields);
    }

    public ParserConfig getTcr9Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_ID").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(), //DESTINATION_IDENTIFIER
                FieldDefinition.builder().name("ACQUIRER_ID").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(), //SOURCE_IDENTIFIER
                FieldDefinition.builder().name("ORIGINAL_TRANSACTION_CODE").position(17).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINAL_TRANSACTION_CODE_QUALIFIER").position(19).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINAL_TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(20).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BATCH_DATE").position(21).length(5).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("SOURCE_BATCH_NUMBER").position(26).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ITEM_SEQUENCE_NUMBER").position(32).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RETURN_REASON_CODE_1").position(36).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINAL_SOURCE_AMOUNT").position(39).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("ORIGINAL_SOURCE_CURRENCY").position(51).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINAL_SETTLEMENT_FLAG").position(54).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CRS_RETURN_FLAG").position(55).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RETURN_REASON_CODE_2").position(56).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RETURN_REASON_CODE_3").position(59).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RETURN_REASON_CODE_4").position(62).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RETURN_REASON_CODE_5").position(65).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED").position(68).length(101).type(FieldDefinition.FieldType.STRING).trim(true).build()
        );

        log.debug("Created Returned Item TCR9 configuration with {} fields", fields.size());
        return ParserConfig.create("TC01-TCR9", fields);
    }

}
