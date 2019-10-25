package array;

import java.util.Arrays;

/**
 * @Description
 * @auther alery
 * @create 2019-09-12 下午2:52
 */

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int t = 0;
        int flag = 0;
        digits[len - 1] += 1;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = digits[i] + t;
            t = 0;
            if (digits[i] > 9 && i == 0) {
                flag = 1;
            }
            if (digits[i] > 9) {
                t = digits[i] / 10;
                digits[i] -= 10;
//                System.out.println(i + ":" + t);
            }
        }
        if (t != 0 && flag == 1) {
            int[] result = new int[len + 1];
            result[0] = 1;
//            System.arraycopy(digits, 0, result, 1, len);
            return result;
        }
        return digits;
    }

    // 精简思路
    // 末位加1,对10取余,等于0表示有进位,前一位继续这个操作,直到没有进位为止,
    // 999的情况,到最后还有进位,初始化一个len+1的数组,第一位为1,即可.
    public static int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {

        int[] digits = {9,9,9,9};
        System.out.println(Arrays.toString(plusOne2(digits)));

    }

}
