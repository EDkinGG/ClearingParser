package com.example.ClearingParser.core.parser.tc;


import com.example.ClearingParser.common.util.FieldParser;
import com.example.ClearingParser.common.util.ParserUtility;
import com.example.ClearingParser.core.factory.TransactionParser;
import com.example.ClearingParser.core.model.dto.ParsedRecord;
import com.example.ClearingParser.core.model.dto.ParserConfig;
import com.example.ClearingParser.core.model.dto.ParserContext;
import com.example.ClearingParser.core.parser.config.builder.TC46ConfigBuilder;
import com.example.ClearingParser.enumeration.SubReportGroup;
import com.example.ClearingParser.enumeration.TransactionComponentRecord;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 7/29/2025 at 12:52 PM
 ******************************************
 */
@Slf4j
public class TC46Parser implements TransactionParser {

    private final TC46ConfigBuilder configBuilder;
    private final FieldParser fieldParser;

    public TC46Parser() {
        this.configBuilder = new TC46ConfigBuilder();
        this.fieldParser = new FieldParser();
    }

    @Override
    public ParsedRecord parse(String line) {
        log.debug("TC46 Parser parsing line");

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
        return "TC46";
    }

    private ParserConfig getConfiguration(ParserContext context) {
        TransactionComponentRecord tcr = ParserUtility.getTCR(context.getLine());

        switch (tcr) {
            case TCR_0:
                return getTCR0Configuration(context);
            case TCR_1:
                return getTCR1Configuration(context);
            default:
                log.debug("No specific configuration found for TCR: {}, using generic", tcr);
                return null;
        }
    }

    private ParserConfig getTCR0Configuration(ParserContext context) {
        SubReportGroup subReportGroup = ParserUtility.getSubReportGroup(context.getLine());
        switch (subReportGroup) {
            case SUB_GROUP_1:
                return configBuilder.getTcr0SubReport1Config();
            case SUB_GROUP_2:
                return configBuilder.getTcr0SubReport2Config();
            case SUB_GROUP_3:
                return configBuilder.getTcr0SubReport3Config();
            case SUB_GROUP_4:
                return configBuilder.getTcr0SubReport4Config();
            case SUB_GROUP_5:
                return configBuilder.getTcr0SubReport5Config();
            case SUB_GROUP_6:
                return configBuilder.getTcr0SubReport6Config();
            case SUB_GROUP_7:
                return configBuilder.getTcr0SubReport7Config();
            case SUB_GROUP_9:
                return configBuilder.getTcr0SubReport9Config();
            case SUB_GROUP_A:
                return configBuilder.getTcr0SubReportAConfig();
            case SUB_GROUP_B:
                return configBuilder.getTcr0SubReportBConfig();
            case SUB_GROUP_E:
                return configBuilder.getTcr0SubReportEConfig();
            default:
                log.debug("No specific configuration found for Sub report group: {}, using generic", subReportGroup.getVal());
                return null;
        }
    }

    private ParserConfig getTCR1Configuration(ParserContext context) {

        // Check positions for Report4 config
        int[] report4Positions = {57, 74, 91, 108, 125, 142};
        if (Arrays.stream(report4Positions)
                .anyMatch(pos -> isDebitOrCredit(context.getLine(), pos))) {
            return configBuilder.getTcr1Report4Config();
        }

        // Check positions for Report9 config
        int[] report9Positions = {50, 67, 84, 101, 118, 135};
        if (Arrays.stream(report9Positions).anyMatch(pos -> isDebitOrCredit(context.getLine(), pos))) {
            return configBuilder.getTcr1Report9Config();
        }

        return configBuilder.getTcr1Report6Config();
    }

    private boolean isDebitOrCredit(String line, int position) {
        String field = ParserUtility.extractField(line, position, 2);
        return "DB".equals(field) || "CR".equals(field);
    }

}
