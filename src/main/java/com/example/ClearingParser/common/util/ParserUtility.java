package com.example.ClearingParser.common.util;


import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.model.dto.ParserContext;
import com.example.ClearingParser.enumeration.BusinessFormatCode;
import com.example.ClearingParser.enumeration.TransactionCode;
import com.example.ClearingParser.enumeration.TransactionCodeQualifier;
import com.example.ClearingParser.enumeration.TransactionComponentRecord;
import com.example.ClearingParser.enumeration.SubReportGroup;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

/***********************************************
 * @author - Md. Rashedul Ghani
 * @email - rashed.ghani@konasl.com
 * @date - 7/2/2025 at 2:26 PM
 ************************************************
 */

@Slf4j
public class ParserUtility {

    public static TransactionCode getTC(String data){
        return TransactionCode.getEnumFromValue(extractField(data, 1, 2));
    }

    public static TransactionComponentRecord getTCR(String data){
        return TransactionComponentRecord.getEnumFromValue(extractField(data, 4, 1));
    }

    public static TransactionCodeQualifier getTCQ(String data){
        return TransactionCodeQualifier.getEnumFromValue(extractField(data, 3, 1));
    }

    public static BusinessFormatCode getBusinessFormatCode(String data){
        return BusinessFormatCode.getEnumFromValue(extractField(data, 17, 2));
    }

    public static SubReportGroup getSubReportGroup(String data){
        return SubReportGroup.getEnumFromValue(extractField(data, 60, 1));
    }

    public static ParsedRecord createBaseRecord(ParserContext context){
        ParsedRecord record = new ParsedRecord();

        record.setTransactionCode(context.getTc());
        record.setTcr(ParserUtility.getTCR(context.getLine()).getVal());
        record.setTransactionCodeQualifier(ParserUtility.getTCQ(context.getLine()).getVal());

        record.getFields().put("RAW_LINE", context.getLine());
        record.getFields().put("LINE_LENGTH", String.valueOf(context.getLineLength()));
        record.getFields().put("TC_PARSER", context.getTcParser());
        return record;
    }

    public static void genericFieldParse( ParsedRecord record, ParserContext context) {
        log.info("Line length={}", context.getLineLength());
        if (context.getLineLength() > 168) {
            throw new IllegalArgumentException("Invalid line length: " + context.getLineLength() + ", expected 168");
        }
        record.getFields().put("PARSER_NAME", "GENERIC");
        log.debug("Generic TC05 parsing completed for TCR{}", record.getTcr());
    }

    public static String extractField(String data, int startPos, int length) {
        if (data.length() >= startPos + length - 1) {
            return data.substring(startPos - 1, startPos - 1 + length);
        }
        return "";
    }

    public static String parseAmount(String data, int startPos, int length) {
        String amountStr = extractField(data, startPos, length).trim();
        if (amountStr.isEmpty() || amountStr.matches("^0+$")) {
            return "0.00";
        }
        try {
            BigDecimal amount = new BigDecimal(amountStr);
            BigDecimal result = amount.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
            return result.toString();
        } catch (NumberFormatException e) {
            log.warn("Failed to parse amount: '{}' at position {}", amountStr, startPos);
            return "0.00";
        }
    }
}
