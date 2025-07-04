package com.example.ClearingParser.core.parser.tcr.tc05;


import com.example.ClearingParser.core.factory.TCRParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;

/***********************************************
 * @author - Md. Rashedul Ghani
 * @email - rashed.ghani@konasl.com
 * @date - 7/2/2025 at 2:35 PM
 ************************************************
 */

public class TCR2NationalSettlementParser  implements TCRParser {

    @Override
    public String getSupportedTCRType() {
        return "";
    }

    @Override
    public boolean canHandleTQ(String tq) {
        return false;
    }

    @Override
    public ParsedRecord parse(String line) {
        return null;
    }
}
