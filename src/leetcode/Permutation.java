package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-23 21:11
 */
public class Permutation {
    public static List<String> list = new ArrayList<>();

    public void permutation(int[] array, int start) {
        if (start == array.length) {
            list.add(Arrays.toString(array));//把所有可能的全排列存到list里
        } else
            for (int i = start; i < array.length; ++i) {
                swap(array, start, i); // 交换元素
                permutation(array, start + 1); // 交换后，再进行全排列
                swap(array, start, i); // 还原
            }
    }

    private void swap(int[] array, int s, int i) {
        int t = array[s];
        array[s] = array[i];
        array[i] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        new Permutation().permutation(arr, 0);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
