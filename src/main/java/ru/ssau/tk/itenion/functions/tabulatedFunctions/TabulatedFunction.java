package ru.ssau.tk.itenion.functions.tabulatedFunctions;

import javafx.collections.ObservableList;
import ru.ssau.tk.itenion.enums.Variable;
import ru.ssau.tk.itenion.functions.*;
import ru.ssau.tk.itenion.operations.TabulatedDifferentialOperator;
import ru.ssau.tk.itenion.ui.ExplicitAccessControllable;

import java.util.Objects;
import java.util.Optional;

public interface TabulatedFunction extends MathFunction, TabHolderMathFunction<TabulatedFunction>, Iterable<Point>, ExplicitAccessControllable, Insertable, Removable {

    int getCount();

    double getX(int index);

    double getY(int index);

    void setY(int index, double value);

    void setY(TabulatedFunction function);

    int indexOfX(double x);

    int indexOfY(double y);

    double leftBound();

    double rightBound();

    TabulatedFunction copy();

    boolean isStrict();

    boolean isUnmodifiable();

    TabulatedFunction unwrap();

    default boolean isCanBeComposed(TabulatedFunction function) {
        return Math.abs(leftBound() - function.leftBound()) < 1E-12
                && Math.abs(rightBound() - function.rightBound()) < 1E-12
                && getCount() == function.getCount();
    }

    @Override
    default String getName() {
        if (!Objects.isNull(getMathFunction())) {
            return getMathFunction().getName();
        } else {
            return "TF(x)";
        }
    }

    @Override
    default String getName(Variable variable) {
        if (!Objects.isNull(getMathFunction())) {
            return getMathFunction().getName();
        } else {
            return "TF(" + variable + ")";
        }
    }

    MathFunction getMathFunction();

    void setMathFunction(MathFunction math);

    default boolean isMathFunctionExist() {
        return !Objects.isNull(getMathFunction());
    }

    @Override
    default MathFunction differentiate() {
        return new TabulatedDifferentialOperator().derive(this);
    }

    @Override
    default double[] getDimensionArray(){
        return new double[]{1,1};
    }
}
