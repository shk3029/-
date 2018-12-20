package Baekjoon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GoldbachsConjectureTest {

    GoldbachsConjecture goldbachsConjecture = null;

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
        goldbachsConjecture = new GoldbachsConjecture();
    }

    @Test
    public void 기능1() {
        System.out.println("기능1");
    }
}