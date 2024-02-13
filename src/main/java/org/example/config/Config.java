package org.example.config;

import org.example.controller.StringAdderController;
import org.example.view.InputMapper;
import org.example.view.InputSplitter;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Config {
    public InputView inputView() {
        return new InputView(inputMapper());
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public InputSplitter inputSplitter() {
        return new InputSplitter();
    }

    public InputMapper inputMapper() {
        return new InputMapper(inputSplitter());
    }

    public StringAdderController stringAdderController() {
        return new StringAdderController(inputView(), outputView());
    }
}
