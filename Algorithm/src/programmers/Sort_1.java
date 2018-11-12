package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
프로그래머스 정렬 1번 : K번째수
문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

    * 제한사항
        array의 길이는 1 이상 100 이하입니다.
        array의 각 원소는 1 이상 100 이하입니다.
        commands의 길이는 1 이상 50 이하입니다.
        commands의 각 원소는 길이가 3입니다.

입출력 예
array	commands	return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 */ 
public class Sort_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3},{4, 4, 1},{1,7,3}};
		int[] result = solution(array, commands);
		System.out.println(result);
	}
	
	public static int[] solution(int[] array, int[][] commands) {
	    int[] answer = {};
        List<Integer> retList = new ArrayList<>();
        int a = commands.length;

        for(int i=0; i<commands.length; i++) {
            int startNum = commands[i][0];
            int endNum = commands[i][1];
            int wantNum = commands[i][2];

            List<Integer> tempList = new ArrayList<>();
            for(int j=0; j<array.length; j++) {
                if(j >= startNum-1 && j <= endNum-1) {
                    tempList.add(array[j]);
                }
            }

            Collections.sort(tempList);

            int[] ret = new int[tempList.size()];
            for (int k=0; k < ret.length; k++) {
                ret[k] = tempList.get(k).intValue();
            }
            System.out.println(ret[wantNum-1]);
            retList.add(ret[wantNum-1]);
        }

            int[] tmp = new int[retList.size()];
            for (int k=0; k < tmp.length; k++) {
                tmp[k] = retList.get(k).intValue();
            }
            answer = tmp;
        return answer;
    }

    // 다른사람풀이
    public static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i= 0; i<commands.length ; i++){
            int start = commands[i][0] == 0 ? 0 : commands[i][0]-1;
            int finish = commands[i][1] == commands[i][0] ? start+1 : commands[i][1] ;
            int pos = commands[i][2]-1;

            int[] tmp = Arrays.copyOfRange(array, start, finish);

            Arrays.sort(tmp);

            answer[i] = tmp[pos];
        }

        return answer;
    }
}
