package com.example.ClearingParser.enumeration.converter;


import com.example.ClearingParser.enumeration.TransactionCodeQualifier;
import com.example.ClearingParser.enumeration.TransactionComponentRecord;
import jakarta.persistence.AttributeConverter;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/20/2025 at 5:38 PM
 ******************************************
 */

public class TransactionCodeQualifierConverter implements AttributeConverter<TransactionCodeQualifier, String> {

    @Override
    public String convertToDatabaseColumn(TransactionCodeQualifier transactionCodeQualifier) {
        if (transactionCodeQualifier == null) {
            return null;
        }
        return transactionCodeQualifier.getVal();
    }

    @Override
    public TransactionCodeQualifier convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return TransactionCodeQualifier.getEnumFromValue(s);
    }
}
