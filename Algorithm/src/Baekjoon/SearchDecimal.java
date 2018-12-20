package Baekjoon;

import java.util.Scanner;

/*
소수 찾기
시간 제한 	메모리 제한 	제출 	정답 	맞은 사람 	정답 비율
2 초 	128 MB 	21979 	10600 	8864 	50.255%
문제

주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

1. N을 입력 (개수) N < 100
2. N개의 수를 입력 (100이하) - 각 숫자는 1,000 이하의 자연수
3. 소수의 개수를 출력

출력
주어진 수들 중 소수의 개수를 출력한다.
예제 입력 1
4
1 3 5 7

예제 출력 1
3
 */
public class SearchDecimal {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        SearchDecimal searchDecimal = new SearchDecimal();
        searchDecimal.solution();
    }

    public void solution() {
        try {
            int count = inputCountException(scanner.nextInt());
            int[] num = new int[count];

            for(int i=0; i<count; i++) {
                num[i] = inputNumbersException(scanner.nextInt());
            }

            int derciamlCnt = countDercimal(num);
            System.out.println(derciamlCnt);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 1. N의 개수가 N < 100이면 Exception 발생
    public int inputCountException(int count) throws Exception {
        if(count>= 100) throw new Exception("N의 개수는 100이하로 입력해주세요");
        return count;
    }

    // 2. 각 숫자는 1,000 이하의 자연수
    public int inputNumbersException(int num) throws Exception {
        if(num > 1000 || num < 1) throw new Exception("각 숫자는 1,000이하의 자연수입니다.");
        return num;
    }

    // 3. 각 숫자들이 소수인지 파악해서 카운트
    public int countDercimal(int[] nums) {
        int count = 0;
        for(int num : nums) {
            int zeroRemainderCnt = 0;
            for(int i=1; i<=num; i++) {
                if(num % i == 0) zeroRemainderCnt++;
            }
            if(zeroRemainderCnt == 2) count++;
        }
        return count;
    }
}
