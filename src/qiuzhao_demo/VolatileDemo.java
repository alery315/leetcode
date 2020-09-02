package qiuzhao_demo;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/2 14:52
 * @Version 1.0
 */

public class VolatileDemo extends Thread {
    private boolean isRunning = true;
    private int m = 0;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("enter running: ");
        int a = 0, b = 0;
        while (isRunning) {
            a++;
            b++;
            int c = a + b;
            m = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("m: " + m);
        System.out.println("leave running: ");
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileDemo demo = new VolatileDemo();
        demo.start();
        Thread.sleep(1000);
        demo.setRunning(false);
        System.out.println("isRunning is changed");

    }
}
