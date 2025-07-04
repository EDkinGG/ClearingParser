package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.parser.tcr.tc05.*;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TC05Parser implements TransactionParser {

    private final Map<String, TCRParser> tcrParsersMap = new HashMap<>();

    public TC05Parser() {
        initializeTCRParsers();
    }

    private void initializeTCRParsers() {
        tcrParsersMap.put("0", new TCR0DraftDataParser());
        tcrParsersMap.put("1", new TCR1AdditionalDataParser());
        tcrParsersMap.put("2", new TCR2NationalSettlementParser());
        tcrParsersMap.put("3", new TCR3IndustrySpecificParser());
        tcrParsersMap.put("4", new TCR4SupplementalDataParser());
        tcrParsersMap.put("5", new TCR5PaymentServiceParser());
        tcrParsersMap.put("6", new TCR6LimitedUseParser());
        tcrParsersMap.put("7", new TCR7ChipCardParser());
        tcrParsersMap.put("D", new TCRDInstallmentParser());

        log.debug("TC05Parser initialized with {} TCR parsers", tcrParsersMap.size());
    }

    //Parser Selection
    @Override
    public ParsedRecord parse(String line) {
        String tcr = ParserUtility.extractField(line, 4, 1);
        log.debug("TC05Parser parsing line with TCR = {}", tcr);
        TCRParser tcrParser = tcrParsersMap.get(tcr);
        if (tcrParser != null) {
            log.debug("Using TCR{} specific parser: {}", tcr, tcrParser.getClass().getSimpleName());
            return tcrParser.parse(line);
        }

        //generic TC05 parsing
        log.debug("No specific TCR{} parser found, using generic TC05 parsing", tcr);
        return parseGeneric(line);
    }

    @Override
    public boolean supportsTCR(String tcr) {
        return tcrParsersMap.containsKey(tcr) || canHandleGeneric(tcr);
    }

    @Override
    public String getSupportedTransactionCode() {
        return "05, 06, 07, 15, 16, 17, 25, 26, 27, 35, 36, 37";
    }

    private boolean canHandleGeneric(String tcr) {
        return tcr != null && tcr.length() == 1;
    }

    //Generic Parser
    private ParsedRecord parseGeneric(String line) {

        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(ParserUtility.extractField(line, 1, 2));
        record.setTransactionCodeQualifier(ParserUtility.extractField(line, 3, 1));
        record.setTcr(ParserUtility.extractField(line, 4, 1));
        log.info("Line length={}", line.length());
        if (line.length() > 168) {
            throw new IllegalArgumentException("Invalid line length: " + line.length() + ", expected 168");
        }

        record.getFields().put("RAW_LINE", line);
        record.getFields().put("LINE_LENGTH", String.valueOf(line.length()));
        record.getFields().put("PARSER_TYPE", "GENERIC_TC05");
        record.getFields().put("TCR_TYPE", "GENERIC_TCR");

        log.debug("Generic TC05 parsing completed for TCR{}", record.getTcr());
        return record;
    }
}
