package com.example.ClearingParser.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum SubReportGroup {
    SUB_GROUP_1("1","Sub Report Group 1"),
    SUB_GROUP_2("2","Sub Report Group 2"),
    SUB_GROUP_3("3","Sub Report Group 3"),
    SUB_GROUP_4("4","Sub Report Group 4"),
    SUB_GROUP_5("5","Sub Report Group 5"),
    SUB_GROUP_6("6","Sub Report Group 6"),
    SUB_GROUP_7("7","Sub Report Group 7"),
    SUB_GROUP_9("9","Sub Report Group 9"),
    SUB_GROUP_A("A","Sub Report Group A"),
    SUB_GROUP_B("B","Sub Report Group B"),
    SUB_GROUP_E("E","Sub Report Group E"),
    ;

    private String value;
    private String name;

    SubReportGroup( String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getVal() { return value; }

    public String getName() { return name; }

    private static final Map<String, SubReportGroup> MAP_VALUES = new HashMap<>();
    private static final Map<String, SubReportGroup> MAP_NAMES = new HashMap<>();

    static {
        for (SubReportGroup type : values()) {
            MAP_VALUES.put(type.value, type);
        }
        for (SubReportGroup type : values()) {
            MAP_NAMES.put(type.name, type);
        }
    }

    public static SubReportGroup getEnumFromValue(String value) {
        return MAP_VALUES.get(value);
    }

    public static SubReportGroup getEnumFromName(String name) {
        return MAP_NAMES.get(name);
    }
}
