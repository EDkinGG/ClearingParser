package com.example.ClearingParser.enumeration.converter;


import com.example.ClearingParser.enumeration.BusinessFormatCode;
import jakarta.persistence.AttributeConverter;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/20/2025 at 5:00 PM
 ******************************************
 */

public class BusinessFormatCodeConverter implements AttributeConverter<BusinessFormatCode, String> {
    @Override
    public String convertToDatabaseColumn(BusinessFormatCode businessFormatCode) {
        if (businessFormatCode == null) {
            return null;
        }
        return businessFormatCode.getVal();
    }

    @Override
    public BusinessFormatCode convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return BusinessFormatCode.getEnumFromValue(s);
    }
}
