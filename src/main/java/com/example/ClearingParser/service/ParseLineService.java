package com.example.ClearingParser.service;

import com.example.ClearingParser.core.model.dto.ParsedRecord;

public interface ParseLineService {
    public ParsedRecord mapLine(String line);
}
