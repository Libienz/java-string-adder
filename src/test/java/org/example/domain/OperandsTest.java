package org.example.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("피연산자 일급 컬렉션 도메인 테스트")
class OperandsTest {

    @DisplayName("덧셈 테스트")
    @Test
    void testSummation() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Operands operands = Operands.from(numbers.stream()
                .map(Operand::from)
                .toList());
        assertThat(operands.calculateSummation()).isEqualTo(21);
    }
}