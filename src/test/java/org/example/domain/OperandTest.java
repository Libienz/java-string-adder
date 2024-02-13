package org.example.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("피연산자 테스트")
class OperandTest {
    @DisplayName("음수 입력은 생성 시 검증에 실패한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -999})
    void testNegativeOperandCreation(Integer operand) {
        assertThatThrownBy(() -> Operand.from(operand))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("음이 아닌 정수 입력은 생성 시 검증에 성공한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 999})
    void testNonNegativeOperandCreation(Integer operand) {
        assertThatNoException()
                .isThrownBy(() -> Operand.from(operand));
    }
}