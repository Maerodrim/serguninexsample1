package ru.ssau.tk.sergunin.lab.functions.factory;

import ru.ssau.tk.sergunin.lab.functions.MathFunction;
import ru.ssau.tk.sergunin.lab.functions.tabulatedFunctions.LinkedListTabulatedFunction;
import ru.ssau.tk.sergunin.lab.functions.tabulatedFunctions.TabulatedFunction;
import ru.ssau.tk.sergunin.lab.ui.ConnectableItem;
import ru.ssau.tk.sergunin.lab.ui.Item;

@ConnectableItem(name = "Linked list tabulated function", priority = 2, type = Item.FACTORY)
public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {

    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    @Override
    public TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count) {
        return new LinkedListTabulatedFunction(source, xFrom, xTo, count);
    }

    @Override
    public TabulatedFunction getIdentity() {
        return LinkedListTabulatedFunction.getIdentity();
    }

    @Override
    public Class<?> getTabulatedFunctionClass() {
        return LinkedListTabulatedFunction.class;
    }
}
