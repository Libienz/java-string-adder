package org.example.domain;

import java.util.List;

public class Operands {

    private final List<Operand> operands;

    private Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public static Operands from(List<Operand> operands) {
        return new Operands(operands);
    }

    public Integer calculateSummation() {
        return operands.stream()
                .mapToInt(Operand::getOperand)
                .sum();
    }
}
