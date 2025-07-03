package com.example.ClearingParser.core.parser.tcr.tc05;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

/***********************************************
 * @author - Md. Rashedul Ghani
 * @email - rashed.ghani@konasl.com
 * @date - 7/2/2025 at 2:34 PM
 ************************************************
 */
@Slf4j
public class TCR5PaymentServiceParser  implements TCRParser {
    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TCR5 Payment Service Data");

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));

        parseTCR5Fields(line, record);

        return record;
    }

    @Override
    public boolean canHandle(String tc, String tcr, String tq) {
        return false;
    }

    @Override
    public boolean canHandleTCR(String tcr) {
        return "5".equals(tcr);
    }

    @Override
    public String getSupportedTCRType() {
        return "5";
    }

    private void parseTCR5Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("TRANSACTION_IDENTIFIER", ParserUtility.extractField(line, 5, 15));
            record.getFields().put("AUTHORIZED_AMOUNT", ParserUtility.parseAmount(line, 20, 12));
            record.getFields().put("AUTHORIZATION_CURRENCY_CODE", ParserUtility.extractField(line, 32, 3));
            record.getFields().put("AUTHORIZATION_RESPONSE_CODE", ParserUtility.extractField(line, 35, 2));
            record.getFields().put("VALIDATION_CODE", ParserUtility.extractField(line, 37, 4));
            record.getFields().put("EXCLUDED_TRANSACTION_REASON", ParserUtility.extractField(line, 41, 1));
            record.getFields().put("MULTI_CLEARING_SEQUENCE_NUMBER", ParserUtility.extractField(line, 45, 2));
            record.getFields().put("MULTI_CLEARING_SEQUENCE_COUNT", ParserUtility.extractField(line, 47, 2));
            record.getFields().put("MARKET_SPECIFIC_AUTH_DATA_INDICATOR", ParserUtility.extractField(line, 49, 1));
            record.getFields().put("TOTAL_AUTHORIZED_AMOUNT", ParserUtility.parseAmount(line, 50, 12));
            record.getFields().put("INFORMATION_INDICATOR", ParserUtility.extractField(line, 62, 1));
            record.getFields().put("MERCHANT_PHONE_NUMBER", ParserUtility.extractField(line, 63, 14));
            record.getFields().put("ADDITIONAL_DATA_INDICATOR", ParserUtility.extractField(line, 77, 1));
            record.getFields().put("MERCHANT_VOLUME_INDICATOR", ParserUtility.extractField(line, 78, 2));
            record.getFields().put("ECOMMERCE_GOODS_INDICATOR", ParserUtility.extractField(line, 80, 2));
            record.getFields().put("MERCHANT_VERIFICATION_VALUE", ParserUtility.extractField(line, 82, 10));
            record.getFields().put("INTERCHANGE_FEE_AMOUNT", ParserUtility.parseAmount(line, 92, 15));
            record.getFields().put("INTERCHANGE_FEE_SIGN", ParserUtility.extractField(line, 107, 1));
            record.getFields().put("SRC_TO_BASE_CURRENCY_RATE", ParserUtility.extractField(line, 108, 8));
            record.getFields().put("BASE_TO_DEST_CURRENCY_RATE", ParserUtility.extractField(line, 116, 8));
            record.getFields().put("OPTIONAL_ISSUER_ISA_AMOUNT", ParserUtility.parseAmount(line, 124, 12));
            record.getFields().put("PRODUCT_ID", ParserUtility.extractField(line, 136, 2));
            record.getFields().put("PROGRAM_ID", ParserUtility.extractField(line, 138, 6));
            record.getFields().put("DCC_INDICATOR", ParserUtility.extractField(line, 144, 1));
            record.getFields().put("ACCOUNT_TYPE_IDENTIFICATION", ParserUtility.extractField(line, 145, 4));
            record.getFields().put("SPEND_QUALIFIED_INDICATOR", ParserUtility.extractField(line, 149, 1));
            record.getFields().put("PAN_TOKEN", ParserUtility.extractField(line, 150, 16));
            record.getFields().put("CVV2_RESULT_CODE", ParserUtility.extractField(line, 168, 1));


            // Add parser metadata
            record.getFields().put("PARSER_TYPE", "TCR5_SPECIFIC");
            record.getFields().put("TCR_TYPE", "5");

            log.debug("Successfully parsed TCR5 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TCR5 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TCR5 data", e);
        }
    }
}
