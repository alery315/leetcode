package test;

import java.lang.reflect.Constructor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(30);
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static int count = 0;

    private static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.put("product" + atomicInteger.incrementAndGet());
//                    queue.put("product" + count++);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("produce..");
            }
        }
    }

    private static class Consumer extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    String product = queue.take();
                    System.out.println("consume.." + product);
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }

        for (int i = 0; i < 4; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

    }

}