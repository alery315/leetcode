package other;

/**
 * @auther alery
 * @create 2019-12-09 21:52
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        int major = nums[0];
        int len = nums.length;
        if (len < 1) return major;
        int cnt = 1;

        for (int i = 1; i < len; i++) {
            if (cnt == 0) {
                major = nums[i];
            }
            if (nums[i] != major) {
                cnt--;
            } else {
                cnt++;
            }
//            System.out.println("major is: " + major + ", count is: " + cnt);
        }
        return major;

    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new MajorityElement().majorityElement(nums));

    }

}
