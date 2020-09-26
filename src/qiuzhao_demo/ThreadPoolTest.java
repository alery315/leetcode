package qiuzhao_demo;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/2 22:00
 * @Version 1.0
 */

public class ThreadPoolTest implements Runnable {

    private String command;

    public ThreadPoolTest(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            Runnable worker = new ThreadPoolTest("" + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){}
        System.out.println("finished all threads");
    }
}
