package com.example.ClearingParser.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum TransactionCodeQualifier {

    TCQ_0("0","Default TQ"),
    TCQ_1("1","Account Funding Transaction"),
    TCQ_2("2","Original Credit Transaction")
    ;

    private String value;
    private String name;

    TransactionCodeQualifier(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getVal() { return value; }

    public String getName() { return name; }

    private static final Map<String, TransactionCodeQualifier> MAP_VALUES = new HashMap<>();
    private static final Map<String, TransactionCodeQualifier> MAP_NAMES = new HashMap<>();

    static {
        for (TransactionCodeQualifier type : values()) {
            MAP_VALUES.put(type.value, type);
        }
        for (TransactionCodeQualifier type : values()) {
            MAP_NAMES.put(type.name, type);
        }
    }

    public static TransactionCodeQualifier getEnumFromValue(String value) {
        return MAP_VALUES.get(value);
    }

    public static TransactionCodeQualifier getEnumFromName(String name) {
        return MAP_NAMES.get(name);
    }
}
