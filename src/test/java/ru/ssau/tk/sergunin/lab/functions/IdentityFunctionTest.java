package ru.ssau.tk.sergunin.lab.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IdentityFunctionTest {
    final private double ACCURACY = 0.0001;

    @Test
    public void testApply() {
        MathFunction x = new IdentityFunction();
        assertEquals(x.apply(5), 5, ACCURACY);
    }
}