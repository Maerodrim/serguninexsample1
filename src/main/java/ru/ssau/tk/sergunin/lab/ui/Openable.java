package ru.ssau.tk.sergunin.lab.ui;

import javafx.stage.Stage;
import ru.ssau.tk.sergunin.lab.functions.factory.TabulatedFunctionFactory;

interface Openable {
    Stage getStage();

    void setStage(Stage stage);

    void setFactory(TabulatedFunctionFactory factory);

    void setParentController(Openable controller);
}
