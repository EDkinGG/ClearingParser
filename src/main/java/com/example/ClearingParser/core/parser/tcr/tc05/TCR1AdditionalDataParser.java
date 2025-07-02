package com.example.ClearingParser.core.parser.tcr.tc05;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

/***********************************************
 * @author - Md. Rashedul Ghani
 * @email - rashed.ghani@konasl.com
 * @date - 7/2/2025 at 2:34 PM
 ************************************************
 */

@Slf4j
public class TCR1AdditionalDataParser  implements TCRParser {
    @Override
    public ParsedRecord parseTCR(String line, String tcr, String tq) {
        log.debug("Parsing TCR1 Additional Data");

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(tq);
        record.setTcr("1");

        parseTCR1Fields(line, record);

        return record;
    }

    @Override
    public boolean canHandleTCR(String tcr) {
        return "1".equals(tcr);
    }

    @Override
    public String getSupportedTCRType() {
        return "1";
    }

    private void parseTCR1Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("BUSINESS_FORMAT_CODE", ParserUtility.extractField(line, 5, 1));
            record.getFields().put("TOKEN_ASSURANCE_LEVEL", ParserUtility.extractField(line, 6, 2));
            record.getFields().put("RATE_TABLE_ID", ParserUtility.extractField(line, 8, 5));
            record.getFields().put("DOCUMENTATION_INDICATOR", ParserUtility.extractField(line, 23, 1));
            record.getFields().put("MEMBER_MESSAGE_TEXT", ParserUtility.extractField(line, 24, 50).trim());
            record.getFields().put("SPECIAL_CONDITION_INDICATORS", ParserUtility.extractField(line, 74, 2));
            record.getFields().put("FEE_PROGRAM_INDICATOR", ParserUtility.extractField(line, 76, 3));
            record.getFields().put("ISSUER_CHARGE", ParserUtility.extractField(line, 79, 1));
            record.getFields().put("PERSISTENT_FX_APPLIED_INDICATOR", ParserUtility.extractField(line, 80, 1));
            record.getFields().put("CARD_ACCEPTOR_ID", ParserUtility.extractField(line, 81, 15));
            record.getFields().put("TERMINAL_ID", ParserUtility.extractField(line, 96, 8));
            record.getFields().put("NATIONAL_REIMBURSEMENT_FEE", ParserUtility.parseAmount(line, 104, 12));
            record.getFields().put("MAIL_PHONE_EC_PAYMENT_INDICATOR", ParserUtility.extractField(line, 116, 1));
            record.getFields().put("SPECIAL_CHARGEBACK_INDICATOR", ParserUtility.extractField(line, 117, 1));
            record.getFields().put("CONVERSION_DATE", ParserUtility.extractField(line, 118, 4));
            record.getFields().put("ADDITIONAL_TOKEN_RESPONSE_INFO", ParserUtility.extractField(line, 122, 1));
            record.getFields().put("ACCEPTANCE_TERMINAL_INDICATOR", ParserUtility.extractField(line, 124, 1));
            record.getFields().put("PREPAID_CARD_INDICATOR", ParserUtility.extractField(line, 125, 1));
            record.getFields().put("SERVICE_DEVELOPMENT_FIELD", ParserUtility.extractField(line, 126, 1));
            record.getFields().put("AVS_RESPONSE_CODE", ParserUtility.extractField(line, 127, 1));
            record.getFields().put("AUTHORIZATION_SOURCE_CODE", ParserUtility.extractField(line, 128, 1));
            record.getFields().put("PURCHASE_IDENTIFIER_FORMAT", ParserUtility.extractField(line, 129, 1));
            record.getFields().put("ACCOUNT_SELECTION", ParserUtility.extractField(line, 130, 1));
            record.getFields().put("INSTALLMENT_PAYMENT_COUNT", ParserUtility.extractField(line, 131, 2));
            record.getFields().put("PURCHASE_IDENTIFIER", ParserUtility.extractField(line, 133, 25));
            record.getFields().put("CASHBACK", ParserUtility.parseAmount(line, 158, 9));
            record.getFields().put("CHIP_CONDITION_CODE", ParserUtility.extractField(line, 167, 1));
            record.getFields().put("POS_ENVIRONMENT", ParserUtility.extractField(line, 168, 1));


            // Add parser metadata
            record.getFields().put("PARSER_TYPE", "TCR1_SPECIFIC");
            record.getFields().put("TCR_TYPE", "1");

            log.debug("Successfully parsed TCR1 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TCR1 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TCR1 data", e);
        }
    }
}
