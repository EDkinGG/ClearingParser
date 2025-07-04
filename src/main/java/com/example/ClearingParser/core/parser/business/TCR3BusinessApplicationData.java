package com.example.ClearingParser.core.parser.business;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.BusinessSpecificParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/3/2025 at 5:09 PM
 ******************************************
 */
@Slf4j
public class TCR3BusinessApplicationData implements BusinessSpecificParser {

    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TCR3 Business Format Code - CR, BusinessApplicationData");
        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));
        parseTCRDTQ0Fields(line, record);
        return record;
    }

    @Override
    public String getSupportedBusinessFormatCode() {
        return "CR";
    }

    private void parseTCRDTQ0Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("DEFERRED_OCT_REQUEST_TYPE", ParserUtility.extractField(line, 5, 2));
            record.getFields().put("FAST_FUNDS_INDICATOR", ParserUtility.extractField(line, 16, 1));
            record.getFields().put("BUSINESS_FORMAT_CODE_CR", ParserUtility.extractField(line, 17, 2));
            record.getFields().put("BUSINESS_APPLICATION_ID", ParserUtility.extractField(line, 19, 2));
            record.getFields().put("SOURCE_OF_FUNDS", ParserUtility.extractField(line, 21, 1));
            record.getFields().put("PAYMENT_REVERSAL_REASON_CODE", ParserUtility.extractField(line, 22, 2));
            record.getFields().put("SENDER_REFERENCE_NUMBER", ParserUtility.extractField(line, 24, 16).trim());
            record.getFields().put("SENDER_ACCOUNT_NUMBER", ParserUtility.extractField(line, 40, 34).trim());
            record.getFields().put("SENDER_NAME", ParserUtility.extractField(line, 74, 30).trim());
            record.getFields().put("SENDER_ADDRESS", ParserUtility.extractField(line, 104, 35).trim());
            record.getFields().put("SENDER_CITY", ParserUtility.extractField(line, 139, 25).trim());
            record.getFields().put("SENDER_STATE", ParserUtility.extractField(line, 164, 2));
            record.getFields().put("SENDER_COUNTRY", ParserUtility.extractField(line, 166, 3));

            // Add parser metadata
            record.getFields().put("PARSER_TYPE", "TCR3Business");
            record.getFields().put("TCR_TYPE", "3");

            log.debug("Successfully parsed TCR3 BusinessFormatCode CR with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TCR3 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TCR3 BusinessFormatCode CR data", e);
        }
    }

}
