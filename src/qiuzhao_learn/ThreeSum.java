package qiuzhao_learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/13 16:04
 * @Version 1.0
 */

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
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
                    while (l < r && nums[l] == nums[l - 1] ) l++;
                    while (l < r && nums[r] == nums[r + 1] ) r--;

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

        new ThreeSum().threeSum(new int[]{0, 0, 0});


    }


}
