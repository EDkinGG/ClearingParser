package com.example.ClearingParser.core.model.dto;


import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/16/2025 at 3:34 PM
 ******************************************
 */

@Data
@Builder
public class ParserConfig {
    private String parserType;
    private List<FieldDefinition> fields;

    public static ParserConfig create( String parserType, List<FieldDefinition> fields) {
        return ParserConfig.builder()
                .parserType(parserType)
                .fields(fields)
                .build();
    }
}

