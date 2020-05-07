package alibaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinDiffSum {

    public static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> sums = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        List<Integer> list = new ArrayList<>();
        backTrace(nums, 0, 0, list);
        System.out.println(Collections.min(sums));

    }

    public static void backTrace(int[][] nums, int y, int sum, List<Integer> list) {
        if (list.size() == nums[0].length) {
            res.add(new ArrayList<>(list));
            sums.add(sum);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int newSum = 0;
            if (y == 0) {
                newSum = 0;
            } else {
                newSum = sum + Math.abs(nums[i][y] - list.get(list.size() - 1));
            }
            list.add(nums[i][y]);
            backTrace(nums, y + 1, newSum, list);
            list.remove(list.size() - 1);
        }
    }

}
