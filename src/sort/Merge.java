package sort;

import java.util.Arrays;

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int pos = m + n - 1;
        int i, j;
        for (i = m - 1, j = n - 1; i >= 0 && j >= 0; ) {
            if (nums1[i] > nums2[j]) {
                nums1[pos--] = nums1[i--];
            } else {
                nums1[pos--] = nums2[j--];
            }
        }
        if (j != -1) {
            while (j != -1) {
                nums1[pos] = nums2[j];
                pos--;
                j--;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0};
        int[] nums2 = {1, 1, 2};


        new Merge().merge(nums1, 0, nums2, 3);

        System.out.println(Arrays.toString(nums1));


    }


}
