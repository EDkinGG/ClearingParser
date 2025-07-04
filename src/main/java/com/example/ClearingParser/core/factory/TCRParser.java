package com.example.ClearingParser.core.factory;


import com.example.ClearingParser.core.model.dto.ParsedRecord;

/***********************************************
 * @author - Md. Rashedul Ghani
 * @email - rashed.ghani@konasl.com
 * @date - 7/2/2025 at 2:02 PM
 ************************************************
 */

public interface TCRParser extends RecordParser {
    String getSupportedTCRType();
    boolean canHandleTQ(String tq);
}
