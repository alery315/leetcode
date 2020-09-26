package qiuzhao_demo;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/24 16:23
 * @Version 1.0
 */

public class ReturnDemo {
    static class User{
        int age;

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    '}';
        }
    }
    static User tryFun() {
        int a = -1;
        User u = new User();
        u.age = 12;
        try {
            a = 9;
            u.age = 9;
            return u;
        } catch (Exception e) {
            System.out.println(e.toString());

        }finally {
            u.age = 10;
        }
        return u;
    }

    public static void main(String[] args) {
        System.out.println(tryFun());
    }

}
