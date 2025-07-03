package com.example.ClearingParser.core.parser.tcr.tc05;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.factory.TQParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.parser.tq.TCRDTQ0InstallmentPayment;
import com.example.ClearingParser.core.parser.tq.TCRDTQ2OriginalCreditAdditionalData;
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

    private final Map<String, TQParser> tqParsersMap = new HashMap<>();

    public TCRDInstallmentParser() {
        initializeTQParsers();
    }

    private void initializeTQParsers() {
        tqParsersMap.put("0", new TCRDTQ0InstallmentPayment());
        tqParsersMap.put("2", new TCRDTQ2OriginalCreditAdditionalData());

        log.debug("TCRDParser initialized with {} TQ parsers", tqParsersMap.size());
    }

    //Parser Selection
    @Override
    public ParsedRecord parse(String line) {
        String tcr = ParserUtility.extractField(line, 3, 1);
        String tq = ParserUtility.extractField(line, 3, 1);
        log.debug("TC05Parser parsing line with TCR={} and TQ={}", tcr, tq);

        TQParser tqParser = tqParsersMap.get(tq);
        if (tqParser != null) {
            log.debug("Using TCR{} specific parser: {}", tcr, tqParser.getClass().getSimpleName());
            return tqParser.parse(line);
        }
        log.debug("No specific TCR{} parser found, using generic TC05 parsing", tcr);
        return null;
    }

    @Override
    public boolean canHandle(String tc, String tcr, String tq) {
        return false;
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
