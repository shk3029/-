package DataStructure;

/*
    Max_Heap ?
     - 우선 순위 큐를 위해 만들어짐
     - 배열을 이용하여 힙을 구현할 수 있음
     - 완전 이진 트리의 일종
     - 여러 개의 값들 중에서 최댓값 최소값을 빠르게 찾을 수 있는 자료구조
     - 삽입 / 삭제가 O(logn) - 효율이 좋음
 */


import java.util.Scanner;

public class Max_Heap {

    static int[] array = new int[100];
    static int cnt = 0;

    public static void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void push(int n) {
        cnt++;
        int temp_index = cnt;
        array[temp_index] = n;

        while(temp_index > 1) {
            int root = temp_index/2;
            if(array[temp_index] > array[root]) {
                int temp = array[root];
                array[root] = array[temp_index];
                array[temp_index] = temp;
                temp_index = temp_index/2;
            }
            else {
                break;
            }
        }
    }

    public static void pop(){
        int start = 1;
        array[start] = array[cnt];
        array[cnt] = 0;
        cnt--;

        while (true) {
            if((array[start] > array[start*2]) && array[start] > array[start*2 + 1]) {
                break;
            }
            else if(array[start*2] > array[start*2 + 1]){
                swap(start, start*2);
                start = start*2;
            }
            else {
                swap(start, start*2 + 1);
                start = start*2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if(n == -1) {
                break;
            }
            array[cnt+1] = n;
            cnt++;
        }


        push(10);
        for(int i : array) {
            System.out.println("Tree " + cnt + " 개 : " + i);
        }

        pop();
    }

}

