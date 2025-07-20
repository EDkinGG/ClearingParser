package com.example.ClearingParser.common.util;


import com.example.ClearingParser.enumeration.BusinessFormatCode;
import com.example.ClearingParser.enumeration.TransactionCodeQualifier;
import com.example.ClearingParser.enumeration.TransactionComponentRecord;
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

    public static TransactionComponentRecord getTCR(String data){
        return TransactionComponentRecord.getEnumFromValue(extractField(data, 4, 1));
    }

    public static TransactionCodeQualifier getTCQ(String data){
        return TransactionCodeQualifier.getEnumFromValue(extractField(data, 3, 1));
    }

    public static BusinessFormatCode getBusinessFormatCode(String data){
        return BusinessFormatCode.getEnumFromValue(extractField(data, 17, 2));
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
