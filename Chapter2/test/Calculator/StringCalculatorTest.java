package Calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = null;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }
    @Test
    public void add_널_또는_빈문자() {
        assertEquals(0, stringCalculator.add(null));
        assertEquals(0, stringCalculator.add(""));
    }
    @Test
    public void add_숫자하나() {
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(7, stringCalculator.add("7"));
    }
    @Test
    public void add_쉼표구분자() {
        assertEquals(6, stringCalculator.add("3,3"));
    }
    @Test
    public void add_쉼표_또는_콜론구분자() {
        assertEquals(9, stringCalculator.add("3,3:3"));
    }
    @Test
    public void add_커스텀구분자() {
        assertEquals(13, stringCalculator.add("//&\n3,3,1:2&4"));
    }
    @Test(expected = RuntimeException.class)
    public void 음수_Exception() {
        stringCalculator.add("-1");
    }
    @After
    public void tearDown() {

    }
}