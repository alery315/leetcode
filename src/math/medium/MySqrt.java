package math.medium;

/**
 * @auther alery
 * @create 2019-11-20 22:41
 */
public class MySqrt {

    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }



    public int mySqrt2(int x) {
        long l = 0, r = 99999;

        while (l < r) {
            // 这个写法很重要,可以选择右中位数(相对大的那个)
            long mid = (l + r + 1) >>> 1;
            long temp = mid * mid;
            System.out.println(l + " : " + r);
            if (temp < x) {
                l = mid;
            } else if (temp > x) {
                r = mid - 1;
            } else {
                return (int) mid;
            }
        }
        return (int)r;
    }

    public int sqrts(double x, double s){
        if (x == 0) return 0;
        double e = 1e-3;
        double res = (x + s / x) / 2;
        System.out.println(res * res);
        if (res * res - s < e) {
            return (int) res;
        } else {
            return sqrts(res, s);
        }

    }



    public static void main(String[] args) {

//        System.out.println(new MySqrt(1).mySqrt2(2147395599));
        System.out.println(new MySqrt().sqrts(183692038,183692038));
    }

}
