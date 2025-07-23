package com.example.ClearingParser.core.factory;

import com.example.ClearingParser.core.parser.tc.*;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TransactionParserFactory {

    private static final Map<String, TransactionParser> transactionParsersMap = new HashMap<>();

    static {
        initializeTransactionParsers();
    }

    private static void initializeTransactionParsers() {

        transactionParsersMap.put("01", new TC01Parser()); // Credit Trx Rejection
        transactionParsersMap.put("02", new TC01Parser()); // Debit Trx Rejection
        transactionParsersMap.put("03", new TC01Parser()); // Non-Trx Rejection

        transactionParsersMap.put("04", new TC04Parser()); // Reclassification Advice

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

        transactionParsersMap.put("10", new TC10Parser()); // clearing fee collection
        transactionParsersMap.put("20", new TC10Parser()); // Funds Disbursement

        transactionParsersMap.put("90", new TC90Parser()); // File Header Records
        transactionParsersMap.put("91", new TC91Parser()); // Batch Trailer
        transactionParsersMap.put("92", new TC91Parser()); // File Trailer
    }

    public static TransactionParser getParser(String tc) {
        log.debug("Selecting parser for TC={}", tc);
        TransactionParser transactionParser = transactionParsersMap.get(tc);
        if (transactionParser == null) {
            log.debug("Parser not available for TC = {}", tc);
            transactionParser = new GenericTCParser();
        }
        log.debug("Using transaction parser: {} for TC{}", transactionParser.getClass().getSimpleName(), tc);
        return transactionParser;
    }

}
