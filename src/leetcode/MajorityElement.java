package leetcode;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-25 14:52
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int cnt = 0, majority = nums[0];
        for (int num : nums) {
            majority = (cnt == 0) ? num : majority;
            cnt = (majority == num) ? cnt + 1 : cnt - 1;
        }
        return majority;
    }

}
