package org.example.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputSplitterTest {
    private InputSplitter inputSplitter;

    @BeforeEach
    void setUp() {
        inputSplitter = new InputSplitter();
    }

    @DisplayName("쉼표를 기반으로 구분할 수 있다")
    @Test
    void testSplitByComma() {
        String input = "10,20,30";
        List<String> operands = inputSplitter.splitToOperands(input);
        assertThat(operands).containsExactly("10", "20", "30");
    }

    @DisplayName("콜론을 기반으로 구분할 수 있다")
    @Test
    void testSplitByColon() {
        String input = "10:20:30";
        List<String> operands = inputSplitter.splitToOperands(input);
        assertThat(operands).containsExactly("10", "20", "30");
    }

    @DisplayName("쉼표와 콜론을 기반으로 구분할 수 있다")
    @Test
    void testSplitByColonAndComma() {
        String input = "10:20,30";
        List<String> operands = inputSplitter.splitToOperands(input);
        assertThat(operands).containsExactly("10", "20", "30");
    }

    @DisplayName("쉼표와 콜론, 그리고 커스텀 구분자를 기반으로 구분할 수 있다")
    @Test
    void testSplitByColonAndCommaAndCustom() {
        String input = "//;\n10;20:30,40";
        List<String> operands = inputSplitter.splitToOperands(input);
        assertThat(operands).containsExactly("10", "20", "30", "40");
    }
}