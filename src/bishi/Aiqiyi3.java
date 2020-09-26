package bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/13 15:13
 * @Version 1.0
 */

public class Aiqiyi3 {


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums == null) {
            return lists;
        }
        int len = nums.length;
        int l, r;
        for (int i = 0; i < len - 2; i++) {
            l = i + 1;
            r = len - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    l++;
                    r--;
                    // 防止越界
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;

                } else if (temp < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        int[] nums = new int[strings.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + " ");
            }
            if (list.size() >= 1) {
                System.out.println(list.get(list.size() - 1));
            }
        }
    }

}
