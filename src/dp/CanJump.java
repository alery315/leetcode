package dp;

public class CanJump {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 2) return true;
        int last_pos = 0;
        for (int i = 0; i < len - 1; i++) {
//            if (nums[i] == 0 && last_pos <= i) return false;
            if (last_pos < i) return false;
            last_pos = Math.max(last_pos, i + nums[i]);
        }
        return last_pos >= len - 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        System.out.println(new CanJump().canJump(nums));
    }

}
