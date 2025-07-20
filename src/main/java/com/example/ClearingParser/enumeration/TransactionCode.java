package com.example.ClearingParser.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum TransactionCode {

    //Returned Item Transaction
    TC01("01","Transaction Code 01"),
    TC02("02","Transaction Code 02"),
    TC03("03","Transaction Code 01"),

    //Reclassification Advice Transaction
    TC04("04","Transaction Code 04"),

    //Sales Draft data Transactions
    TC05("05","Transaction Code 05"),
    TC06("06","Transaction Code 06"),
    TC07("07","Transaction Code 07"),
    TC15("15","Transaction Code 15"),
    TC16("16","Transaction Code 16"),
    TC17("17","Transaction Code 17"),
    TC25("25","Transaction Code 25"),
    TC26("26","Transaction Code 26"),
    TC27("27","Transaction Code 27"),
    TC35("35","Transaction Code 35"),
    TC36("36","Transaction Code 36"),
    TC37("37","Transaction Code 37"),

    // Base II Clearing Fee Collection trx
    TC10("10","Transaction Code 10"),

    // Funds Disbursement Trx
    TC20("20","Transaction Code 20"),

    // ICS/NARS Input Processing Trx
    TC30("30","Transaction Code 30"),

    //ICS/NARS Response Processing Trx
    TC31("31","Transaction Code 31"),

    //Risk Management Trx
    TC32("32","Transaction Code 32"),

    //Multipurpose Message Transaction
    TC33("33","Transaction Code 33"),

    //VCRFS/VDAS Message Trx
    TC38("38","Transaction Code 38"),

    //VCRFS/VDAS Message trx
    TC39("39","Transaction Code 39"),

    //Fraud Advice Transactions
    TC40("40","Transaction Code 40"),

    //Merchant File Update transactions
    TC42("42","Transaction Code 42"),
    TC43("43","Transaction Code 43"),

    //Collection Batch Acknowledgment Transactions
    TC44("44","Transaction Code 44"),

    //General Delivery Report Transactions
    TC45("45","Transaction Code 45"),

    //Member Settlement Data Transactions
    TC46("46","Transaction Code 46"),

    //Report Generation Record Transactions
    TC47("47","Transaction Code 47"),

    //BASE I Advice Record Transactions
    TC48("48","Transaction Code 48"),

    //Split Batch Acknowledgment Transactions
    TC49("49","Transaction Code 49"),

    //Text Message Transactions
    TC50("50","Transaction Code 50"),

    //Retrieval Request Record Transactions
    TC52("52","Transaction Code 52"),

    //Table Update Record Transactions
    TC54("54","Transaction Code 54"),

    //RCRF Update Record Transactions
    TC55("55","Transaction Code 55"),

    //Currency Conversion Rate Update Record Transactions
    TC56("56","Transaction Code 56"),

    //Data Capture Advice Transactions
    TC57("57","Transaction Code 57"),

    //National Settlement Advice Record Transactions
    TC58("58","Transaction Code 58"),

    //Interface Transaction Advice Record Transactions
    TC59("59","Transaction Code 59"),

    //Header Trailer
    TC90("90","Transaction Code 90"),
    TC91("91","Transaction Code 91"),
    TC92("92","Transaction Code 92");

    private String value;
    private String name;

    TransactionCode( String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getVal() { return value; }

    public String getName() { return name; }

    private static final Map<String, TransactionCode> MAP_VALUES = new HashMap<>();
    private static final Map<String, TransactionCode> MAP_NAMES = new HashMap<>();

    static {
        for (TransactionCode type : values()) {
            MAP_VALUES.put(type.value, type);
        }
        for (TransactionCode type : values()) {
            MAP_NAMES.put(type.name, type);
        }
    }

    public static TransactionCode getEnumFromValue(String value) {
        return MAP_VALUES.get(value);
    }

    public static TransactionCode getEnumFromName(String name) {
        return MAP_NAMES.get(name);
    }
}
