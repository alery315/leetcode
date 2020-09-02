package qiuzhao_learn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/2 19:53
 * @Version 1.0
 */

public class PrintAandB {
    private static int num = 1;
    private static final int MAX = 20;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    static class ThreadA extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (num < MAX) {
                    condition2.signalAll();
                    condition1.await();
                    System.out.println(currentThread().getName()+ " " + num++);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                condition2.signalAll();
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (num < MAX) {
                    condition1.signalAll();
                    condition2.await();
                    System.out.println(currentThread().getName()+ " " + num++);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                condition1.signalAll();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
//        condition1.signalAll();
//        condition2.signalAll();
    }


}
