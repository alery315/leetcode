package qiuzhao_learn;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/30 14:34
 * @Version 1.0
 */

public class Trap {

    public int trap(int[] height) {
        int res = 0;
        int len = height.length;

        for (int i = 1; i < len - 1; i++) {
            int max_l = height[i];
            int max_r = height[i];
            int l = i;
            int r = i;
            while (l >= 0 || r < len) {

                if (l >= 0) {
                    max_l = Math.max(height[l], max_l);
                    l--;
                }

                if (r < len) {
                    max_r = Math.max(height[r], max_r);
                    r++;
                }
            }
//            res += Math.max(Math.min(max_l, max_r) - height[i], 0);
            res += Math.min(max_l, max_r) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int len = height.length;
        if (len < 3) return 0;
        int[] l_max_array = new int[len];
        l_max_array[0] = height[0];
        int[] r_max_array = new int[len];
        r_max_array[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            l_max_array[i] = Math.max(l_max_array[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            r_max_array[i] = Math.max(r_max_array[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            res += Math.min(l_max_array[i], r_max_array[i]) - height[i];
        }

        return res;
    }

    public static void main(String[] args) {
        new Trap().trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

}
