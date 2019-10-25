package math;

public class MissingNumber {

    public static int missingNumber(int[] nums) {

//        long sum = 0;
        int len = nums.length;
//        long result = ((len + 1) * len) / 2;
//        for (int i = 0; i < len; i++) {
//            sum += nums[i];
//        }

        int ret = len;
        for (int i = 0; i < len; i++) {
            ret += i - nums[i];
        }

        return ret;

//        return (int) (result - sum);

    }


    public static void main(String[] args) {

        int[] nums = new int[]{9, 6, 4, 0, 3, 5, 7, 8, 1};

        System.out.println(missingNumber(nums));

    }

}
