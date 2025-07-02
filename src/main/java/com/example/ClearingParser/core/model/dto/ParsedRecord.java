package com.example.ClearingParser.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParsedRecord {
    private String transactionCode;
    private String transactionCodeQualifier;
    private String tcr;
    private Map<String, String> fields = new HashMap<>();
}
