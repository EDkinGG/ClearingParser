package com.example.ClearingParser.core.model.dto;


import com.example.ClearingParser.common.util.ParserUtility;
import lombok.Builder;
import lombok.Data;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/16/2025 at 3:47 PM
 ******************************************
 */

@Data
@Builder
public class ParserContext {
    private String tc;
    private String tcr;
    private String tq;
    private String businessFormatCode;
    private String line;
    private int lineLength;

    public static ParserContext fromLine(String line) {
        if (line == null || line.length() < 2) {
            throw new IllegalArgumentException("Invalid line: too short");
        }

        return ParserContext.builder()
                .line(line)
                .lineLength(line.length())
                .tc(ParserUtility.extractField(line, 1, 2))
                .tcr(line.length() > 3 ? ParserUtility.extractField(line, 4, 1) : "")
                .tq(line.length() > 2 ? ParserUtility.extractField(line, 3, 1) : "")
                .businessFormatCode("") // Will be set conditionally
                .build();
    }
}