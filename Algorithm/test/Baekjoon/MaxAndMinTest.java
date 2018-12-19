package Baekjoon;

import static org.junit.Assert.*;

import org.junit.*;

public class MaxAndMinTest {

    MaxAndMin maxAndMin = null;

    @Before
    public void setUp() throws Exception {
        maxAndMin = new MaxAndMin();
    }

    @Test
    public void 최대공약수() {
        Assert.assertEquals(4,maxAndMin.Greatest_Common_Measure(4,8));
        Assert.assertEquals(9,maxAndMin.Greatest_Common_Measure(18,45));
        Assert.assertEquals(20,maxAndMin.Greatest_Common_Measure(20,20));
        Assert.assertEquals(20,maxAndMin.Greatest_Common_Measure(20,40));
        Assert.assertEquals(11,maxAndMin.Greatest_Common_Measure(99,77));
        Assert.assertEquals(9,maxAndMin.Greatest_Common_Measure(45,99));
    }

    @Test
    public void 최소공배수() {
        Assert.assertEquals(8,maxAndMin.Least_Common_Multiple(4,8));
        Assert.assertEquals(90,maxAndMin.Least_Common_Multiple(18,45));
        Assert.assertEquals(20,maxAndMin.Least_Common_Multiple(20,20));
        Assert.assertEquals(40,maxAndMin.Least_Common_Multiple(20,40));
        Assert.assertEquals(693,maxAndMin.Least_Common_Multiple(99,77));
        Assert.assertEquals(495,maxAndMin.Least_Common_Multiple(45,99));
    }

    @After
    public void tearDown() throws Exception {
    }
}