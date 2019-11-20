package math.simple;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {

        //第二种方法，求出异或，然后计算异或中1的个数 x^y

        int count = 0;

        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(hammingDistance(1, 4));

    }

}
