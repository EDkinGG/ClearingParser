package com.example.ClearingParser.core.factory;

import com.example.ClearingParser.common.exception.UnsupportedParseException;
import com.example.ClearingParser.core.parser.tc.TC05Parser;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RecordParserFactory {

    private static final Map<String, TransactionParser> transactionParsersMap = new HashMap<>();

    static {
        initializeTransactionParsers();
    }

    private static void initializeTransactionParsers() {
        transactionParsersMap.put("05", new TC05Parser());
        transactionParsersMap.put("06", new TC05Parser()); // Credit voucher uses same base parser
        transactionParsersMap.put("07", new TC05Parser()); // Cash disbursement uses same base parser
        transactionParsersMap.put("15", new TC05Parser()); // Dispute financials
        transactionParsersMap.put("16", new TC05Parser());
        transactionParsersMap.put("17", new TC05Parser());
        transactionParsersMap.put("25", new TC05Parser()); // Reversals
        transactionParsersMap.put("26", new TC05Parser());
        transactionParsersMap.put("27", new TC05Parser());
        transactionParsersMap.put("35", new TC05Parser()); // Dispute financial reversals
        transactionParsersMap.put("36", new TC05Parser());
        transactionParsersMap.put("37", new TC05Parser());
    }

    public static RecordParser getParser(String tc, String tcr, String tq) {
        log.debug("Selecting parser for TC={}, TCR={}, TQ={}", tc, tcr, tq);

        // Get the transaction parser which will handle TCR routing internally
        TransactionParser transactionParser = transactionParsersMap.get(tc);
        if (transactionParser == null) {
            log.debug("Parser not available for TC = {}, TCR = {}, TQ = {}", tc, tcr, tq);
            throw new UnsupportedParseException("Parser not available for TC = {}, TCR = {}, TQ = {}", tc, tcr, tq);
        }
        log.debug("Using transaction parser: {} for TC{}", transactionParser.getClass().getSimpleName(), tc);
        return transactionParser;
    }

    public static boolean isSupported(String tc, String tcr, String tq) {
        TransactionParser parser = transactionParsersMap.get(tc);
        return parser != null && parser.canHandle(tc, tcr, tq);
    }
}
