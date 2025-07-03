package com.example.ClearingParser.service;


import com.example.ClearingParser.core.factory.RecordParserFactory;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import org.springframework.stereotype.Service;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/2/2025 at 3:34 PM
 ******************************************
 */

@Service
public class ParseLineServiceImpl implements ParseLineService {
    @Override
    public ParsedRecord mapLine(String line) {
        String tc = line.substring(0,2);
        return RecordParserFactory.getParser(tc).parse(line);
    }
}
