package string;

/**
 * @Description
 * @auther alery
 * @create 2019-09-17 下午2:57
 */

public class Reverse {


    public static int reverse(int x) {
        long top = 1L << 31, bottom = (-top);
        top -= 1;
        int flag = x > 0 ? 0 : 1;
        x = flag > 0 ? -x : x;
        int[] result = new int[15];
        int len = 0;
        while (x != 0) {
            result[len++] = x % 10;
            x = x / 10;
        }

        long t = 0L;


        for (int i = 0; i < len; i++) {
            t = t * 10 + result[i];
        }
        t = flag > 0 ? -t : t;
        if (t > top || t < bottom) {
            return 0;
        }

        return (int) t;
    }

    public static void main(String[] args) {

        System.out.println(reverse(1463847412));


    }

}
