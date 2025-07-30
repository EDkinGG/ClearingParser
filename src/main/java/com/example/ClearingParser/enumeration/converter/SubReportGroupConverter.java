package com.example.ClearingParser.enumeration.converter;


import com.example.ClearingParser.enumeration.BusinessFormatCode;
import com.example.ClearingParser.enumeration.SubReportGroup;
import jakarta.persistence.AttributeConverter;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/30/2025 at 12:36 PM
 ******************************************
 */

public class SubReportGroupConverter  implements AttributeConverter<SubReportGroup, String> {
    @Override
    public String convertToDatabaseColumn(SubReportGroup subReportGroup) {
        if (subReportGroup == null) {
            return null;
        }
        return subReportGroup.getVal();
    }

    @Override
    public SubReportGroup convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return SubReportGroup.getEnumFromValue(s);
    }
}