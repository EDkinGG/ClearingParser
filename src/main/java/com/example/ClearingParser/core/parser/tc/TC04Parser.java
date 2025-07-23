package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.common.util.FieldParser;
import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.model.dto.ParserConfig;
import com.example.ClearingParser.core.model.dto.ParserContext;
import com.example.ClearingParser.core.parser.config.builder.TC04ConfigBuilder;
import com.example.ClearingParser.enumeration.TransactionComponentRecord;
import lombok.extern.slf4j.Slf4j;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/22/2025 at 12:35 PM
 ******************************************
 */

@Slf4j
public class TC04Parser implements TransactionParser {
    private final TC04ConfigBuilder configBuilder;
    private final FieldParser fieldParser;

    public TC04Parser() {
        this.configBuilder = new TC04ConfigBuilder();
        this.fieldParser = new FieldParser();
    }

    @Override
    public ParsedRecord parse(String line) {
        log.debug("TC04 Parser parsing line");

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
        return "TC04";
    }


    // ==================== COMPLEX TCR CONFIGURATION GETTERS ====================

    private ParserConfig getConfiguration(ParserContext context) {
        TransactionComponentRecord tcr = ParserUtility.getTCR(context.getLine());

        switch (tcr) {
            case TCR_0:
            case TCR_1:
            case TCR_2:
            case TCR_3:
            case TCR_4:
            case TCR_5:
            case TCR_6:
            case TCR_7:
            case TCR_D:
                return configBuilder.getTcr0Config();
            case TCR_9:
                return configBuilder.getTcr9Config();
            default:
                log.debug("No specific configuration found for TCR: {}, using generic", tcr);
                return null;
        }
    }

}
