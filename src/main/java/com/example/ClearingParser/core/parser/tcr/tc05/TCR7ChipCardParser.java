package com.example.ClearingParser.core.parser.tcr.tc05;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

/***********************************************
 * @author - Md. Rashedul Ghani
 * @email - rashed.ghani@konasl.com
 * @date - 7/2/2025 at 2:36 PM
 ************************************************
 */

@Slf4j
public class TCR7ChipCardParser  implements TCRParser {
    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TCR7 Chip Card");

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));

        parseTCR7Fields(line, record);

        return record;
    }

    @Override
    public boolean canHandleTQ(String tq) {
        boolean tcSupported = tq.matches("^([012])$");
        return tcSupported;
    }

    @Override
    public String getSupportedTCRType() {
        return "7";
    }

    private void parseTCR7Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("TRANSACTION_TYPE", ParserUtility.extractField(line, 5, 2));
            record.getFields().put("CARD_SEQUENCE_NUMBER", ParserUtility.extractField(line, 7, 3));
            record.getFields().put("TERMINAL_TRANSACTION_DATE", ParserUtility.extractField(line, 10, 6));
            record.getFields().put("TERMINAL_CAPABILITY_PROFILE", ParserUtility.extractField(line, 16, 6));
            record.getFields().put("TERMINAL_COUNTRY_CODE", ParserUtility.extractField(line, 22, 3));
            record.getFields().put("TERMINAL_SERIAL_NUMBER", ParserUtility.extractField(line, 25, 8));
            record.getFields().put("UNPREDICTABLE_NUMBER", ParserUtility.extractField(line, 33, 8));
            record.getFields().put("APPLICATION_TRANSACTION_COUNTER", ParserUtility.extractField(line, 41, 4));
            record.getFields().put("APPLICATION_INTERCHANGE_PROFILE", ParserUtility.extractField(line, 45, 4));
            record.getFields().put("CRYPTOGRAM", ParserUtility.extractField(line, 49, 16));
            record.getFields().put("ISSUER_APP_DATA_BYTE_2", ParserUtility.extractField(line, 65, 2));
            record.getFields().put("ISSUER_APP_DATA_BYTE_3", ParserUtility.extractField(line, 67, 2));
            record.getFields().put("TERMINAL_VERIFICATION_RESULTS", ParserUtility.extractField(line, 69, 10));
            record.getFields().put("ISSUER_APP_DATA_BYTE_4_TO_7", ParserUtility.extractField(line, 79, 8));
            record.getFields().put("CRYPTOGRAM_AMOUNT", ParserUtility.parseAmount(line, 87, 12));
            record.getFields().put("ISSUER_APP_DATA_BYTE_8", ParserUtility.extractField(line, 99, 2));
            record.getFields().put("ISSUER_APP_DATA_BYTE_9_TO_16", ParserUtility.extractField(line, 101, 16));
            record.getFields().put("ISSUER_APP_DATA_BYTE_1", ParserUtility.extractField(line, 117, 2));
            record.getFields().put("ISSUER_APP_DATA_BYTE_17", ParserUtility.extractField(line, 119, 2));
            record.getFields().put("ISSUER_APP_DATA_BYTE_18_TO_32", ParserUtility.extractField(line, 121, 30));
            record.getFields().put("FORM_FACTOR_INDICATOR", ParserUtility.extractField(line, 151, 8));
            record.getFields().put("ISSUER_SCRIPT_1_RESULTS", ParserUtility.extractField(line, 159, 10));


            // Add parser metadata
            record.getFields().put("PARSER_TYPE", "7");
            record.getFields().put("TCR_TYPE", "7");

            log.debug("Successfully parsed TCR7 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TCR7 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TCR7 data", e);
        }
    }
}
