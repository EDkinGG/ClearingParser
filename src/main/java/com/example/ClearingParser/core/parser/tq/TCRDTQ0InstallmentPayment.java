package com.example.ClearingParser.core.parser.tq;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TQParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/2/2025 at 6:04 PM
 ******************************************
 */

@Slf4j
public class TCRDTQ0InstallmentPayment implements TQParser {
    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TCRDTQ0 Installment Payment");

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));
        parseTCRDTQ0Fields(line, record);

        return record;
    }

    @Override
    public boolean canHandle(String tc, String tcr, String tq) {
        return false;
    }

    private void parseTCRDTQ0Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("BUSINESS_FORMAT_CODE", ParserUtility.extractField(line, 5, 2));
            record.getFields().put("INSTALLMENT_TOTAL_AMOUNT", ParserUtility.parseAmount(line, 7, 12));
            record.getFields().put("INSTALLMENT_CURRENCY_CODE", ParserUtility.extractField(line, 19, 3));
            record.getFields().put("NUMBER_OF_INSTALLMENTS", ParserUtility.extractField(line, 22, 3));
            record.getFields().put("AMOUNT_PER_INSTALLMENT", ParserUtility.parseAmount(line, 25, 12));
            record.getFields().put("INSTALLMENT_PAYMENT_NUMBER", ParserUtility.extractField(line, 37, 3));
            record.getFields().put("INSTALLMENT_FREQUENCY", ParserUtility.extractField(line, 40, 1));
            record.getFields().put("PLAN_OWNER", ParserUtility.extractField(line, 41, 2));
            record.getFields().put("PLAN_REGISTRATION_SYSTEM_ID", ParserUtility.extractField(line, 43, 10));

            //metadata
            record.getFields().put("PARSER_TYPE", "D");
            record.getFields().put("TCR_TYPE", "D");

            log.debug("Successfully parsed TCRD TQ0 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TCRD TQ0 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TCRD TQ0 data", e);
        }
    }

    @Override
    public String getSupportedTQType() {
        return "";
    }

    @Override
    public boolean canHandleTQ(String tq) {
        return false;
    }
}
