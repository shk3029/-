package Calculator;

import Calculator.Calculator;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
        System.out.println(">>>before");
    }

    @Test
    public void add() {
        System.out.println(calculator.add(1,2));
        assertEquals(9, calculator.add(5,4));
    }

    @Test
    public void substract() {
        System.out.println(calculator.substract(2,1));
        assertEquals(5, calculator.substract(8,3));
    }

    @After
    public void after() {
        System.out.println(">>>after");
    }

}
