package org.example.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplitter {
    private String delimiter = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String REMOVE_PATTERN = "//.*\n";

    public List<String> splitToOperands(String target) {
        String customDelimiter = scanCustomDelimiter(target);
        addDelimiter(customDelimiter);
        String operands = removeCustomDelimiterPattern(target);
        return Arrays.stream(operands.split(delimiter)).toList();
    }

    private String scanCustomDelimiter(String input) {
        final Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    private void addDelimiter(String customDelimiter) {
        if (customDelimiter == "") {
            return;
        }
        delimiter += "|" + customDelimiter;
    }

    private String removeCustomDelimiterPattern(String input) {
        final Matcher m = Pattern.compile(REMOVE_PATTERN).matcher(input);
        if (m.find()) {
            return m.replaceAll("");
        }
        return input;
    }
}
