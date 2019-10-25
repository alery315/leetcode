package Design;

import java.util.Arrays;
import java.util.Random;

public class Solution {


    public int[] _nums;

    public Solution(int[] nums) {
        _nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return _nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();
        int len = _nums.length;
        int[] temp_nums = new int[len];
        for (int i = 0; i < len; i++) {
            temp_nums[i] = _nums[i];
        }
        for (int i = 0; i < len; i++) {
            int j = random.nextInt(len - i) + i;
            System.out.println(j);
            int temp = temp_nums[j];
            temp_nums[j] = temp_nums[i];
            temp_nums[i] = temp;
        }
        return temp_nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        int[] param_3 = obj.reset();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(param_2));
        System.out.println(Arrays.toString(param_3));

    }

}
