package com.example.ClearingParser.core.factory;


import com.example.ClearingParser.core.model.dto.ParsedRecord;

public interface RecordParser {
    ParsedRecord parse(String line, String tcr, String tq);
    boolean canHandle(String tc, String tcr, String tq);
}
