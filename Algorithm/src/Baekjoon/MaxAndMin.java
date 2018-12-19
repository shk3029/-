package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
강의
최대공약수와 최소공배수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	13095	8422	7019	67.065%

문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를,둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

예제 입력 1
24 18
예제 출력 1
6
72

 */
public class MaxAndMin {
    public static void main(String[] args) {
        int i,j;
        int result;
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        j = scanner.nextInt();

        MaxAndMin maxAndMin = new MaxAndMin();
        maxAndMin.solution(i,j);
    }
    public void solution(int a, int b) {
        System.out.println(Greatest_Common_Measure(a,b));
        System.out.println(Least_Common_Multiple(a,b));
    }

    // 1.a와 b의 공약수가 있을 때, 2.공약수가 only 1
    public int Greatest_Common_Measure(int a, int b) {
        int res = 0, max = getMax(a,b), min = getMin(a,b);

        boolean isOnlyOne = true;
        for(int i=0; i<=min; i++) {
            if(i>1 && min % i == 0 && max % i == 0) {
                isOnlyOne = false;
                res = i;
            }
        }
        if(isOnlyOne) return 1;
        return res;
    }

    public int Least_Common_Multiple(int a, int b) {
        int res = 0, max = getMax(a,b), min = getMin(a,b);

        boolean isOnlyOne = true;
        for(int i=0; i<=min; i++) {
            if(i>1 && min % i == 0 && max % i == 0) {
                isOnlyOne = false;
                res = i * min/i * max/i;
            }
        }
        if(isOnlyOne) return a*b;
        return res;
    }


    private int getMax(int a, int b) {
        if(a>=b) {
            return a;
        } else {
            return b;
        }
    }

    private int getMin(int a, int b) {
        if(a>=b) {
            return b;
        } else {
            return a;
        }
    }
}
