package qiuzhao_demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/16 23:22
 * @Version 1.0
 */

public class ThreadTest {
    public static List<byte[]> list = new ArrayList<byte[]>();
    static class MyThread extends Thread {
        private String number;
        public static int cnt = 0;

        public MyThread(ThreadGroup group, String name, String number) {
            super(group, name);
            this.number = number;
        }

        @Override
        public void run() {
            //这步类型转换是要故意制造异常
            cnt = Integer.parseInt(number);
            while (true) {
                System.out.println(Thread.currentThread().getName() + "正在运行: " + cnt);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        ThreadGroup threadGroup = new ThreadGroup("我的线程组");
//        //制造一个异常线程
//        new MyThread(threadGroup, "异常线程", "a").start();
//        for (int i = 1; i <= 3; i++) {
//            new MyThread(threadGroup, "线程" + i, i + "").start();
//        }
        new Thread(() -> {

            while (true) {

                System.out.println(new Date().toString() + Thread.currentThread() + "==");

                byte[] b = new byte[1024 * 1024 * 64];

                list.add(b);

                try {

                    Thread.sleep(1000);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }).start();

        new Thread(() -> {

            while (true) {

                System.out.println(new Date().toString() + Thread.currentThread() + "==");

                try {

                    Thread.sleep(1000);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }).start();


    }


}
