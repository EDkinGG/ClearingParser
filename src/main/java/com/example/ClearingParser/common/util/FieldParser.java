package com.example.ClearingParser.common.util;


import com.example.ClearingParser.core.model.dto.FieldDefinition;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.model.dto.ParserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/16/2025 at 3:46 PM
 ******************************************
 */

@Component
@Slf4j
public class FieldParser {

    public void parseFields(ParserContext context, ParsedRecord record, List<FieldDefinition> fields) {
        for (FieldDefinition field : fields) {
            try {
                String value = extractFieldValue(context.getLine(), field);
                record.getFields().put(field.getName(), value);
            } catch (Exception e) {
                log.warn("Failed to parse field {}: {}", field.getName(), e.getMessage());
            }
        }
    }

    private String extractFieldValue(String line, FieldDefinition field) {
        if (field.getPosition() < 1 || field.getPosition() > line.length()) {
            return "";
        }

        int endPos = Math.min(field.getPosition() + field.getLength() - 1, line.length());
        String value = line.substring(field.getPosition() - 1, endPos);

        switch (field.getType()) {
            case AMOUNT:
                return ParserUtility.parseAmount(line, field.getPosition(), field.getLength());
            case NUMERIC:
                return value.replaceAll("\\D", "");
            case STRING:
            default:
                return field.isTrim() ? value.trim() : value;
        }
    }
}
