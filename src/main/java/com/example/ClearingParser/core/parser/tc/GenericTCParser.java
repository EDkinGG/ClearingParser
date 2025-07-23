package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.model.dto.ParserContext;
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
        ParserContext context = ParserContext.fromLine(line);
        record.setTransactionCode(context.getTc());
        log.info("Line length={}", context.getLineLength());
        if (line.length() > 168) {
            throw new IllegalArgumentException("Invalid line length: " + context.getLineLength() + ", expected 168");
        }

        record.getFields().put("RAW_LINE", line);
        record.getFields().put("LINE_LENGTH", String.valueOf(line.length()));
        record.getFields().put("TC_PARSER", "GENERIC");
        record.getFields().put("PARSER_NAME", "GENERIC");

        log.info("Generic TC parsing completed for TC{}", record.getTransactionCode());
        return record;
    }

    @Override
    public String getSupportedTransactionCode() {
        return "ALL";
    }

}
