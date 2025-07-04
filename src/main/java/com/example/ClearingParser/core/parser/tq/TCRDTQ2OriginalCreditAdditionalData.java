package com.example.ClearingParser.core.parser.tq;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TQParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/2/2025 at 6:06 PM
 ******************************************
 */
@Slf4j
public class TCRDTQ2OriginalCreditAdditionalData implements TQParser {
    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TCRD TQ2 Original Credit Additional Data");
        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));
        parseTCRDTQ0Fields(line, record);
        return record;
    }

    private void parseTCRDTQ0Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("BUSINESS_FORMAT_CODE", ParserUtility.extractField(line, 5, 2));
            record.getFields().put("RECIPIENT_NAME", ParserUtility.extractField(line, 7, 30).trim());

            // Add parser metadata
            record.getFields().put("PARSER_TYPE", "D");
            record.getFields().put("TCR_TYPE", "D");

            log.debug("Successfully parsed TCRD TQ2 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TCR7 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TCRD TQ2 data", e);
        }
    }

    @Override
    public String getSupportedTQ() {
        return "TQ2";
    }
}
