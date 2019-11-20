package math.medium;

/**
 * 这题主要是求包含5的个数
 * 但是n/5肯定不对的
 * 因为25会"多"出一个5来,125会多出两个5来
 * 这时候可以这么除
 * 比如125为例子
 * 125/5 125/25 125/125
 * 25    5      1
 * 基础的25个+25的倍数多出来的5个+125的倍数多出来的1个
 * @auther alery
 * @create 2019-11-20 22:01
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

    public long function(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();    //获取开始时间


        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " : " + new TrailingZeroes().function(i));
            System.out.println(i + " : " + new TrailingZeroes().trailingZeroes(i));
        }


        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间


    }


}
