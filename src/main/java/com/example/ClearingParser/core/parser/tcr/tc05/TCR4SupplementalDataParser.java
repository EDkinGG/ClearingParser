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
public class TCR4SupplementalDataParser  implements TCRParser {
    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TCR4 SupplementalData");

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));

        parseTCR4Fields(line, record);

        return record;
    }

    @Override
    public boolean canHandleTQ(String tq) {
        boolean tcSupported = tq.matches("^([012])$");
        return tcSupported;
    }

    @Override
    public String getSupportedTCRType() {
        return "4";
    }

    private void parseTCR4Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("AGENT_UNIQUE_ID", ParserUtility.extractField(line, 5, 5));
            record.getFields().put("BUSINESS_FORMAT_CODE_SD", ParserUtility.extractField(line, 15, 2));
            record.getFields().put("NETWORK_IDENTIFICATION_CODE", ParserUtility.extractField(line, 17, 4));
            record.getFields().put("CONTACT_FOR_INFORMATION", ParserUtility.extractField(line, 21, 25).trim());
            record.getFields().put("ADJUSTMENT_PROCESSING_INDICATOR", ParserUtility.extractField(line, 46, 1));
            record.getFields().put("MESSAGE_REASON_CODE", ParserUtility.extractField(line, 47, 4));
            record.getFields().put("SURCHARGE_AMOUNT", ParserUtility.parseAmount(line, 51, 8));
            record.getFields().put("SURCHARGE_CREDIT_DEBIT_INDICATOR", ParserUtility.extractField(line, 59, 2));
            record.getFields().put("VISA_INTERNAL_USE_ONLY", ParserUtility.extractField(line, 61, 16));
            record.getFields().put("SURCHARGE_AMOUNT_BILLING_CURRENCY", ParserUtility.parseAmount(line, 104, 8));
            record.getFields().put("MONEY_TRANSFER_FX_FEE", ParserUtility.parseAmount(line, 112, 8));
            record.getFields().put("PAYMENT_ACCOUNT_REFERENCE", ParserUtility.extractField(line, 120, 29));
            record.getFields().put("TOKEN_REQUESTOR_ID", ParserUtility.extractField(line, 149, 11));

            // Add parser metadata
            record.getFields().put("PARSER_TYPE", "TCR4_SPECIFIC");
            record.getFields().put("TCR_TYPE", "4");

            log.debug("Successfully parsed TCR5 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TCR4 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TCR4 data", e);
        }
    }
}
