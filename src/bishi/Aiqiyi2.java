package bishi;

import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/13 15:13
 * @Version 1.0
 */

public class Aiqiyi2 {


    public static int max_num(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        int res = nums[0];
        for (int i = 0; i < len; i++) {
            if (res == nums[i]) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    res = nums[i];
                    cnt++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        int[] nums = new int[strings.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(max_num(nums));

    }

}
