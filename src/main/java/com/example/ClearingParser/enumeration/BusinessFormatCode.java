package com.example.ClearingParser.enumeration;


import java.util.HashMap;
import java.util.Map;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/20/2025 at 3:34 PM
 ******************************************
 */

public enum BusinessFormatCode {
    CR("CR","Business Application Data"),
    AI("AI","Passenger Itinerary"),
    AN("AN","Passenger Transport Ancillary data"),
    LG("LG","Lodging"),
    CA("CA","Car Rental"),
    FT("FT","Fleet EMV service"),
    FL("FL","Fleet Service"),
    LD("LD","Loan Detail"),
    SD("SD","SMS Data"),
    SP("SP","SMS Data"),
    PD("PD","Promotional Data"),
    DF("DF","Dispute financial"),
    IP("IP","Installment Payment"),
    OC("OC","Original Credit"),
    JA("DF","Europe V.me transactions"),
    ;

    private String value;
    private String name;

    BusinessFormatCode( String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getVal() { return value; }

    public String getName() { return name; }

    private static final Map<String, BusinessFormatCode> MAP_VALUES = new HashMap<>();
    private static final Map<String, BusinessFormatCode> MAP_NAMES = new HashMap<>();

    static {
        for (BusinessFormatCode type : values()) {
            MAP_VALUES.put(type.value, type);
        }
        for (BusinessFormatCode type : values()) {
            MAP_NAMES.put(type.name, type);
        }
    }

    public static BusinessFormatCode getEnumFromValue(String value) {
        return MAP_VALUES.get(value);
    }

    public static BusinessFormatCode getEnumFromName(String name) {
        return MAP_NAMES.get(name);
    }
}
