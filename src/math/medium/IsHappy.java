package math.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 这题的关键在于如何判断无限循环
 * 1. 使用set等集合记录 (每次需要存储数据都会拉低一点速度)
 * 2. 使用快慢指针 这个效率快,而且不需要存储东西
 * @auther alery
 * @create 2019-11-20 21:44
 */
public class IsHappy {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = function(n);
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    public int function(int n) {
        int ans = 0;
        while (n != 0) {
            int temp = n % 10;
            ans += temp * temp;
            n /= 10;
        }
        return ans;
    }

    public boolean isHappy2(int n) {
        int fast = function(n);
        int low = n;
        while (fast != 1 && fast != low) {
            low = function(low);
            fast = function(fast);
            fast = function(fast);
        }
        return fast == 1;
    }

    public static void main(String[] args) {

        long  startTime = System.currentTimeMillis();    //获取开始时间

        System.out.println(new IsHappy().isHappy2(2));

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }

}
