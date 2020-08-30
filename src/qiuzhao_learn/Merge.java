package qiuzhao_learn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/28 19:51
 * @Version 1.0
 */

public class Merge {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if (stack.isEmpty()) {
                stack.push(intervals[i]);
            } else {
                int[] ints = stack.pop();
                if (ints[1] >= intervals[i][1]) {
                    stack.push(ints);
                } else if (ints[1] >= intervals[i][0]) {
                    stack.push(new int[]{ints[0], intervals[i][1]});
                } else {
                    stack.push(ints);
                    stack.push(intervals[i]);
                }
            }

        }

        int[][] res = new int[stack.size()][2];
        int len = stack.size();
        for (int i = len - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }


        return res;
    }

    public static void main(String[] args) {

        int[][] ints = new int[][]{{1, 4}, {2, 3}};
        new Merge().merge(ints);


    }

}
