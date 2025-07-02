package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.parser.tcr.tc05.*;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TC05Parser implements TransactionParser {

    // TC05 family manages its own TCR parsers
    private final Map<String, TCRParser> tcrParsersMap = new HashMap<>();

    public TC05Parser() {
        initializeTCRParsers();
    }

    private void initializeTCRParsers() {
        tcrParsersMap.put("0", new TCR0DraftDataParser());
        tcrParsersMap.put("1", new TCR1AdditionalDataParser());
        tcrParsersMap.put("2", new TCR2NationalSettlementParser());
        tcrParsersMap.put("4", new TCR4SupplementalDataParser());
        tcrParsersMap.put("5", new TCR5PaymentServiceParser());
        tcrParsersMap.put("6", new TCR6LimitedUseParser());
        tcrParsersMap.put("7", new TCR7ChipCardParser());
        tcrParsersMap.put("D", new TCRDInstallmentParser());

        log.debug("TC05Parser initialized with {} TCR parsers", tcrParsersMap.size());
    }

    //Parser Selection
    @Override
    public ParsedRecord parse(String line, String tcr, String tq) {
        log.debug("TC05Parser parsing line with TCR={}, TQ={}", tcr, tq);

        // Try TCR-specific parser first
        TCRParser tcrParser = tcrParsersMap.get(tcr);
        if (tcrParser != null) {
            log.debug("Using TCR{} specific parser: {}", tcr, tcrParser.getClass().getSimpleName());
            return tcrParser.parseTCR(line, tcr, tq);
        }

        // Fallback to generic TC05 parsing
        log.debug("No specific TCR{} parser found, using generic TC05 parsing", tcr);
        return parseGeneric(line, tcr, tq);
    }

    //Others
    @Override
    public boolean canHandle(String tc, String tcr, String tq) {
        // Check if this TC05 family transaction is supported
        boolean tcSupported = tc.matches("^(05|06|07|15|16|17|25|26|27|35|36|37)$");
        if (!tcSupported) {
            return false;
        }
        // Check if we have a specific TCR parser or can handle generically
        return tcrParsersMap.containsKey(tcr) || canHandleGeneric(tcr);
    }

    @Override
    public boolean supportsTCR(String tcr) {
        return tcrParsersMap.containsKey(tcr) || canHandleGeneric(tcr);
    }

    @Override
    public String getSupportedTransactionCode() {
        return "05"; // Representative for the family
    }

    private boolean canHandleGeneric(String tcr) {
        // TC05 family can generically handle any TCR even without specific parser
        return tcr != null && tcr.length() == 1;
    }

    //Generic Parser
    private ParsedRecord parseGeneric(String line, String tcr, String tq) {
        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(line.substring(0, 2));
        record.setTransactionCodeQualifier(tq);
        record.setTcr(tcr);

        // Basic validation
        if (line.length() != 168) {
            throw new IllegalArgumentException("Invalid line length: " + line.length() + ", expected 168");
        }

        // Store raw data for later processing
        record.getFields().put("RAW_LINE", line);
        record.getFields().put("LINE_LENGTH", String.valueOf(line.length()));
        record.getFields().put("PARSER_TYPE", "GENERIC_TC05");
        record.getFields().put("TCR_TYPE", tcr);

        log.debug("Generic TC05 parsing completed for TCR{}", tcr);
        return record;
    }
}
