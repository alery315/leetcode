package qiuzhao_learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/29 16:11
 * @Version 1.0
 */

public class Permute {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, nums.length, res);
        return res;
    }

    public void dfs(int[] nums, int begin, int end, List<List<Integer>> res) {
        if (begin == end) {
            List<Integer> t = new ArrayList<>();
            for (int num : nums) {
                t.add(num);
            }
            res.add(t);
            return;
        }

        int p = begin;
        for (int i = begin; i < end; i++) {
            swap(nums, p, i);
            dfs(nums, begin + 1, end, res);
            swap(nums, p, i);
        }

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        new Permute().permute(new int[]{1, 2, 3, 4});
    }

}
