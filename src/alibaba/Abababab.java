package alibaba;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-31 16:09
 */
public class Abababab {

    private static int MAX_NUM = 20;
    private volatile boolean flag = true;
    private static volatile int i = 1;

    public synchronized void printA() {

        while (true) {
            if (i > MAX_NUM) {
                return;
            }
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i++);
            }
            try {
                notifyAll();
                if (i <= MAX_NUM)
                    wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void printB() {
        while (true) {
            if (i > MAX_NUM) {
                return;
            }
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + " " + i++);
            }
            try {
                notifyAll();
                if (i <= MAX_NUM)
                    wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                2, 5, 300,
//                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10)
//        );
        Abababab ab = new Abababab();
//        executor.execute(() -> ab.printA());
//        executor.execute(() -> ab.printB());

        Thread a = new Thread(() -> ab.printA());
        a.start();
        Thread b = new Thread(() -> ab.printB());
        b.start();

    }


}
