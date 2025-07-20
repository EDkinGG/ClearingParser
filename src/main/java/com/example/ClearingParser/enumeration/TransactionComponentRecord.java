package com.example.ClearingParser.enumeration;


import java.util.HashMap;
import java.util.Map;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/20/2025 at 3:33 PM
 ******************************************
 */

public enum TransactionComponentRecord {
    TCR_0("0","TCR 0"),
    TCR_1("1","TCR 1"),
    TCR_2("2","TCR 2"),
    TCR_3("3","TCR 3"),
    TCR_4("4","TCR 4"),
    TCR_5("5","TCR 5"),
    TCR_6("6","TCR 6"),
    TCR_7("7","TCR 7"),
    TCR_8("8","TCR 8"),
    TCR_9("9","TCR 9"),
    TCR_A("A","TCR A"),
    TCR_B("B","TCR B"),
    TCR_D("D","TCR D"),
    TCR_E("E","TCR E")
    ;

    private String value;
    private String name;

    TransactionComponentRecord( String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getVal() { return value; }

    public String getName() { return name; }

    private static final Map<String, TransactionComponentRecord> MAP_VALUES = new HashMap<>();
    private static final Map<String, TransactionComponentRecord> MAP_NAMES = new HashMap<>();

    static {
        for (TransactionComponentRecord type : values()) {
            MAP_VALUES.put(type.value, type);
        }
        for (TransactionComponentRecord type : values()) {
            MAP_NAMES.put(type.name, type);
        }
    }

    public static TransactionComponentRecord getEnumFromValue(String value) {
        return MAP_VALUES.get(value);
    }

    public static TransactionComponentRecord getEnumFromName(String name) {
        return MAP_NAMES.get(name);
    }
}
