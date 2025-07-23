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
public class TC10ConfigBuilder {
    public ParserConfig getTcr1Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RATE_TABLE_ID").position(5).length(5).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED").position(10).length(159).type(FieldDefinition.FieldType.STRING).trim(true).build()
        );

        log.debug("Created TCR1 configuration with {} fields", fields.size());
        return ParserConfig.create("TC10-TCR1", fields);
    }

    public ParserConfig getTcr4Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_FORMAT_CODE").position(5).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROMOTION_TYPE").position(7).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROMOTION_CODE").position(9).length(25).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NETWORK_IDENTIFICATION_CODE").position(34).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED").position(38).length(131).type(FieldDefinition.FieldType.STRING).trim(true).build()
        );

        log.debug("Created TCR4 configuration with {} fields", fields.size());
        return ParserConfig.create("TC10-TCR4", fields);
    }

    public ParserConfig getTcr0Tcq0Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_ID").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),//DESTINATION_IDENTIFIER
                FieldDefinition.builder().name("ACQUIRER_ID").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),//SOURCE_IDENTIFIER
                FieldDefinition.builder().name("REASON_CODE").position(17).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("COUNTRY_CODE").position(21).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("EVENT_DATE").position(24).length(4).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("ACCOUNT_NUMBER").position(28).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACCOUNT_NUMBER_EXTENSION").position(44).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_AMOUNT").position(47).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("DESTINATION_CURRENCY_CODE").position(59).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_AMOUNT").position(62).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("SOURCE_CURRENCY_CODE").position(74).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FORMAT_CODE").position(77).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACQUIRING_ID").position(78).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DATE").position(84).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FILM_LOCATOR").position(88).length(11).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CHECK_DIGIT").position(99).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BANK_NAME").position(100).length(25).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("BANK_CITY").position(125).length(13).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("MERCHANT_CATEGORY_CODE").position(138).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSFER_TYPE").position(142).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(144).length(3).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SETTLEMENT_FLAG").position(147).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_IDENTIFIER").position(148).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(163).length(1).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("CENTRAL_PROCESSING_DATE").position(164).length(4).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR0 configuration with {} fields", fields.size());
        return ParserConfig.create("TC10-TCR0-TCQ0", fields);
    }

    public ParserConfig getTcr0Tcq1Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_ID").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),//DESTINATION_IDENTIFIER
                FieldDefinition.builder().name("ACQUIRER_ID").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(), //SOURCE_IDENTIFIER
                FieldDefinition.builder().name("REASON_CODE").position(17).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINATOR_COUNTRY_CODE").position(21).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("EVENT_DATE").position(24).length(4).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("ACCOUNT_NUMBER").position(28).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACCOUNT_NUMBER_EXTENSION").position(44).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_AMOUNT").position(47).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("DESTINATION_CURRENCY_CODE").position(59).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_AMOUNT").position(62).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("SOURCE_CURRENCY_CODE").position(74).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINATOR_NAME").position(77).length(25).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("ORIGINATOR_CITY").position(102).length(13).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("ORIGINATOR_ZIP_CODE").position(115).length(5).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINATOR_STATE_PROVINCE_CODE").position(120).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_TELEPHONE_NUMBER").position(123).length(14).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("MERCHANT_VERIFICATION_VALUE").position(137).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_FLAG").position(147).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_IDENTIFIER").position(148).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FUNDING_SOURCE").position(163).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CENTRAL_PROCESSING_DATE").position(164).length(4).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR0 Visa Award configuration with {} fields", fields.size());
        return ParserConfig.create("TC10-TCR0-TCQ1", fields);
    }

}
