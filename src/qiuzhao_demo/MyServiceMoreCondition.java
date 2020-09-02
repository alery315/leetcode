package qiuzhao_demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/2 16:07
 * @Version 1.0
 */

public class MyServiceMoreCondition {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA() {
        lock.lock();
        try {
            System.out.println("begin awaitA time is: " + System.currentTimeMillis() + ", " + Thread.currentThread().getName());
            Thread.sleep(100);
            conditionA.await();
            System.out.println("end awaitA time is: " + System.currentTimeMillis() + ", " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("awaitA is out");
            lock.unlock();
        }
    }
    public void awaitB() {
        lock.lock();
        try {
            System.out.println("begin awaitB time is: " + System.currentTimeMillis() + ", " + Thread.currentThread().getName());
            Thread.sleep(100);
            conditionB.await();
            System.out.println("end awaitB time is: " + System.currentTimeMillis() + ", " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("awaitB is out");
            lock.unlock();
        }
    }

    public void signalAll_A() {
        lock.lock();
        try {
            System.out.println("signalAll_A time is: " + System.currentTimeMillis() + ", " + Thread.currentThread().getName());
            conditionA.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void signalAll_B() {
        lock.lock();
        try {
            System.out.println("signalAll_B time is: " + System.currentTimeMillis() + ", " + Thread.currentThread().getName());
            conditionB.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyServiceMoreCondition service = new MyServiceMoreCondition();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(1000);

        service.signalAll_A();
        service.signalAll_B();

    }

    static public class ThreadA extends Thread {
        private MyServiceMoreCondition serviceMoreCondition;

        public ThreadA(MyServiceMoreCondition serviceMoreCondition) {
            this.serviceMoreCondition = serviceMoreCondition;
        }

        @Override
        public void run() {
            serviceMoreCondition.awaitA();
        }
    }
    static public class ThreadB extends Thread {
        private MyServiceMoreCondition serviceMoreCondition;

        public ThreadB(MyServiceMoreCondition serviceMoreCondition) {
            this.serviceMoreCondition = serviceMoreCondition;
        }

        @Override
        public void run() {
            serviceMoreCondition.awaitB();
        }
    }

}
