package com.example.ClearingParser.core.factory;

import com.example.ClearingParser.core.model.dto.ParsedRecord;

public interface TQParser extends RecordParser {
    String getSupportedTQ();
}
