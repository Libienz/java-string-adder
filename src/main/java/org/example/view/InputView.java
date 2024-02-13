package org.example.view;

import camp.nextstep.edu.missionutils.Console;
import org.example.domain.Operands;

public class InputView {
    private final InputMapper inputMapper;

    public InputView(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    public Operands readExpression() {
        String operands = Console.readLine();
        return inputMapper.mapToOperands(operands);
    }
}
