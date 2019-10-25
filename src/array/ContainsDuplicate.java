package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @auther alery
 * @create 2019-09-12 上午11:13
 */

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        // 18ms
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i]) == false) {
                return true;
            }
        }

        return false;

        // 24ms
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                return true;
//            } else {
//                map.put(nums[i], 0);
//            }
//        }
//
//        return false;


        // 3ms的代码
        // 错误案例[7,1,3,2,3]
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[i] > nums[j])
//                    break;
//                if (nums[i] == nums[j])
//                    return true;
//            }
//        }
//        return false;
    }


    public static void main(String[] args) {
        int[] nums = {7,1,3,2,3};
        System.out.println(containsDuplicate(nums));

    }

}
