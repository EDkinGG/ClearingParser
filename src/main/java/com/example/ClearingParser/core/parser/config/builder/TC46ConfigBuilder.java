package com.example.ClearingParser.core.parser.config.builder;


import com.example.ClearingParser.core.model.dto.FieldDefinition;
import com.example.ClearingParser.core.model.dto.ParserConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/29/2025 at 12:54 PM
 ******************************************
 */

@Slf4j
public class TC46ConfigBuilder {

    public ParserConfig getTcr0SubReport1Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORTING_FOR_SRE_IDENTIFIER").position(17).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_IDENTIFIER").position(27).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(30).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SRE_LEVEL_NUMBER").position(37).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("LAST_CHANGE_DATE").position(38).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(45).length(14).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUBORDINATE_SRE_IDENTIFIER").position(66).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUBORDINATE_SRE_NAME").position(76).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FUNDS_TRANSFER_INDICATOR").position(91).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CLEARING_ENTITY_IDENTIFIER_TYPE").position(92).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CLEARING_ENTITY_IDENTIFIER_1").position(93).length(18).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CLEARING_ENTITY_IDENTIFIER_2").position(111).length(18).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROCESSOR_SPECIFIED_INDICATOR").position(129).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROCESSOR_IDENTIFIER").position(130).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NETWORK_SPECIFIED_INDICATOR").position(140).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NETWORK_IDENTIFIER").position(141).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_CURRENCY").position(145).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CURRENCY_ACQUIRER_PERSPECTIVE").position(148).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CURRENCY_ISSUER_PERSPECTIVE").position(151).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(154).length(14).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );
        log.debug("Created TCR0 Sub Report 1 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReport1", fields);
    }

    public ParserConfig getTcr0SubReport2Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORTING_FOR_SRE_IDENTIFIER").position(17).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ROLLUP_TO_SRE_IDENTIFIER").position(27).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FUNDS_TRANSFER_SRE_IDENTIFIER").position(37).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_IDENTIFIER").position(47).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_CURRENCY_CODE").position(50).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(53).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(54).length(5).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(66).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(73).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FROM_DATE").position(80).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TO_DATE").position(87).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AMOUNT_TYPE").position(94).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_MODE").position(95).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("COUNT").position(96).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CREDIT_AMOUNT").position(111).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("DEBIT_AMOUNT").position(126).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NET_AMOUNT").position(141).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NET_AMOUNT_SIGN").position(156).length(2).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("FUNDS_TRANSFER_DATE").position(158).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(165).length(3).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR0 Sub Report 2 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReport2", fields);
    }


    public ParserConfig getTcr0SubReport3Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORTING_FOR_SRE_IDENTIFIER").position(17).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ROLLUP_TO_SRE_IDENTIFIER").position(27).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FUNDS_TRANSFER_SRE_IDENTIFIER").position(37).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_IDENTIFIER").position(47).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_CURRENCY_CODE").position(50).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AMOUNT_TYPE").position(53).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_MODE").position(54).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(55).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUMMARY_LEVEL").position(56).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("JURISDICTION").position(57).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(66).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(73).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FROM_DATE").position(80).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TO_DATE").position(87).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_TYPE").position(94).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_CYCLE").position(97).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REVERSAL_INDICATOR").position(98).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CREDITS_COUNT").position(99).length(11).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CREDITS_AMOUNT").position(110).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("DEBITS_COUNT").position(125).length(11).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DEBITS_AMOUNT").position(136).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("TOTAL_AMOUNT").position(151).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("TOTAL_AMOUNT_SIGN").position(166).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );
        log.debug("Created TCR0 Sub Report 3 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReport3", fields);
    }

    public ParserConfig getTcr0SubReport4Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORTING_FOR_SRE_IDENTIFIER").position(17).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ROLLUP_TO_SRE_IDENTIFIER").position(27).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FUNDS_TRANSFER_SRE_IDENTIFIER").position(37).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_IDENTIFIER").position(47).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_CURRENCY_CODE").position(50).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CLEARING_CURRENCY_CODE").position(53).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_MODE").position(56).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(57).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(58).length(1).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(66).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(73).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FROM_DATE").position(80).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TO_DATE").position(87).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CHARGE_TYPE_CODE").position(94).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_TYPE").position(97).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_CYCLE").position(100).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REVERSAL_INDICATOR").position(101).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RETURN_INDICATOR").position(102).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("JURISDICTION_CODE").position(103).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INTERREGIONAL_ROUTING_INDICATOR").position(105).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_COUNTRY_CODE").position(106).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_COUNTRY_CODE").position(109).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_REGION_CODE").position(112).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_REGION_CODE").position(114).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FEE_LEVEL_DESCRIPTOR").position(116).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CR_DB_NET_INDICATOR").position(132).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUMMARY_LEVEL").position(133).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(135).length(2).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("RESERVED_3").position(137).length(31).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR0 Sub Report 4 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReport4", fields);
    }

    public ParserConfig getTcr0SubReport5Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORTING_FOR_SRE_IDENTIFIER").position(17).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RECAP_FOR_SRE_IDENTIFIER").position(27).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_IDENTIFIER").position(37).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_CURRENCY_CODE").position(40).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_MODE").position(43).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(44).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(45).length(14).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFIER_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(66).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(73).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TOTAL_INTERCHANGE_COUNT").position(80).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TOTAL_INTERCHANGE_VALUE").position(95).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INTERCHANGE_VALUE_SIGN").position(110).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TOTAL_REIMBURSEMENT_FEES").position(112).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_FEES_SIGN").position(127).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TOTAL_VISA_CHARGES").position(129).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("VISA_CHARGES_SIGN").position(144).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NET_SETTLEMENT_AMOUNT").position(146).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NET_SETTLEMENT_AMOUNT_SIGN").position(161).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUMMARY_LEVEL").position(163).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(165).length(3).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR0 Sub Report 5 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReport5", fields);
    }

    public ParserConfig getTcr0SubReport6Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORTING_FOR_SRE_IDENTIFIER").position(17).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROCESSOR_IDENTIFIER").position(27).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CLEARING_BIN").position(37).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CLEARING_CURRENCY_CODE").position(47).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_IDENTIFIER").position(50).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_MODE").position(53).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(54).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(55).length(4).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(66).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(73).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FINANCIAL_INDICATOR").position(80).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CLEARING_ONLY_INDICATOR").position(81).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_TYPE").position(82).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_CYCLE").position(85).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REVERSAL_INDICATOR").position(86).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_DISPOSITION").position(87).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("COUNT").position(89).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AMOUNT").position(104).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("AMOUNT_SIGN").position(119).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUMMARY_LEVEL").position(121).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CRS_DATE").position(123).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INTERCHANGE_REIMBURSEMENT_FEES").position(130).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INTERCHANGE_REIMBURSEMENT_FEES_SIGN").position(145).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAYMENT_AMOUNT").position(147).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("PAYMENT_AMOUNT_SIGN").position(162).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAYMENT_MODE_SETTLEMENT_TYPE").position(164).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INSTALLMENT_PAYMENT_INDICATOR").position(167).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );
        log.debug("Created TCR0 Sub Report 6 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReport6", fields);
    }

    public ParserConfig getTcr0SubReport7Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_ID").position(17).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_CURRENCY_CODE").position(20).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(23).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(30).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FUNDS_TRANSFER_SRE").position(37).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(47).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_FOR_SRE_VALUE_DATE").position(48).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(58).length(1).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AMOUNT_TYPE").position(66).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CREDIT_AMOUNT").position(67).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("DEBIT_AMOUNT").position(82).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NET_AMOUNT").position(97).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NET_AMOUNT_SIGN").position(112).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("VISA_CHARGES_PROCESSING_FEE").position(114).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("VISA_CHARGES_PROCESSING_FEE_SIGN").position(129).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("COUNT").position(131).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NET_AMOUNT_IN_SETTLEMENT_CURRENCY").position(146).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NET_AMOUNT_IN_SETTLEMENT_CURRENCY_SIGN").position(161).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_BALANCING_CURRENCY_CODE").position(163).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(166).length(2).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR0 Sub Report 7 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReport7", fields);
    }

    public ParserConfig getTcr0SubReport9Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORTING_FOR_SRE_IDENTIFIER").position(17).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ROLLUP_TO_SRE_IDENTIFIER").position(27).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FUNDS_TRANSFER_SRE_IDENTIFIER").position(37).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_IDENTIFIER").position(47).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_CURRENCY_CODE").position(50).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_MODE").position(53).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(54).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(55).length(4).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(66).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(73).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FROM_DATE").position(80).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TO_DATE").position(87).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAYMENT_MODE_SETTLEMENT_TYPE").position(94).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_TYPE").position(97).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_CYCLE").position(100).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TWICE_PAYMENT_NUMBER").position(101).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ORIGINAL_DATE_PROCESSING_DATE").position(102).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUMMARY_LEVEL").position(109).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REVERSAL_INDICATOR").position(111).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INSTALL_PAYMENT_INDICATOR").position(112).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(113).length(55).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR0 Sub Report 9 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReport9", fields);
    }

    public ParserConfig getTcr0SubReportAConfig() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_IDENTIFIER").position(17).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_CURRENCY_CODE").position(20).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(23).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROCESSING_DATE").position(24).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(31).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(38).length(21).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_INDICATOR").position(66).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SRE_ID").position(67).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CLEARING_DATE").position(77).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(84).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_CODE").position(91).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_TRANSACTION_CYCLE").position(94).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REVERSAL_INDICATOR").position(95).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAYMENT_MODE_SETTLEMENT_TYPE").position(96).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("COUNT").position(99).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AMOUNT").position(114).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("AMOUNT_SIGN").position(129).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INPA_TYPE").position(131).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CHARGE_TYPE").position(132).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FEE_DESCRIPTOR").position(135).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(151).length(18).type(FieldDefinition.FieldType.STRING).trim(true).build()
        );

        log.debug("Created TCR0 Sub Report A configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReportA", fields);
    }

    public ParserConfig getTcr0SubReportBConfig() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORTING_FOR_SRE_IDENTIFIER").position(17).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ROLLUP_TO_SRE_IDENTIFIER").position(27).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FUNDS_TRANSFER_SRE_IDENTIFIER").position(37).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_IDENTIFIER").position(47).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(50).length(5).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(55).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(56).length(3).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(66).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(73).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FROM_DATE").position(80).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TO_DATE").position(87).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_1").position(94).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_1").position(97).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_2").position(99).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_2").position(102).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_3").position(104).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_3").position(107).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_4").position(109).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_4").position(112).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_5").position(114).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_5").position(117).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_6").position(119).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_6").position(122).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_7").position(124).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_7").position(127).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_8").position(129).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_8").position(132).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_9").position(134).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_9").position(137).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_10").position(139).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_10").position(142).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_11").position(144).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_11").position(147).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_12").position(149).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_12").position(152).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_13").position(154).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_13").position(157).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_NUMBER_14").position(159).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_REPORT_ID_SUFFIX_14").position(162).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_3").position(164).length(4).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR0 Sub Report B configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReportB", fields);
    }

    public ParserConfig getTcr0SubReportEConfig() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_BIN").position(5).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_BIN").position(11).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_SERVICE_ID").position(17).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_CURRENCY_CODE").position(20).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_DATE").position(23).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_DATE").position(30).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FUNDS_TRANSFER_SRE").position(37).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NO_DATA_INDICATOR").position(47).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("VALUE_DATE").position(48).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(55).length(4).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REPORT_GROUP").position(59).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_SUBGROUP").position(60).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_NUMBER").position(61).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REPORT_IDENTIFICATION_SUFFIX").position(64).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AMOUNT_TYPE").position(66).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CREDIT_AMOUNT").position(67).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("DEBIT_AMOUNT").position(82).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NET_AMOUNT").position(97).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NET_AMOUNT_SIGN").position(112).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROCESSING_DATE").position(114).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FROM_DATE").position(121).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TO_DATE").position(128).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NET_AMOUNT_IN_SETTLEMENT_SERVICE_BALANCE_CURRENCY").position(135).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("NET_AMOUNT_IN_SETTLEMENT_SERVICE_BALANCING_CURRENCY_SIGN").position(150).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(152).length(16).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR0 Sub Report E configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR0-SubReportE", fields);
    }



    public ParserConfig getTcr1Report4Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CURRENCY_TABLE_DATE").position(5).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FIRST_COUNT").position(12).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SECOND_COUNT").position(27).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FIRST_AMOUNT").position(42).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("FIRST_AMOUNT_SIGN").position(57).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SECOND_AMOUNT").position(59).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("SECOND_AMOUNT_SIGN").position(74).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("THIRD_AMOUNT").position(76).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("THIRD_AMOUNT_SIGN").position(91).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FOURTH_AMOUNT").position(93).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("FOURTH_AMOUNT_SIGN").position(108).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FIFTH_AMOUNT").position(110).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("FIFTH_AMOUNT_SIGN").position(125).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SIXTH_AMOUNT").position(127).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("SIXTH_AMOUNT_SIGN").position(142).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED").position(144).length(25).type(FieldDefinition.FieldType.STRING).trim(true).build()
        );

        log.debug("Created TCR1 Sub Report 4 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR1-SubReport4", fields);
    }

    public ParserConfig getTcr1Report6Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FROM_DATE").position(5).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TO_DATE").position(12).length(7).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED").position(19).length(150).type(FieldDefinition.FieldType.STRING).trim(true).build()
        );

        log.debug("Created TCR1 Sub Report 6 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR1-SubReport6", fields);
    }

    public ParserConfig getTcr1Report9Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_CODE").position(1).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_CODE_QUALIFIER").position(3).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TRANSACTION_COMPONENT_SEQUENCE_NUMBER").position(4).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FIRST_COUNT").position(5).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SECOND_COUNT").position(20).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FIRST_AMOUNT").position(35).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("FIRST_AMOUNT_SIGN").position(50).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SECOND_AMOUNT").position(52).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("SECOND_AMOUNT_SIGN").position(67).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("THIRD_AMOUNT").position(69).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("THIRD_AMOUNT_SIGN").position(84).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FOURTH_AMOUNT").position(86).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("FOURTH_AMOUNT_SIGN").position(101).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FIFTH_AMOUNT").position(103).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("FIFTH_AMOUNT_SIGN").position(118).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SIXTH_AMOUNT").position(120).length(15).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("SIXTH_AMOUNT_SIGN").position(135).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED").position(137).length(32).type(FieldDefinition.FieldType.STRING).trim(true).build()
        );

        log.debug("Created TCR1 Sub Report 9 configuration with {} fields", fields.size());
        return ParserConfig.create("TC46-TCR1-SubReport9", fields);
    }


}

