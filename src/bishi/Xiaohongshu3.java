package bishi;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 11:23
 * @Version 1.0
 */

public class Xiaohongshu3 {

    static class Box implements Comparable {
        public int x;
        public int y;
        public int h;

        public Box(int x, int y, int h) {
            if (x > y) {
                this.x = x;
                this.y = y;
            } else {
                this.x = y;
                this.y = x;
            }
            this.h = h;
        }

        @Override
        public int compareTo(Object o) {
            Box box = (Box) o;
            if (this.x == box.x) {
                return this.y - box.y;
            } else {
                return this.x - box.x;
            }
        }
    }
    /*
4
4 2 5
3 1 6
3 2 1
6 3 9
3
6 5 4
1 3 6
1 2 3
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s == null || s.length() == 0 || s.equals("\n")) {
                break;
            }
            int n = Integer.parseInt(s);
            if (n == 0) {
                System.out.println("0");
                continue;
            }
            List<Box> boxes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String t = sc.nextLine();
                String[] strings = t.split(" ");
                int[] xyhs = new int[3];
                xyhs[0] = Integer.parseInt(strings[0]);
                xyhs[1] = Integer.parseInt(strings[1]);
                xyhs[2] = Integer.parseInt(strings[2]);
                boxes.add(new Box(xyhs[0], xyhs[1], xyhs[2]));
                boxes.add(new Box(xyhs[0], xyhs[2], xyhs[1]));
                boxes.add(new Box(xyhs[1], xyhs[2], xyhs[0]));
            }
            Collections.sort(boxes);
            Collections.reverse(boxes);
            int[] dp = new int[n * 3];
            dp[0] = boxes.get(0).h;
            int res = -1;
            for (int i = 1; i < dp.length; i++) {
                int max_v = -1;
                for (int j = 0; j < i; j++) {
                    if (boxes.get(j).x > boxes.get(i).x && boxes.get(j).y > boxes.get(i).y) {
                        max_v = Math.max(max_v, dp[j]);
                    }
                }
                if (max_v == -1) {
                    dp[i] = boxes.get(i).h;
                } else {
                    dp[i] = boxes.get(i).h + max_v;
                }
                res = Math.max(res, dp[i]);
            }
            System.out.println(Arrays.toString(dp));
            System.out.println(res);
        }
    }
}
