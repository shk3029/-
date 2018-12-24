package Baekjoon.BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*

일곱 난쟁이 스페셜 저지
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	17839	8679	6776	52.353%
문제
왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

입력
아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.

출력
일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.

예제 입력 1
20
7
23
19
10
15
25
8
13
예제 출력 1
7
8
10
13
19
20
23

 */
public class SevenDwarf {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] dwarfTalls = new int[9];
        for(int i=0; i<dwarfTalls.length; i++) {
            dwarfTalls[i] = s.nextInt();
        }
        SevenDwarf sevenDwarf = new SevenDwarf();
        sevenDwarf.solution(dwarfTalls);
    }

    public void solution(int[] dwarfTalls) {
        List<Integer> res =new ArrayList<>();

        int notDwarfTallsSum = sum(dwarfTalls) - 100;
        int[] notSevenDwarf = searchNotDwarfTall(dwarfTalls, notDwarfTallsSum);
        Arrays.sort(dwarfTalls);
        for(int dwarfTall : dwarfTalls) {
            boolean isDwarf = true;
            for(int i=0; i<notSevenDwarf.length; i++) {
                if(dwarfTall == notSevenDwarf[i]) {
                    isDwarf = false;
                }
            }
            if(isDwarf)  res.add(dwarfTall);
        }

        for(int tall : res) {
            System.out.println(tall);
        }
    }

    public int sum(int[] dwarfTalls) {
        int sum = 0;
        for(int tall : dwarfTalls) {
            sum += tall;
        }
        return sum;
    }

    public int[] searchNotDwarfTall(int[] dwarfTalls, int sum){
        int[] notSevenDwarf = new int[2];
        for(int tall=0;  tall<dwarfTalls.length-1; tall++) {
            for(int i=tall+1; i<dwarfTalls.length; i++) {
                if(dwarfTalls[tall] + dwarfTalls[i] == sum) {
                    notSevenDwarf[0] = dwarfTalls[tall];
                    notSevenDwarf[1] = dwarfTalls[i];
                }
            }
        }
        return notSevenDwarf;
    }
}
