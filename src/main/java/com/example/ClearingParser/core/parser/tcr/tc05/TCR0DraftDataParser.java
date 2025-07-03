package com.example.ClearingParser.core.parser.tcr.tc05;



import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

/***********************************************
 * @author - Md. Rashedul Ghani
 * @email - rashed.ghani@konasl.com
 * @date - 7/2/2025 at 2:18 PM
 ************************************************
 */

@Slf4j
public class TCR0DraftDataParser implements TCRParser {

    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TCR0 Draft Data");

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));

        parseTCR0Fields(line, record);

        return record;
    }

    @Override
    public boolean canHandle(String tc, String tcr, String tq) {
        return false;
    }

    @Override
    public boolean canHandleTCR(String tcr) {
        return "0".equals(tcr);
    }

    @Override
    public String getSupportedTCRType() {
        return "0";
    }

    private void parseTCR0Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("ACCOUNT_NUMBER", ParserUtility.extractField(line, 5, 16));
            record.getFields().put("ACCOUNT_NUMBER_EXTENSION", ParserUtility.extractField(line, 21, 3));
            record.getFields().put("FLOOR_LIMIT_INDICATOR", ParserUtility.extractField(line, 24, 1));
            record.getFields().put("CRB_EXCEPTION_FILE_INDICATOR", ParserUtility.extractField(line, 25, 1));
            record.getFields().put("ACQUIRER_REFERENCE_NUMBER", ParserUtility.extractField(line, 27, 23));
            record.getFields().put("ACQUIRER_BUSINESS_ID", ParserUtility.extractField(line, 50, 8));
            record.getFields().put("PURCHASE_DATE", ParserUtility.extractField(line, 58, 4));

            record.getFields().put("DESTINATION_AMOUNT", ParserUtility.parseAmount(line, 62, 12));
            record.getFields().put("DESTINATION_CURRENCY_CODE", ParserUtility.extractField(line, 74, 3));
            record.getFields().put("SOURCE_AMOUNT", ParserUtility.parseAmount(line, 77, 12));
            record.getFields().put("SOURCE_CURRENCY_CODE", ParserUtility.extractField(line, 89, 3));

            record.getFields().put("MERCHANT_NAME", ParserUtility.extractField(line, 92, 25).trim());
            record.getFields().put("MERCHANT_CITY", ParserUtility.extractField(line, 117, 13).trim());
            record.getFields().put("MERCHANT_COUNTRY_CODE", ParserUtility.extractField(line, 130, 3));
            record.getFields().put("MERCHANT_CATEGORY_CODE", ParserUtility.extractField(line, 133, 4));
            record.getFields().put("MERCHANT_ZIP_CODE", ParserUtility.extractField(line, 137, 5));
            record.getFields().put("MERCHANT_STATE_PROVINCE_CODE", ParserUtility.extractField(line, 142, 3));

            record.getFields().put("REQUESTED_PAYMENT_SERVICE", ParserUtility.extractField(line, 145, 1));
            record.getFields().put("NUMBER_OF_PAYMENT_FORMS", ParserUtility.extractField(line, 146, 1));
            record.getFields().put("USAGE_CODE", ParserUtility.extractField(line, 147, 1));
            record.getFields().put("REASON_CODE", ParserUtility.extractField(line, 148, 2));
            record.getFields().put("SETTLEMENT_FLAG", ParserUtility.extractField(line, 150, 1));
            record.getFields().put("AUTHORIZATION_CHARACTERISTICS_INDICATOR", ParserUtility.extractField(line, 151, 1));
            record.getFields().put("AUTHORIZATION_CODE", ParserUtility.extractField(line, 152, 6));
            record.getFields().put("POS_TERMINAL_CAPABILITY", ParserUtility.extractField(line, 158, 1));
            record.getFields().put("CARDHOLDER_ID_METHOD", ParserUtility.extractField(line, 160, 1));
            record.getFields().put("COLLECTION_ONLY_FLAG", ParserUtility.extractField(line, 161, 1));
            record.getFields().put("POS_ENTRY_MODE", ParserUtility.extractField(line, 162, 2));
            record.getFields().put("CENTRAL_PROCESSING_DATE", ParserUtility.extractField(line, 164, 4));
            record.getFields().put("REIMBURSEMENT_ATTRIBUTE", ParserUtility.extractField(line, 168, 1));

            record.getFields().put("PARSER_TYPE", "TCR0_SPECIFIC");
            record.getFields().put("TCR_TYPE", "0");

            log.debug("Successfully parsed TCR0 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TCR0 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TCR0 data", e);
        }
    }
}
