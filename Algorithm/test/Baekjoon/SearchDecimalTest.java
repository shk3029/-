package Baekjoon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SearchDecimalTest {

    SearchDecimal searchDecimal = null;

    @Before
    public void setUp() throws Exception {
        System.out.println(">>>>>>>>>>>>>> TEST START >>>>>>>>>>>>>>");
        searchDecimal = new SearchDecimal();
    }

    @Test
    public void N개수_100개미만_정상출력() {
        try {
            assertEquals(50, searchDecimal.inputCountException(50));
            assertEquals(99, searchDecimal.inputCountException(99));
        } catch(Exception e) {
            System.out.println(">>> Exception message : " + e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void N개수_100개이상_익셉션() throws Exception {
        searchDecimal.inputCountException(100);
    }

    @Test
    public void N각숫자는_1000이하의_자연수_정상출력() {
        try {
            assertEquals(50, searchDecimal.inputNumbersException(50));
            assertEquals(99, searchDecimal.inputNumbersException(99));
        } catch(Exception e) {
            System.out.println(">>> Exception message : " + e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void 각숫자는_1000이하의_자연수가_아닐때_익셉션() throws Exception {
        searchDecimal.inputNumbersException(-1);
    }

    @Test
    public void 각_숫자_소수_카운트() {
        int [] num = {1,2,3,4,5};
        assertEquals(3, searchDecimal.countDercimal(num));
        int[] num1 = {1,2,3,4,5,6,7,20,33,21,99};
        assertEquals(4, searchDecimal.countDercimal(num1));
        int[] num2 = {101,99,199};
        assertEquals(2, searchDecimal.countDercimal(num2));

    }



}