package org.example.view;

import java.util.List;
import org.example.domain.Operand;
import org.example.domain.Operands;

public class InputMapper {

    private final InputSplitter inputSplitter;

    public InputMapper(InputSplitter inputSplitter) {
        this.inputSplitter = inputSplitter;
    }

    public Operands mapToOperands(String input) {
        List<String> operands = inputSplitter.splitToOperands(input);
        return Operands.from(operands.stream().map(this::mapToInt).map(Operand::from).toList());
    }

    private Integer mapToInt(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private Operand mapToOperand(Integer operand) {
        return Operand.from(operand);
    }
}
