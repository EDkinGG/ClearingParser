package com.example.ClearingParser.common.exception;

public class UnsupportedParseException extends RuntimeException {
    public UnsupportedParseException(String s, String message) {
        super(message);
    }

    public UnsupportedParseException(String message, String tc, String tcr, String tq) {
    }
}
