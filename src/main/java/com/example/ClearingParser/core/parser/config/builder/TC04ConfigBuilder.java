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
public class TC04ConfigBuilder {
    public ParserConfig getTcr0Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CONTENTS_OF_RECLASSIFIED_TCR").position(5).length(164).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TC04 configuration with {} fields", fields.size());
        return ParserConfig.create("TC04-TCR0", fields);
    }

    public ParserConfig getTcr9Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_ID").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),//DESTINATION_IDENTIFIER
                FieldDefinition.builder().name("ACQUIRER_ID").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),//SOURCE_IDENTIFIER
                FieldDefinition.builder().name("ORIGINAL_TRANSACTION_CODE").position(17).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINAL_TRANSACTION_CODE_QUALIFIER").position(19).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINAL_TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(20).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BATCH_DATE").position(21).length(5).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("SOURCE_BATCH_NUMBER").position(26).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ITEM_SEQUENCE_NUMBER").position(32).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PRODUCT_RECLASSIFICATION_REASON").position(36).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLED_PRODUCT_ID").position(39).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLED_SPEND_QUALIFIED_INDICATOR").position(41).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(42).length(26).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(68).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLED_AUTHORIZATION_CHARACTERISTICS_INDICATOR").position(69).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLED_REQUESTED_PAYMENT_SERVICE").position(70).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLED_REIMBURSEMENT_ATTRIBUTE").position(71).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DERIVED_IRF_DESCRIPTOR").position(72).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLED_IRF_DESCRIPTOR").position(88).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAYMENT_SERVICE_RECLASSIFICATION_REASON").position(104).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FEE_RECLASSIFICATION_REASON").position(107).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_VOLUME_RECLASSIFICATION_REASON").position(110).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUBMITTED_FEE_PROGRAM_INDICATOR").position(113).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ASSESSED_FEE_PROGRAM_INDICATOR").position(116).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FEE_PROGRAM_INDICATOR_RECLASSIFICATION_REASON").position(119).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MOTO_ECI_RECLASSIFICATION_REASON").position(122).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INTERCHANGE_FEE_AMOUNT").position(125).length(15).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("INTERCHANGE_FEE_SIGN").position(140).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_INTEGRITY_FEE_RECLASSIFICATION_REASON").position(141).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SPEND_QUALIFIED_INDICATOR_RECLASSIFICATION_REASON").position(144).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_3").position(147).length(22).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR9 configuration with {} fields", fields.size());
        return ParserConfig.create("TC04-TCR9", fields);
    }
}
