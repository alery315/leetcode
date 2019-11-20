package math.simple;

public class IsPowerOfThree {

    /**
     * 判断2 : (number & number - 1) == 0 快速判断2的幂
     * 判断3 : 如果一个数是3的幂,那么它也是整型范围的最大的3的幂的约数,直接判断maxPower % n == 0 ?
     * 判断4 : 在2的基础上,进一步判断与0x55555555的按位与结果，0x55555555是用十六进制表示的数，
     *         其奇数位上全是1，偶数位上全是0，判断 n & 0x55555555
     * @param n
     * @return
     */

    public static boolean isPowerOfThree(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        while (n != 0) {
            if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 2 == 0) {
                return false;
            } else if (n % 5 == 0) {
                return false;
            } else if (n == 1) {
                return true;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.print(i + " : ");
            System.out.println(isPowerOfThree(i));
        }

        int maxPower = (int) Math.pow(3, (int) (Math.log(0x7fffffff) / Math.log(3)));
        System.out.println(maxPower);
    }

}
