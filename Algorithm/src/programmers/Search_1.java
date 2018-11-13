package programmers;

import java.util.*;

/*
프로그래머스 완전탐색 1번
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

수포자 1은 [1, 4]번 문제를 맞혔습니다.
수포자 2는 다섯 번째 문제를 맞혔습니다.
 */
public class Search_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("start");
        Solution_Search solution = new Solution_Search();
        int[] answers = {1,2,3,4,5,1,2,3,4,5,2,1,2,1,2,3,2,1,2,5,7};
        int res[] = solution.solution(answers);
        for(int i : res) {
            System.out.println("end : " + i + "입니다");
        }
    }

}

class Solution_Search {
    public int[] solution(int[] answers) {

        int[] personA = new int[answers.length]; // 1,2,3,4,5를 반복

        for(int i=1; i<answers.length+1; i++) {
            int a = i % 5 == 0 ? 5 : i % 5;
            personA[i-1] = a;
        }

        int[] personB = new int[answers.length]; // 2,1,2,3,2,4,2,5를 반복
        int b = 1;
        for(int i=1; i<answers.length+1; i++) {
            if(i%2 == 1) {
                personB[i-1] = 2;
            } else {
                b = (b % 5 == 0) ? 5 : (b % 5 == 2) ? b % 5 + 1 : b % 5;
                personB[i-1] = b;
                b++;
            }
        }

        int[] personC = new int[answers.length]; // 3,1,2,4,5를 2번씩 반복
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0; i<answers.length; i++) {
            personC[i] = (i >= c.length) ? c[i%c.length] : c[i];
        }

        int countA = 0;
        int countB = 0;
        int countC = 0;

        for(int i=0; i<answers.length; i++) {
            if(personA[i] == answers[i]) {
                countA ++;
            }
            if(personB[i] == answers[i]) {
                countB ++;
            }
            if(personC[i] == answers[i]) {
                countC ++;
            }
        }



        return answers;
    }

}












