package com.example.ClearingParser.controller;


import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.service.ParseLineServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/2/2025 at 3:30 PM
 ******************************************
 */

@RestController
@RequestMapping("/v1/parse")
public class TestController {

    private final ParseLineServiceImpl parseLine;

    public TestController(ParseLineServiceImpl parseLine) {
        this.parseLine = parseLine;
    }

    @PostMapping
    public ResponseEntity<ParsedRecord> createEmployee() {
        String line = "05004449390051414351000Z  74777155109001000112058100774170419000000003461840000000004400702Pororo Park              Singapore    SG 799900000     1000D8976121 4 0151100";
//       String line = "0501   A1037    000000                                                        SY477715003034377        0000000000005 5109 0  1U 00                           000000000 C";
//        String line = "0505665109204559625000000004400702          0101 000000000000N                 P           000000000631680C0676364900000000000000000000N             0000000000000000 CM";
        ParsedRecord parsedRecord = parseLine.mapLine(line);
        return ResponseEntity.ok(parsedRecord);
    }

}
