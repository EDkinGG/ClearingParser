package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.common.util.FieldParser;
import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.FieldDefinition;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.model.dto.ParserConfig;
import com.example.ClearingParser.core.model.dto.ParserContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class TC05Parser implements TransactionParser {
    @Override
    public String getSupportedTransactionCode() {
        return "";
    }

    @Override
    public boolean supportsTCR(String tcr) {
        return false;
    }

    private final FieldParser fieldParser = new FieldParser();

    @Override
    public ParsedRecord parse(String line) {
        String tcr = ParserUtility.extractField(line, 4, 1);
        log.debug("TC05Parser parsing line with TCR = {}", tcr);

        // Create context
        ParserContext context = ParserContext.fromLine(line);

        // Get configuration using direct switch-case
        ParserConfig config = getConfigurationByTCR(tcr, context);

        // Create base record
        ParsedRecord record = createBaseRecord(context);

        // Parse using configuration
        if (config != null) {
            fieldParser.parseFields(context, record, config.getFields());
            log.debug("Parsed using {} configuration", config.getParserType());
        } else {
            // Generic parsing fallback
            parseGeneric(record, context);
        }

        return record;
    }

    private ParserConfig getConfigurationByTCR(String tcr, ParserContext context) {
        switch (tcr) {
            case "0":
                return createTCR0Config();

            case "1":
                return createTCR1Config();

            case "2":
                return createTCR2Config();

            case "3":
                return getTCR3Configuration(context);

            case "4":
                return createTCR4Config();

            case "5":
                return createTCR5Config();

            case "6":
                return createTCR6Config();

            case "7":
                return createTCR7Config();

            case "D":
                return getTCRDConfiguration(context);

            default:
                log.debug("No specific configuration found for TCR: {}, using generic", tcr);
                return null;
        }
    }

    // ==================== GENERIC PARSING FALLBACK ====================

    private void parseGeneric(ParsedRecord record, ParserContext context) {
        log.info("Line length={}", context.getLineLength());
        if (context.getLineLength() > 168) {
            throw new IllegalArgumentException("Invalid line length: " + context.getLineLength() + ", expected 168");
        }

        record.getFields().put("PARSER_TYPE", "GENERIC_TC05");
        record.getFields().put("TCR_TYPE", "GENERIC_TCR");

        log.debug("Generic TC05 parsing completed for TCR{}", record.getTcr());
    }

    private ParsedRecord createBaseRecord(ParserContext context) {
        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(context.getTc());

        if (!context.getTq().isEmpty()) {
            record.setTransactionCodeQualifier(context.getTq());
        }

        if (!context.getTcr().isEmpty()) {
            record.setTcr(context.getTcr());
        }

        // Add basic metadata
        record.getFields().put("RAW_LINE", context.getLine());
        record.getFields().put("LINE_LENGTH", String.valueOf(context.getLineLength()));

        return record;
    }

    // ==================== COMPLEX TCR CONFIGURATION GETTERS ====================

    private ParserConfig getTCR3Configuration(ParserContext context) {
        String businessCode = extractBusinessCode(context);

        switch (businessCode) {
            case "CR":
                log.debug("Found TCR3 configuration for BusinessCode: CR");
                return createTCR3BusinessCRConfig();
            default:
                log.debug("Using generic TCR3 configuration for BusinessCode: {}", businessCode);
                return null;
        }
    }

    private ParserConfig getTCRDConfiguration(ParserContext context) {
        String tq = context.getTq();

        switch (tq) {
            case "0":
                log.debug("Found TCRD configuration for TQ: 0");
                return createTCRDTQ0Config();
            case "2":
                log.debug("Found TCRD configuration for TQ: 2");
                return createTCRDTQ2Config();
            default:
                log.debug("Using generic TCRD configuration for TQ: {}", tq);
                return null;
        }
    }

    private String extractBusinessCode(ParserContext context) {
        if ("3".equals(context.getTcr()) && context.getLineLength() > 18) {
            String businessCode = ParserUtility.extractField(context.getLine(), 17, 2);
            context.setBusinessFormatCode(businessCode);
            return businessCode;
        }
        return "";
    }

    // ==================== CONFIGURATION BUILDERS ====================

    private ParserConfig createTCR0Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("ACCOUNT_NUMBER").position(5).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACCOUNT_NUMBER_EXTENSION").position(21).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FLOOR_LIMIT_INDICATOR").position(24).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CRB_EXCEPTION_FILE_INDICATOR").position(25).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACQUIRER_REFERENCE_NUMBER").position(27).length(23).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACQUIRER_BUSINESS_ID").position(50).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PURCHASE_DATE").position(58).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DESTINATION_AMOUNT").position(62).length(12).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("DESTINATION_CURRENCY_CODE").position(74).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_AMOUNT").position(77).length(12).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("SOURCE_CURRENCY_CODE").position(89).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_NAME").position(92).length(25).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("MERCHANT_CITY").position(117).length(13).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("MERCHANT_COUNTRY_CODE").position(130).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_CATEGORY_CODE").position(133).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_ZIP_CODE").position(137).length(5).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_STATE_PROVINCE_CODE").position(142).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REQUESTED_PAYMENT_SERVICE").position(145).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NUMBER_OF_PAYMENT_FORMS").position(146).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("USAGE_CODE").position(147).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REASON_CODE").position(148).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SETTLEMENT_FLAG").position(150).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AUTHORIZATION_CHARACTERISTICS_INDICATOR").position(151).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AUTHORIZATION_CODE").position(152).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("POS_TERMINAL_CAPABILITY").position(158).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CARDHOLDER_ID_METHOD").position(160).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("COLLECTION_ONLY_FLAG").position(161).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("POS_ENTRY_MODE").position(162).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CENTRAL_PROCESSING_DATE").position(164).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("REIMBURSEMENT_ATTRIBUTE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );
        return ParserConfig.create("tcr0", fields);
    }

    private ParserConfig createTCR1Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("ADDITIONAL_DATA_FIELD_1").position(5).length(20).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ADDITIONAL_DATA_FIELD_2").position(25).length(20).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ADDITIONAL_DATA_FIELD_3").position(45).length(20).type(FieldDefinition.FieldType.STRING).build()
        );
        return ParserConfig.create("tcr1", fields);
    }

    private ParserConfig createTCR2Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("NATIONAL_SETTLEMENT_FIELD_1").position(5).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NATIONAL_SETTLEMENT_FIELD_2").position(20).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NATIONAL_SETTLEMENT_FIELD_3").position(35).length(15).type(FieldDefinition.FieldType.STRING).build()
        );
        return ParserConfig.create("tcr2", fields);
    }

    private ParserConfig createTCR4Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("SUPPLEMENTAL_DATA_FIELD_1").position(5).length(25).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUPPLEMENTAL_DATA_FIELD_2").position(30).length(25).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUPPLEMENTAL_DATA_FIELD_3").position(55).length(25).type(FieldDefinition.FieldType.STRING).build()
        );
        return ParserConfig.create("tcr4", fields);
    }

    private ParserConfig createTCR5Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("PAYMENT_SERVICE_FIELD_1").position(5).length(20).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAYMENT_SERVICE_FIELD_2").position(25).length(20).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAYMENT_SERVICE_FIELD_3").position(45).length(20).type(FieldDefinition.FieldType.STRING).build()
        );
        return ParserConfig.create("tcr5", fields);
    }

    private ParserConfig createTCR6Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("LIMITED_USE_FIELD_1").position(5).length(30).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("LIMITED_USE_FIELD_2").position(35).length(30).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("LIMITED_USE_FIELD_3").position(65).length(30).type(FieldDefinition.FieldType.STRING).build()
        );
        return ParserConfig.create("tc06", fields);
    }


    private ParserConfig createTCR7Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_TYPE").position(5).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CARD_SEQUENCE_NUMBER").position(7).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TERMINAL_TRANSACTION_DATE").position(10).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TERMINAL_CAPABILITY_PROFILE").position(16).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TERMINAL_COUNTRY_CODE").position(22).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TERMINAL_SERIAL_NUMBER").position(25).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("UNPREDICTABLE_NUMBER").position(33).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("APPLICATION_TRANSACTION_COUNTER").position(41).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("APPLICATION_INTERCHANGE_PROFILE").position(45).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CRYPTOGRAM").position(49).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_APP_DATA_BYTE_2").position(65).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_APP_DATA_BYTE_3").position(67).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TERMINAL_VERIFICATION_RESULTS").position(69).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_APP_DATA_BYTE_4_TO_7").position(79).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CRYPTOGRAM_AMOUNT").position(87).length(12).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("ISSUER_APP_DATA_BYTE_8").position(99).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_APP_DATA_BYTE_9_TO_16").position(101).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_APP_DATA_BYTE_1").position(117).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_APP_DATA_BYTE_17").position(119).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_APP_DATA_BYTE_18_TO_32").position(121).length(30).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FORM_FACTOR_INDICATOR").position(151).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_SCRIPT_1_RESULTS").position(159).length(10).type(FieldDefinition.FieldType.STRING).build()
        );
        return ParserConfig.create("tcr7", fields);
    }

    private ParserConfig createTCRDTQ0Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("BUSINESS_FORMAT_CODE").position(5).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INSTALLMENT_TOTAL_AMOUNT").position(7).length(12).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("INSTALLMENT_CURRENCY_CODE").position(19).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NUMBER_OF_INSTALLMENTS").position(22).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AMOUNT_PER_INSTALLMENT").position(25).length(12).type(FieldDefinition.FieldType.AMOUNT).build(),
                FieldDefinition.builder().name("INSTALLMENT_PAYMENT_NUMBER").position(37).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INSTALLMENT_FREQUENCY").position(40).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PLAN_OWNER").position(41).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PLAN_REGISTRATION_SYSTEM_ID").position(43).length(10).type(FieldDefinition.FieldType.STRING).build()
        );
        return ParserConfig.create("tcrdtq0", fields);
    }

    private ParserConfig createTCRDTQ2Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("BUSINESS_FORMAT_CODE").position(5).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RECIPIENT_NAME").position(7).length(30).type(FieldDefinition.FieldType.STRING).trim(true).build()
        );
        return ParserConfig.create("tcrdtq2", fields);
    }

    private ParserConfig createTCR3BusinessCRConfig() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("DEFERRED_OCT_REQUEST_TYPE").position(5).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FAST_FUNDS_INDICATOR").position(16).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_FORMAT_CODE_CR").position(17).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_APPLICATION_ID").position(19).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_OF_FUNDS").position(21).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAYMENT_REVERSAL_REASON_CODE").position(22).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SENDER_REFERENCE_NUMBER").position(24).length(16).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SENDER_ACCOUNT_NUMBER").position(40).length(34).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SENDER_NAME").position(74).length(30).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SENDER_ADDRESS").position(104).length(35).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SENDER_CITY").position(139).length(25).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SENDER_STATE").position(164).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SENDER_COUNTRY").position(166).length(3).type(FieldDefinition.FieldType.STRING).build()
        );
        return ParserConfig.create("tc05tcr3CR", fields);
    }
}