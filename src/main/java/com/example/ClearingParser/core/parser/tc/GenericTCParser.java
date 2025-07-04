package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.RecordParser;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/4/2025 at 10:02 AM
 ******************************************
 */

@Slf4j
public class GenericTCParser implements TransactionParser {

    @Override
    public ParsedRecord parse(String line) {
        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        log.info("Line length={}", line.length());
        if (line.length() > 168) {
            throw new IllegalArgumentException("Invalid line length: " + line.length() + ", expected 168");
        }

        record.getFields().put("RAW_LINE", line);
        record.getFields().put("LINE_LENGTH", String.valueOf(line.length()));
        record.getFields().put("PARSER_TYPE", "GENERIC");
        record.getFields().put("TCR_TYPE", "GENERIC");

        log.info("Generic TC parsing completed for TC{}", record.getTransactionCode());
        return record;
    }

    @Override
    public String getSupportedTransactionCode() {
        return "ALL";
    }

    @Override
    public boolean supportsTCR(String tcr) {
        return true;
    }
}
