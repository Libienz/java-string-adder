package org.example.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplitter {
    private String delimiter = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public List<String> splitToOperands(String target) {
        return Arrays.stream(target.split(delimiter)).toList();
    }

    private boolean isCustomDelimiterExist(String input) {
        final Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            return true;
        }
        return false;
    }

    private String scanCustomDelimiter(String input) {
        final Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        return m.group(1);
    }

    private void addDelimiter(String input) {
        delimiter += "|" + scanCustomDelimiter(input);
    }
}
