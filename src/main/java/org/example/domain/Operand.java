package org.example.domain;

public class Operand {
    private final Integer operand;

    private Operand(Integer operand) {
        validate(operand);
        this.operand = operand;
    }

    public static Operand from(Integer operand) {
        return new Operand(operand);
    }

    private void validate(Integer operand) {
        validatePositiveNumber(operand);
    }

    private void validatePositiveNumber(Integer operand) {
        if (operand < 0) {
            throw new RuntimeException();
        }
    }
}
