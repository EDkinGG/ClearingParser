package com.example.ClearingParser.core.model.dto;


import lombok.Builder;
import lombok.Data;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/16/2025 at 3:34 PM
 ******************************************
 */

@Data
@Builder
public class FieldDefinition {
    private String name;
    private int position;
    private int length;
    private FieldType type;
    private boolean trim;

    public enum FieldType {
        STRING, AMOUNT, NUMERIC, DATE
    }
}

