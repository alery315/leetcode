package other;


/**
 * @auther alery
 * @create 2019-12-09 21:08
 */
public class getSum {
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        System.out.println("sum:" + sum);
        System.out.println("carry: " + carry);
        if (carry != 0) {
            return getSum(sum, carry);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new getSum().getSum(-3, 1));

    }
}
