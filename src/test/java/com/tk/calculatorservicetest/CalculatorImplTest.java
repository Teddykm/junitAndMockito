package com.tk.calculatorservicetest;

import com.tk.calculcatorservice.Calculator;
import com.tk.calculcatorservice.CalculatorImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorImplTest {

    private int num1;
    private int num2;
    private int expectedResult;

    public CalculatorImplTest(int num1,
                              int num2,
                              int expectedResult) {
        this.num1 = num1;
        this.num2 = num2;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Collection<Integer[]> data() {
        return Arrays.asList(new Integer[][]{{-1,2,1}, {1,5,6}, {6,7,13}});
    }

    @Test
    public void addShouldReturnTheRightValue() throws Exception {
        Calculator calculator = new CalculatorImpl();
        int actualResult = calculator.add(num1, num2);
        Assert.assertSame(expectedResult, actualResult);

    }
}
