package com.example.ClearingParser.core.parser.tcr.tc05;


import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.BusinessSpecificParser;
import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.factory.TQParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.parser.business.TCR3BusinessApplicationData;
import com.example.ClearingParser.core.parser.tq.TCRDTQ0InstallmentPayment;
import com.example.ClearingParser.core.parser.tq.TCRDTQ2OriginalCreditAdditionalData;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/3/2025 at 5:15 PM
 ******************************************
 */

@Slf4j
public class TCR3IndustrySpecificParser implements TCRParser {

    private final Map<String, BusinessSpecificParser> businessParsersMap = new HashMap<>();

    public TCR3IndustrySpecificParser() {
        initializeBusinessParsers();
    }

    private void initializeBusinessParsers() {
        businessParsersMap.put("CR", new TCR3BusinessApplicationData());
        log.debug("TCR3 initialized with {} Business parsers", businessParsersMap.size());
    }

    //Parser Selection
    @Override
    public ParsedRecord parse(String line) {
        String tcr = ParserUtility.extractField(line, 4, 1);
        String businessFormatCode = ParserUtility.extractField(line, 17, 2);
        log.debug("TC05Parser parsing line with TCR={} and BusinessFormatCode={}", tcr, businessFormatCode);

        BusinessSpecificParser businessParser = businessParsersMap.get(businessFormatCode);
        if (businessParser != null) {
            log.debug("Using TCR{} specific parser: {}", tcr, businessParser.getClass().getSimpleName());
            return businessParser.parse(line);
        }
        log.debug("No specific TCR{} parser found", tcr);
        return null;
    }

    @Override
    public String getSupportedTCRType() {
        return "TCR3";
    }

    @Override
    public boolean canHandleTQ(String tq) {
        boolean tcSupported = tq.matches("^([012])$");
        return tcSupported;
    }
}
