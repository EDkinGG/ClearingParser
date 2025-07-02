package com.example.ClearingParser.core.factory;


/***********************************************
 * @author - Md. Rashedul Ghani
 * @email - rashed.ghani@konasl.com
 * @date - 7/2/2025 at 2:01 PM
 ************************************************
 */

public interface TransactionParser extends RecordParser{
    String getSupportedTransactionCode();
    boolean supportsTCR(String tcr);
}
