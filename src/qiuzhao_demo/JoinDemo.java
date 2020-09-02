package qiuzhao_demo;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/2 15:24
 * @Version 1.0
 */

public class JoinDemo {

    static public class MyThread extends Thread {
        @Override
        public void run() {

            System.out.println("MyThread is running ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();

        try {
            thread.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread is running ");


    }
}
