package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/3/2025 at 11:43 AM
 ******************************************
 */

@Slf4j
public class TC91Parser implements TransactionParser {
    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TC91/92 TCR0 File Header");

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));
        parseTC91Fields(line, record);

        return record;
    }

    @Override
    public String getSupportedTransactionCode() {
        return "TC91, TC92";
    }

    @Override
    public boolean supportsTCR(String tcr) {
        return tcr.equals("0");
    }


    private void parseTC91Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("BIN", ParserUtility.extractField(line, 5, 6));
            record.getFields().put("PROCESSING_DATE", ParserUtility.extractField(line, 11, 5)); // YYDDD
            record.getFields().put("DESTINATION_AMOUNT", ParserUtility.parseAmount(line, 16, 15));
            record.getFields().put("NUMBER_OF_MONETARY_TRANSACTIONS", ParserUtility.extractField(line, 31, 12));
            record.getFields().put("BATCH_NUMBER", ParserUtility.extractField(line, 43, 6));
            record.getFields().put("NUMBER_OF_TCRS", ParserUtility.extractField(line, 49, 12));
            record.getFields().put("CENTER_BATCH_ID", ParserUtility.extractField(line, 67, 8));
            record.getFields().put("NUMBER_OF_TRANSACTIONS", ParserUtility.extractField(line, 75, 9));
            record.getFields().put("SOURCE_AMOUNT", ParserUtility.parseAmount(line, 102, 15));

            // Add parser metadata
            record.getFields().put("PARSER_TYPE", "TC91_SPECIFIC");
            record.getFields().put("TCR_TYPE", "0");

            log.debug("Successfully parsed TC91/92 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TC91/92 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TC91/92 data", e);
        }
    }
}
