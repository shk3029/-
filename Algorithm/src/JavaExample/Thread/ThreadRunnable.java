package JavaExample.Thread;

import java.util.ArrayList;
import java.util.List;

/*
    @쓰레드
    - Runnable -  run 메소드를 구현하도록 강제함
    - 보통 Runnable 인터페이스를 구현하는게 일반적 - Thread Class를 상속받으면 다른 클래스를 상속 받을 수 없음
 */
public class ThreadRunnable implements Runnable {
    int seq;

    public ThreadRunnable(int seq) {
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
