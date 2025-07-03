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
public class TCR6LimitedUseParser  implements TCRParser {
    @Override
    public ParsedRecord parse(String line) {
        log.debug("Parsing TCR6 Limited Use");

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));

        parseTCR6Fields(line, record);

        return record;
    }

    @Override
    public boolean canHandle(String tc, String tcr, String tq) {
        return false;
    }

    @Override
    public boolean canHandleTCR(String tcr) {
        return "6".equals(tcr);
    }

    @Override
    public String getSupportedTCRType() {
        return "6";
    }

    private void parseTCR6Fields(String line, ParsedRecord record) {
        try {
            record.getFields().put("LOCAL_TAX", ParserUtility.parseAmount(line, 5, 12));
            record.getFields().put("LOCAL_TAX_INCLUDED", ParserUtility.extractField(line, 17, 1));
            record.getFields().put("NATIONAL_TAX", ParserUtility.parseAmount(line, 18, 12));
            record.getFields().put("NATIONAL_TAX_INCLUDED", ParserUtility.extractField(line, 30, 1));
            record.getFields().put("MERCHANT_VAT_REG_NO", ParserUtility.extractField(line, 31, 20).trim());
            record.getFields().put("CUSTOMER_VAT_REG_NO", ParserUtility.extractField(line, 51, 13).trim());
            record.getFields().put("VISA_MERCHANT_IDENTIFIER", ParserUtility.extractField(line, 64, 8));
            record.getFields().put("SUMMARY_COMMODITY_CODE", ParserUtility.extractField(line, 76, 4));
            record.getFields().put("OTHER_TAX", ParserUtility.parseAmount(line, 80, 12));
            record.getFields().put("MESSAGE_IDENTIFIER", ParserUtility.extractField(line, 92, 15));
            record.getFields().put("TIME_OF_PURCHASE", ParserUtility.extractField(line, 107, 4));
            record.getFields().put("CUSTOMER_CODE", ParserUtility.extractField(line, 111, 17));
            record.getFields().put("NON_FUEL_PRODUCT_CODE_1", ParserUtility.extractField(line, 128, 2));
            record.getFields().put("NON_FUEL_PRODUCT_CODE_2", ParserUtility.extractField(line, 130, 2));
            record.getFields().put("NON_FUEL_PRODUCT_CODE_3", ParserUtility.extractField(line, 132, 2));
            record.getFields().put("NON_FUEL_PRODUCT_CODE_4", ParserUtility.extractField(line, 134, 2));
            record.getFields().put("NON_FUEL_PRODUCT_CODE_5", ParserUtility.extractField(line, 136, 2));
            record.getFields().put("NON_FUEL_PRODUCT_CODE_6", ParserUtility.extractField(line, 138, 2));
            record.getFields().put("NON_FUEL_PRODUCT_CODE_7", ParserUtility.extractField(line, 140, 2));
            record.getFields().put("NON_FUEL_PRODUCT_CODE_8", ParserUtility.extractField(line, 142, 2));
            record.getFields().put("MERCHANT_POSTAL_CODE", ParserUtility.extractField(line, 144, 11));


            // Add parser metadata
            record.getFields().put("PARSER_TYPE", "TCR6_SPECIFIC");
            record.getFields().put("TCR_TYPE", "6");

            log.debug("Successfully parsed TCR5 with {} fields", record.getFields().size());

        } catch (Exception e) {
            log.error("Error parsing TCR6 fields: {}", e.getMessage());
            throw new RuntimeException("Failed to parse TCR6 data", e);
        }
    }
}
