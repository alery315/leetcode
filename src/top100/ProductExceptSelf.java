package top100;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }

        k = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = k * res[i];
            k = k * nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4}));

    }

}
