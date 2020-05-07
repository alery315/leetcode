package alibaba;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-04-01 14:22
 */
public class Learn {



    public static void main(String[] args) {

//        Learn a = new Learn();
//
//        new Thread(() -> a.funA()).start();
//        new Thread(() -> a.funB()).start();

        int[] array = new int[]{1, 2, 3, 4};

        int[] arraycopyof = new int[10];
        System.arraycopy(array, 0, arraycopyof, 0, 4);
        arraycopyof = Arrays.copyOf(array, 20);
        System.out.println("ok");

    }

    public static void section1() {
        Integer a = 123;
        Integer b = 123;
        Long a1 = 123l;
        Long a2 = 123l;
//        System.out.println(a == b);
//        System.out.println(a1 == a2);

        HashMap<String, String> map = new HashMap<>();
        Hashtable<String, String> hashtable = new Hashtable<>();
        StringBuffer sb = new StringBuffer();
        String s = new String("123");
        s = s + "123";
        User[] users = new User[10];
        for (int i = 0; i < 10; i++) {
            users[i] = new User(i, i);
        }
        String s2 = "123";
        String s3 = s2;
        s2 = "1234";
//        System.out.println(s2.getBytes());
//        System.out.println(s3.getBytes());
        Vector<Integer> vector = new Vector<>();
        Deque<Integer> deque = new LinkedList<>();
        HashSet set = new HashSet();
        set.add(1);
        set.add("12");
        set.add(new User(12,12));
//        for (Object o : set) {
//            System.out.println(o);
//        }
//        deque.push(1);
//        deque.push(2);
//        deque.push(3);
        deque.add(1);
        deque.add(2);
        deque.add(3);

//        deque.remove();
//        deque.pop();

//        System.out.println("ok");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }

        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getHeight() - o2.getHeight() > 0) {
                    return 1;
                }
                return 0;
            }
        });



        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.decrementAndGet();
    }

    public static User fun() {
        String s = "123";
        User user = new User(12, 12);
        try {
            user.setHeight(123);
            System.out.println("try" + user);
            return user;
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
            return user;
        } finally {
            user.setHeight(1234);
            System.out.println(s + "finally");
        }
    }

    public static Integer section2() {
        int i = 1;
        Integer integer = 1;
        try {
            i = 2;
            integer = new Integer(2);
            return integer;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            i = 3;
            integer = new Integer(3);
        }
        return integer;
    }

    public void funA() {
        synchronized (this) {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("funA" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void funB() {
        synchronized (Learn.class) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("funB" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
