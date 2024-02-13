package org.example.controller;

import org.example.domain.Operands;
import org.example.view.InputView;
import org.example.view.OutputView;

public class StringAdderController {
    private final InputView inputView;
    private final OutputView outputView;

    public StringAdderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Operands operands = inputView.readExpression();
        Integer summation = operands.calculateSummation();
        outputView.printResult(summation);
    }
}
