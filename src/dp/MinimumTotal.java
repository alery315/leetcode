package dp;

import javax.security.auth.login.AccountLockedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0) return 0;
        int n = triangle.get(0).size();
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            n = Math.max(triangle.get(i).size(),n);
        }
        int[][] dp = new int[m][n];
        // 把dp数组初始化为整型最大值,因为这里需要取小的,求min
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        // 第一行就是自己的值,为初值
        for (int i = 0; i < triangle.get(0).size(); i++) {
            dp[0][i] = triangle.get(0).get(i);
        }
        // 第一列只能从上一行的第一列下来,所以初始化为上一行+自己的值
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        // 状态转移:上一行的斜上方,上一行的正上方过来,取最小值+自己的值,为到这个点的最小路径
        // 这里每一行的长度注意不要写错,会越界
        for (int i = 1; i < m; i++) {
            int t_len = triangle.get(i).size();
//            System.out.println(t_len);
            for (int j = 1; j < t_len; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            ret = Math.min(ret, dp[m - 1][i]);
        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(minimumTotal(triangle));

    }
}
