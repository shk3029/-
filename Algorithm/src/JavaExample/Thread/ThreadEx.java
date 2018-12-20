package JavaExample.Thread;

import java.util.ArrayList;
import java.util.List;

/*
    @쓰레드
    - 프로세스 안에서 실행되는 흐름의 단위
    프로세스 : 동작하고 있는 프로그램 (보통 1개의 프로세스는 1개의 일)
    쓰레드를 이용하면 1개의 프로세스 내에서 2개 이상의 일을 동시에 할 수 있음
    즉, 프로세스는 운영체제로부터 작업을 할당받는 작업의 단위이고, 스레드는 프로세스가 할당 받은 자원을 이용하는 실행의 단위
    멀티스레딩 : 1개의 프로세스에서 여러 스레드가 독립적으로 작업을 병렬적으로 처리
    멀티태스킹 : 여러 개의 프로세스를 동시에 실행하는 것
    왜 그럼 멀티테스킹으로 처리하지 않고 멀티쓰레딩을? -> 프로세스 호출 시 Context Switch(문맥교환)의 오버헤드가 발생
    * 멀티스레드 장점
        1. CPU 사용률 향상
        2. 자원을 보다 효율적 사용
        3. 사용자에 대한 응답성 향상
        4. 작업이 분리되어 코드가 간결
        -> 단점으로는 동기화, 교착상태같은 문제가 발생할 수 있음
    (동시라고는 볼 수 없음 여러 스레드가 독립적으로 작업을 처리(1번 했다가 2번 했다가 ~ 번갈아가면서 함 워낙 빨라서 동시에 하는 것처럼 느껴짐)
    키워드 : Thread, run. join, Runnable
 */
public class ThreadEx extends Thread {

    int seq;

    public ThreadEx(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        System.out.println("thread run >> " + this.seq);
        try {
            Thread.sleep(1000); // 메소드 사이 시작, 종료 사이 1초 간격
        } catch (Exception e) {
            System.out.println(">>>Exception" + e.getMessage());
        }
        System.out.println("thread run END>> " + this.seq);
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ThreadEx threadEx = new ThreadEx(i);
            threadEx.start();
            threads.add(threadEx);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {

            }
        }
        System.out.println(">>>>END MAIN");
    }
}

