package com.example.ClearingParser.core.factory;

import com.example.ClearingParser.core.model.dto.ParsedRecord;

public interface TQParser {
    ParsedRecord parseTCR(String line, String tcr, String tq);
}
