package com.example.ClearingParser.controller;


import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.service.ParseLineServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
    public ResponseEntity<List<ParsedRecord>> createEmployee() throws IOException {
        String filePath = "src/main/resources/ctf/test.txt";
        List<ParsedRecord> parsedRecords = new ArrayList<>();
        List<String> lines = readFileWithStreams(filePath);
        for(String line: lines){
            ParsedRecord parsedRecord = parseLine.mapLine(line);
            parsedRecords.add(parsedRecord);
        }
        return ResponseEntity.ok(parsedRecords);
    }

    public List<String> readFileWithStreams(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .peek(line -> System.out.println("Read line: " + line))
                    .toList();
        }
    }

}
