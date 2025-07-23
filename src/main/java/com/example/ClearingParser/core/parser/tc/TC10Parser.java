package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.common.util.FieldParser;
import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.model.dto.ParserConfig;
import com.example.ClearingParser.core.model.dto.ParserContext;
import com.example.ClearingParser.core.parser.config.builder.TC10ConfigBuilder;
import com.example.ClearingParser.enumeration.TransactionCodeQualifier;
import com.example.ClearingParser.enumeration.TransactionComponentRecord;
import lombok.extern.slf4j.Slf4j;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/22/2025 at 12:35 PM
 ******************************************
 */

@Slf4j
public class TC10Parser implements TransactionParser {
    private final TC10ConfigBuilder configBuilder;
    private final FieldParser fieldParser;

    public TC10Parser() {
        this.configBuilder = new TC10ConfigBuilder();
        this.fieldParser = new FieldParser();
    }

    @Override
    public ParsedRecord parse(String line) {
        log.debug("TC10/20 Parser parsing line");

        ParserContext context = ParserContext.fromLine(line);
        ParserConfig config = getConfiguration(context);
        ParsedRecord record = ParserUtility.createBaseRecord(context);

        if (config != null) {
            fieldParser.parseFields(context, record, config);
            log.debug("Parsed using {} configuration", config.getParserName());
        } else {
            ParserUtility.genericFieldParse(record, context);
        }

        return record;
    }

    @Override
    public String getSupportedTransactionCode() {
        return "TC10, TC20";
    }


    // ==================== COMPLEX TCR CONFIGURATION GETTERS ====================

    private ParserConfig getConfiguration(ParserContext context) {
        TransactionComponentRecord tcr = ParserUtility.getTCR(context.getLine());

        switch (tcr) {
            case TCR_0:
                return getTCR0Configuration(context);
            case TCR_1:
                return configBuilder.getTcr1Config();
            case TCR_4:
                return configBuilder.getTcr4Config();
            default:
                log.debug("No specific configuration found for TCR: {}, using generic", tcr);
                return null;
        }
    }

    private ParserConfig getTCR0Configuration(ParserContext context) {
        TransactionCodeQualifier tcq = ParserUtility.getTCQ(context.getLine());

        switch (tcq) {
            case TCQ_0:
                return configBuilder.getTcr0Tcq0Config();
            case TCQ_1:
                return configBuilder.getTcr0Tcq1Config();
            default:
                log.debug("No specific configuration found for TCQ: {}, using generic", tcq.getVal());
                return null;
        }
    }


}
