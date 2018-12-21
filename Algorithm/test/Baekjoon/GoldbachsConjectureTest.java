package Baekjoon;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GoldbachsConjectureTest {

    GoldbachsConjecture goldbachsConjecture = null;

    @Before
    public void setUp() throws Exception {
        System.out.println("GoldbachsConjectureTest");
        goldbachsConjecture = new GoldbachsConjecture();
    }

    @Test
    public void INPUT_개수_6이상_1000000이하_짝수() {
        try {
            goldbachsConjecture.inputNumberException(482);
            goldbachsConjecture.inputNumberException(483); // Exception
        } catch (Exception e) {
            System.out.println(">>> Exception" + e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void INPUT_개수_6이상_1000000이하_짝수_익셉션() throws Exception {
        goldbachsConjecture.inputNumberException(483); // Exception
    }

    @Test
    public void 소수_그리고_홀수() {
        assertEquals(true, goldbachsConjecture.isOddAndDerciaml(3));
        assertEquals(false, goldbachsConjecture.isOddAndDerciaml(2));
        assertEquals(true, goldbachsConjecture.isOddAndDerciaml(5));
        assertEquals(false, goldbachsConjecture.isOddAndDerciaml(9));
        assertEquals(true, goldbachsConjecture.isOddAndDerciaml(83));
        assertEquals(true, goldbachsConjecture.isOddAndDerciaml(101));
    }

    @Test
    public void 최종알고리즘() {
        List<Integer> nums = new ArrayList<>();
        for(int i=6; i<100; i++) {
            if(i%2 == 0)   nums.add(i);
        }
        Integer[] numsInt = nums.toArray(new Integer[nums.size()]);
        goldbachsConjecture.getGoldbachsConjecture(numsInt);
    }

}