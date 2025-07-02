package com.example.ClearingParser.core.parser.tcr.tc05;


import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/***********************************************
 * @author - Md. Rashedul Ghani
 * @email - rashed.ghani@konasl.com
 * @date - 7/2/2025 at 2:39 PM
 ************************************************
 */

@Slf4j
public class TCRDInstallmentParser  implements TCRParser {
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
        //return parseGeneric(line, tcr, tq);
        return null;
    }

    @Override
    public ParsedRecord parseTCR(String line, String tcr, String tq) {
        return null;
    }

    @Override
    public boolean canHandleTCR(String tcr) {
        return false;
    }

    @Override
    public String getSupportedTCRType() {
        return "";
    }
}
