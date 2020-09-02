package qiuzhao_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/2 15:51
 * @Version 1.0
 */

public class LockDemo extends Thread{

    // 同步执行
    private static Lock lock = new ReentrantLock();
    // 异步执行，因为不是静态变量则每个对象实例都有一个lock
//    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("threadName: " + Thread.currentThread().getName() + " " + i);
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        LockDemo demo1 = new LockDemo();
        LockDemo demo2 = new LockDemo();
        demo1.start();
        demo2.start();

    }
}
