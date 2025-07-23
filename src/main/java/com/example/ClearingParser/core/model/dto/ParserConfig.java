package com.example.ClearingParser.core.model.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/16/2025 at 3:34 PM
 ******************************************
 */

@Data
@Builder
public class ParserConfig {
    private String parserName;
    private List<FieldDefinition> fields;

    public static ParserConfig create( String parserName, List<FieldDefinition> fields) {
        return ParserConfig.builder()
                .parserName(parserName)
                .fields(fields)
                .build();
    }
}

