package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.common.util.FieldParser;
import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.model.dto.ParserConfig;
import com.example.ClearingParser.core.model.dto.ParserContext;
import com.example.ClearingParser.core.parser.config.builder.TC05ConfigBuilder;
import com.example.ClearingParser.enumeration.BusinessFormatCode;
import com.example.ClearingParser.enumeration.TransactionCodeQualifier;
import com.example.ClearingParser.enumeration.TransactionComponentRecord;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TC05Parser implements TransactionParser {

    private final TC05ConfigBuilder configBuilder;
    private final FieldParser fieldParser;

    public TC05Parser() {
        this.configBuilder = new TC05ConfigBuilder();
        this.fieldParser = new FieldParser();
    }

    @Override
    public ParsedRecord parse(String line) {
        TransactionComponentRecord tcr = ParserUtility.getTCR(line);
        log.debug("TC05 Parser parsing line with TCR = {}", tcr.getVal());

        ParserContext context = ParserContext.fromLine(line);
        ParserConfig config = getConfigurationByTCR(tcr, line);
        ParsedRecord record = createBaseRecord(context);

        if (config != null) {
            fieldParser.parseFields(context, record, config.getFields());
            log.debug("Parsed using {} configuration", config.getParserType());
        } else {
            parseGeneric(record, context);
        }

        return record;
    }

    @Override
    public String getSupportedTransactionCode() {
        return "";
    }

    @Override
    public boolean supportsTCR(String tcr) {
        return false;
    }

    private ParserConfig getConfigurationByTCR(TransactionComponentRecord tcr, String line) {
        switch (tcr) {
            case TCR_0:
                return configBuilder.createTCR0Config();
            case TCR_1:
                return configBuilder.createTCR1Config();
            case TCR_2:
                return configBuilder.createTCR2Config();
            case TCR_3:
                return getTCR3Configuration(line);
            case TCR_4:
                return configBuilder.createTCR4Config();
            case TCR_5:
                return configBuilder.createTCR5Config();
            case TCR_6:
                return configBuilder.createTCR6Config();
            case TCR_7:
                return configBuilder.createTCR7Config();
            case TCR_D:
                return getTCRDConfiguration(line);
            default:
                log.debug("No specific configuration found for TCR: {}, using generic", tcr);
                return null;
        }
    }

    // ==================== GENERIC PARSING FALLBACK ====================

    private void parseGeneric(ParsedRecord record, ParserContext context) {
        log.info("Line length={}", context.getLineLength());
        if (context.getLineLength() > 168) {
            throw new IllegalArgumentException("Invalid line length: " + context.getLineLength() + ", expected 168");
        }

        record.getFields().put("PARSER_TYPE", "GENERIC_TC05");
        record.getFields().put("TCR_TYPE", "GENERIC_TCR");

        log.debug("Generic TC05 parsing completed for TCR{}", record.getTcr());
    }

    private ParsedRecord createBaseRecord(ParserContext context) {
        ParsedRecord record = new ParsedRecord();
        record.setTransactionCode(context.getTc());
        record.getFields().put("RAW_LINE", context.getLine());
        record.getFields().put("LINE_LENGTH", String.valueOf(context.getLineLength()));
        return record;
    }

    // ==================== COMPLEX TCR CONFIGURATION GETTERS ====================

    private ParserConfig getTCR3Configuration(String line) {
        BusinessFormatCode businessCode = ParserUtility.getBusinessFormatCode(line);

        switch (businessCode) {
            case CR:
                log.debug("Found TCR3 configuration for BusinessCode: CR");
                return configBuilder.createTCR3BusinessCRConfig();
            default:
                log.debug("Using generic TCR3 configuration for BusinessCode: {}", businessCode.getVal());
                return null;
        }
    }

    private ParserConfig getTCRDConfiguration(String line) {
        TransactionCodeQualifier tcq = ParserUtility.getTCQ(line);

        switch (tcq) {
            case TCQ_0:
                log.debug("Found TCRD configuration for TCQ: 0");
                return configBuilder.createTCRDTQ0Config();
            case TCQ_2:
                log.debug("Found TCRD configuration for TCQ: 2");
                return configBuilder.createTCRDTQ2Config();
            default:
                log.debug("Using generic TCRD configuration for TCQ: {}", tcq.getVal());
                return null;
        }
    }
}