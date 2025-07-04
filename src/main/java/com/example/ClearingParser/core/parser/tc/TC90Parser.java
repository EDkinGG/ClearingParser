package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/3/2025 at 11:44 AM
 ******************************************
 */
@Slf4j
public class TC90Parser implements TransactionParser {

    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TC90 TCR0 File Header");

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        //record.setTransactionCodeQualifier(tq);
        record.setTcr("0");

        parseTC90Fields(line, record);

        return record;
    }

    @Override
    public String getSupportedTransactionCode() {
        return "TC90";
    }

    @Override
    public boolean supportsTCR(String tcr) {
        return tcr.equals("0");
    }


    private void parseTC90Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("PROCESSING_BIN", ParserUtility.extractField(line, 3, 6));
            record.getFields().put("PROCESSING_DATE", ParserUtility.extractField(line, 9, 5));
            record.getFields().put("SETTLEMENT_DATE", ParserUtility.extractField(line, 20, 5));
            record.getFields().put("RELEASE_NUMBER", ParserUtility.extractField(line, 27, 3));
            record.getFields().put("TEST_OPTION", ParserUtility.extractField(line, 30, 4));
            record.getFields().put("SECURITY_CODE", ParserUtility.extractField(line, 63, 8));
            record.getFields().put("INCOMING_FILE_ID", ParserUtility.extractField(line, 77, 3));

            // Add parser metadata
            record.getFields().put("PARSER_TYPE", "TC90_SPECIFIC");
            record.getFields().put("TCR_TYPE", "0");

            log.debug("Successfully parsed TC90 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TC90 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TC90 data", e);
        }
    }
}
