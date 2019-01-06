package Baekjoon;
/*
골드바흐의 추측
시간 제한 	메모리 제한 	제출 	정답 	맞은 사람 	정답 비율
1 초 	256 MB 	10761 	3082 	2184 	29.182%

문제
1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.
4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
이 추측은 아직도 해결되지 않은 문제이다.

백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.

입력
입력은 하나 또는 그 이상의 테스트 케이스로 이루어져 있다. 테스트 케이스의 개수는 100,000개를 넘지 않는다.
각 테스트 케이스는 짝수 정수 n 하나로 이루어져 있다. (6 ≤ n ≤ 1,000,000)
입력의 마지막 줄에는 0이 하나 주어진다.

출력
각 테스트 케이스에 대해서, n = a + b 형태로 출력한다. 이때, a와 b는 홀수 소수이다. 숫자와 연산자는 공백 하나로 구분되어져 있다.
만약, n을 만들 수 있는 방법이 여러 가지라면, b-a가 가장 큰 것을 출력한다.
또, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.

1. 입력은 1개이상의 수를 할 수 있음 (input.length <= 100,000)
2. 각 입력한 수는 짝수 정수 n 1개 ( 6 <= n <= 1,000,000)
3. 입력의 마지막 줄에는 0 (종료의 의미?)
4. 각 n에 대해서 n = a + b (a,b는 홀수 소수) 로 나타냄 (숫자, 연산자는 공백 하나로 구분) (방법이 여러가지면 b-a가 가장 큰 것)
5. 만약 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우 "Goldbach's conjecture is wrong."을 출력

예제 입력 1
8
20
42
0

예제 출력 1
8 = 3 + 5
20 = 3 + 17
42 = 5 + 37
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GoldbachsConjecture {
    Boolean[] isDecimalValue = new Boolean[100001];
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        GoldbachsConjecture goldbachsConjecture = new GoldbachsConjecture();
        goldbachsConjecture.solution();
    }
    public void solution()  {
        try {
            long beforeTime = System.currentTimeMillis();
            List<Integer> nums = new ArrayList<>();
            while(true) {
                if(nums.size() == 100000) break; // 1. (input.length <= 100,000)
                int input = scanner.nextInt();
                if(input == 0) break; // 3. 입력의 마지막 줄에는 0 (종료의 의미)
                nums.add(inputNumberException(input));
            }
            Integer[] numsInt = nums.toArray(new Integer[nums.size()]);
            getGoldbachsConjecture(numsInt); // 입력한 n들을 넘겨서 각각 n = a + b로 출력 (b-a가 가장 큰것)
            long aftertime = System.currentTimeMillis();

            long secDiffTime = (aftertime - beforeTime)/1000; //두 시간에 차 계산
            System.out.println("시간차이(m) : "+secDiffTime);

        } catch (Exception e) {
            System.out.println("Error >>" + e.getMessage());
        }
    }

    // 4. n = a + b로 나타냄 (방법이 여러가지면 b-a가 가장 큰 것)
    public void getGoldbachsConjecture(Integer[] nums) {
        for(int n : nums) {
            int a = 0, b = 0;
            // 3 ~ 각 숫자까지 홀수이면서 소수인수를 파악해서
            for(int i=3; i<=n; i++) {
                isDecimalValue[i] = isOddAndDerciaml(i);
            }
            for(int i=3; i<=n/2+1; i++) {
                if(!isDecimalValue[i] || !isDecimalValue[n-i]) continue;
                if(isDecimalValue[i] && isDecimalValue[n-i]) {
                    a = i;
                    b = n-i;
                    System.out.println(n +" = " + a + " + " + b );
                    break;  // 초반이 b-a가 가장 큼
                }
                if(a == 0 && b == 0) {
                    System.out.println("Goldbach's conjecture is wrong");
                }
            }
        }

    }

    // 2. 각 입력한 수는 짝수 정수 n 1개 ( 6 <= n <= 1,000,000)
    public int inputNumberException(int input) throws Exception {
        if(input < 6 || input > 1000000 || input % 2 != 0 ) throw new Exception("짝수 정수( 6 <= n <= 1,000,000)가 아닙니다.");
        return input;
    }

    // 각 숫자가 소수이면서 홀수
    public boolean isOddAndDerciaml(int num) {
        return isDercimal(num) && isOdd(num);
    }

    // 각 숫자가 소수인지 판별
    public boolean isDercimal(int num) {
        int zeroRemainderCnt = 0;
        for(int i=1; i<= num; i++) {
            if(num % i == 0) zeroRemainderCnt++;
        }
        if(zeroRemainderCnt == 2) return true;
        return false;
    }

    // 각 숫자가 홀수인지 판별
    public boolean isOdd(int num) {
        return (num % 2 != 0);
    }

}









