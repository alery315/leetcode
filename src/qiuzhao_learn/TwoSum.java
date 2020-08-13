package qiuzhao_learn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/13 15:06
 * @Version 1.0
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.get(target - nums[i]) != null) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }

        return new int[]{-1, -1};
    }
}
