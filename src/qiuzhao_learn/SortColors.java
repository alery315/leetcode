package qiuzhao_learn;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/30 16:22
 * @Version 1.0
 */

public class SortColors {
    public void sortColors(int[] nums) {
        int count_a = 0;
        int count_b = 0;
        int count_c = 0;
        if (nums == null || nums.length < 1) return;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                count_a++;
            } else if (nums[i] == 1) {
                count_b++;
            } else {
                count_c++;
            }
        }
        int j = 0;
        for (; j < count_a; j++) {
            nums[j] = 0;
        }
        for (; j < count_a + count_b; j++) {
            nums[j] = 1;
        }
        for (; j < len; j++) {
            nums[j] = 2;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{2, 0, 2, 1, 1, 1});


    }
}
