import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class Lamda {
    public void lamdaex() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread ex");
            }
        }).start();

        new Thread(()-> System.out.println("lamthread")).start();
    }
}
