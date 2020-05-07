package niuke;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-23 15:21
 */
public class ContactString {

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextLine());

        //lambda排序,按首字母和字符串长度排序
        list.sort((o1, o2) -> {
            if (o1.charAt(0) == o2.charAt(0))
                return o2.length() > o1.length() ? 1 : 0;
            else
                return o2.charAt(0) < o1.charAt(0) ? 1 : -1;
        });

        ReentrantLock lock = new ReentrantLock();
        CountDownLatch count = new CountDownLatch(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        //dp
        int[] dp = new int[n];
        dp[0] = list.get(0).length();
        int res = 0;
        for (int i = 1; i < n; i++) {
            //首字母排序后拼接的状态方程：
            //以第i个字符串结束的最长字串长度=它的长度+前面能够拼接的最长字串的长度
            int pre = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i).charAt(0) < list.get(j).charAt(list.get(j).length() - 1)) continue;
                pre = Math.max(pre, dp[j]);
            }
            dp[i] = pre + list.get(i).length();
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);

    }

}
