package com.example.ClearingParser.core.parser.config.builder;

import com.example.ClearingParser.core.model.dto.FieldDefinition;
import com.example.ClearingParser.core.model.dto.ParserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/20/2025 at 2:57 PM
 ******************************************
 */

@Service
@Slf4j
public class TC05ConfigBuilder {

    // ==================== SIMPLE TCR CONFIGURATIONS ====================

    public ParserConfig getTcr0Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("ACCOUNT_NUMBER").position(5).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACCOUNT_NUMBER_EXTENSION").position(21).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FLOOR_LIMIT_INDICATOR").position(24).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CRB_EXCEPTION_FILE_INDICATOR").position(25).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(26).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACQUIRER_REFERENCE_NUMBER").position(27).length(23).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FORMAT_CODE").position(27).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACQUIRING_ID").position(28).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DATE").position(34).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FILM_LOCATOR").position(38).length(11).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CHECK_DIGIT").position(49).length(1).type(FieldDefinition.FieldType.STRING).build(),
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

        log.debug("Created TCR0 configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCR0", fields);
    }

    public ParserConfig getTcr1Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("BUSINESS_FORMAT_CODE").position(5).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TOKEN_ASSURANCE_LEVEL").position(6).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RATE_TABLE_ID").position(8).length(5).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_1").position(13).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RESERVED_2").position(17).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DOCUMENTATION_INDICATOR").position(23).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MEMBER_MESSAGE_TEXT").position(24).length(50).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SPECIAL_CONDITION_INDICATORS").position(74).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FEE_PROGRAM_INDICATOR").position(76).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ISSUER_CHARGE").position(79).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PERSISTENT_FX_APPLIED_INDICATOR").position(80).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CARD_ACCEPTOR_ID").position(81).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TERMINAL_ID").position(96).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NATIONAL_REIMBURSEMENT_FEE").position(104).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("MAIL_PHONE_EC_PAYMENT_INDICATOR").position(116).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SPECIAL_CHARGEBACK_INDICATOR").position(117).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CONVERSION_DATE").position(118).length(4).type(FieldDefinition.FieldType.DATE).build(),
                FieldDefinition.builder().name("ADDITIONAL_TOKEN_RESPONSE_INFO").position(122).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACCEPTANCE_TERMINAL_INDICATOR").position(124).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PREPAID_CARD_INDICATOR").position(125).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SERVICE_DEVELOPMENT_FIELD").position(126).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AVS_RESPONSE_CODE").position(127).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AUTHORIZATION_SOURCE_CODE").position(128).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PURCHASE_IDENTIFIER_FORMAT").position(129).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACCOUNT_SELECTION").position(130).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INSTALLMENT_PAYMENT_COUNT").position(131).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PURCHASE_IDENTIFIER").position(133).length(25).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CASHBACK").position(158).length(9).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("CHIP_CONDITION_CODE").position(167).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("POS_ENVIRONMENT").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR1 configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCR1", fields);
    }

    public ParserConfig getTcr2Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("NATIONAL_SETTLEMENT_DATA_1").position(5).length(12).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("COUNTRY_CODE").position(17).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NATIONAL_SETTLEMENT_DATA_2").position(20).length(147).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR2 configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCR2", fields);
    }

    public ParserConfig getTcr4Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("AGENT_UNIQUE_ID").position(5).length(5).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_FORMAT_CODE_SD").position(15).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NETWORK_IDENTIFICATION_CODE").position(17).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CONTACT_FOR_INFORMATION").position(21).length(25).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ADJUSTMENT_PROCESSING_INDICATOR").position(46).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MESSAGE_REASON_CODE").position(47).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SURCHARGE_AMOUNT").position(51).length(8).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("SURCHARGE_CREDIT_DEBIT_INDICATOR").position(59).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("VISA_INTERNAL_USE_ONLY").position(61).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SURCHARGE_AMOUNT_BILLING_CURRENCY").position(104).length(8).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("MONEY_TRANSFER_FX_FEE").position(112).length(8).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("PAYMENT_ACCOUNT_REFERENCE").position(120).length(29).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TOKEN_REQUESTOR_ID").position(149).length(11).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR4 configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCR4", fields);
    }

    public ParserConfig getTcr5Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("TRANSACTION_IDENTIFIER").position(5).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AUTHORIZED_AMOUNT").position(20).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("AUTHORIZATION_CURRENCY_CODE").position(32).length(3).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("AUTHORIZATION_RESPONSE_CODE").position(35).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("VALIDATION_CODE").position(37).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("EXCLUDED_TRANSACTION_REASON").position(41).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MULTI_CLEARING_SEQUENCE_NUMBER").position(45).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MULTI_CLEARING_SEQUENCE_COUNT").position(47).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MARKET_SPECIFIC_AUTH_DATA_INDICATOR").position(49).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TOTAL_AUTHORIZED_AMOUNT").position(50).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("INFORMATION_INDICATOR").position(62).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_PHONE_NUMBER").position(63).length(14).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ADDITIONAL_DATA_INDICATOR").position(77).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_VOLUME_INDICATOR").position(78).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ECOMMERCE_GOODS_INDICATOR").position(80).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_VERIFICATION_VALUE").position(82).length(10).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("INTERCHANGE_FEE_AMOUNT").position(92).length(15).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("INTERCHANGE_FEE_SIGN").position(107).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SRC_TO_BASE_CURRENCY_RATE").position(108).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BASE_TO_DEST_CURRENCY_RATE").position(116).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("OPTIONAL_ISSUER_ISA_AMOUNT").position(124).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("PRODUCT_ID").position(136).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PROGRAM_ID").position(138).length(6).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("DCC_INDICATOR").position(144).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("ACCOUNT_TYPE_IDENTIFICATION").position(145).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SPEND_QUALIFIED_INDICATOR").position(149).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAN_TOKEN").position(150).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CVV2_RESULT_CODE").position(168).length(1).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR5 configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCR5", fields);
    }

    public ParserConfig getTcr6Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("LOCAL_TAX").position(5).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("LOCAL_TAX_INCLUDED").position(17).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NATIONAL_TAX").position(18).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("NATIONAL_TAX_INCLUDED").position(30).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_VAT_REG_NO").position(31).length(20).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CUSTOMER_VAT_REG_NO").position(51).length(13).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("VISA_MERCHANT_IDENTIFIER").position(64).length(8).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SUMMARY_COMMODITY_CODE").position(76).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("OTHER_TAX").position(80).length(12).type(FieldDefinition.FieldType.NUMERIC).build(),
                FieldDefinition.builder().name("MESSAGE_IDENTIFIER").position(92).length(15).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("TIME_OF_PURCHASE").position(107).length(4).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("CUSTOMER_CODE").position(111).length(17).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NON_FUEL_PRODUCT_CODE_1").position(128).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NON_FUEL_PRODUCT_CODE_2").position(130).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NON_FUEL_PRODUCT_CODE_3").position(132).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NON_FUEL_PRODUCT_CODE_4").position(134).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NON_FUEL_PRODUCT_CODE_5").position(136).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NON_FUEL_PRODUCT_CODE_6").position(138).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NON_FUEL_PRODUCT_CODE_7").position(140).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("NON_FUEL_PRODUCT_CODE_8").position(142).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("MERCHANT_POSTAL_CODE").position(144).length(11).type(FieldDefinition.FieldType.STRING).build()
        );


        log.debug("Created TCR6 configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCR6", fields);
    }

    public ParserConfig getTcr7Config() {
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

        log.debug("Created TCR7 configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCR7", fields);
    }

    // ==================== TCRD CONFIGURATIONS ====================

    public ParserConfig getTcrDTcq0Config() {
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

        log.debug("Created TCRD TCQ0 configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCRD-TCQ0", fields);
    }

    public ParserConfig getTcrDTcq2Config() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("BUSINESS_FORMAT_CODE").position(5).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("RECIPIENT_NAME").position(7).length(30).type(FieldDefinition.FieldType.STRING).trim(true).build()
        );

        log.debug("Created TCRD TQ2 configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCRD-TCQ2", fields);
    }

    // ==================== TCR3 CONFIGURATIONS ====================

    public ParserConfig createTcr3BusinessCrConfig() {
        List<FieldDefinition> fields = Arrays.asList(
                FieldDefinition.builder().name("DEFERRED_OCT_REQUEST_TYPE").position(5).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("FAST_FUNDS_INDICATOR").position(16).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_FORMAT_CODE").position(17).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("BUSINESS_APPLICATION_ID").position(19).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SOURCE_OF_FUNDS").position(21).length(1).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("PAYMENT_REVERSAL_REASON_CODE").position(22).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SENDER_REFERENCE_NUMBER").position(24).length(16).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SENDER_ACCOUNT_NUMBER").position(40).length(34).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SENDER_NAME").position(74).length(30).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SENDER_ADDRESS").position(104).length(35).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SENDER_CITY").position(139).length(25).type(FieldDefinition.FieldType.STRING).trim(true).build(),
                FieldDefinition.builder().name("SENDER_STATE").position(164).length(2).type(FieldDefinition.FieldType.STRING).build(),
                FieldDefinition.builder().name("SENDER_COUNTRY").position(166).length(3).type(FieldDefinition.FieldType.STRING).build()
        );

        log.debug("Created TCR3 Business CR configuration with {} fields", fields.size());
        return ParserConfig.create("TC05-TCR3-CR", fields);
    }
}


