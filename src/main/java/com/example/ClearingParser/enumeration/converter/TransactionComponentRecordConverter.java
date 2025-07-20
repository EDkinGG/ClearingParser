package com.example.ClearingParser.enumeration.converter;


import com.example.ClearingParser.enumeration.TransactionCode;
import com.example.ClearingParser.enumeration.TransactionComponentRecord;
import jakarta.persistence.AttributeConverter;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/20/2025 at 5:04 PM
 ******************************************
 */

public class TransactionComponentRecordConverter implements AttributeConverter<TransactionComponentRecord, String> {
    @Override
    public String convertToDatabaseColumn(TransactionComponentRecord transactionComponentRecord) {
        if (transactionComponentRecord == null) {
            return null;
        }
        return transactionComponentRecord.getVal();
    }

    @Override
    public TransactionComponentRecord convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return TransactionComponentRecord.getEnumFromValue(s);
    }
}
