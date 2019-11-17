package dp;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) dp[i] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // poker思想,利用二分查找
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int[] tail = new int[len];
        tail[0] = nums[0];
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int l = 0, r = cnt;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (tail[mid] < nums[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (l == cnt) {
                cnt++;
            }
            tail[l] = nums[i];
        }
        return cnt;
    }


    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        LengthOfLIS lengthOfLIS = new LengthOfLIS();

        System.out.println(lengthOfLIS.lengthOfLIS2(nums));

    }
}
