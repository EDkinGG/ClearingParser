package com.example.ClearingParser.enumeration.converter;


import com.example.ClearingParser.enumeration.TransactionCode;
import jakarta.persistence.AttributeConverter;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/20/2025 at 4:40 PM
 ******************************************
 */

public class TransactionCodeConverter implements AttributeConverter<TransactionCode, String> {

    @Override
    public String convertToDatabaseColumn(TransactionCode transactionCode) {
        if (transactionCode == null) {
            return null;
        }
        return transactionCode.getVal();
    }

    @Override
    public TransactionCode convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return TransactionCode.getEnumFromValue(s);
    }
}
