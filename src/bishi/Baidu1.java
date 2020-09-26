package bishi;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/14 19:20
 * @Version 1.0
 */

public class Baidu1 {

    static int search(int[] nums, int l, int r, int x) {
        if (r >= l) {
            int mid = (l + r) / 2;
            if (nums[mid] == x) {
                return mid;
            } else if (nums[mid] > x) {
                return search(nums, l, mid - 1, x);
            } else {
                return search(nums, mid + 1, r, x);
            }
        } else {
            return r;
        }
    }

    /*
1
3 6
33 33 33
33 33 33 33 66 90
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int m = sc.nextInt();
            int[] brr = new int[m];
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                if (map.containsKey(arr[j])) {
                    map.get(arr[j]).add(j);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    map.put(arr[j], list);
                }
            }
            for (int j = 0; j < m; j++) {
                brr[j] = sc.nextInt();
            }
//            Arrays.sort(brr);
//            Arrays.sort(arr);
            int cnt = 0;
            int[] res = new int[n];
            for (int j = 0; j < brr.length; j++) {
                if (cnt >= n) {
                    break;
                }
                int op = arr[cnt];

                if (j == 0) {
                    if (op > brr[j]) {
                        continue;
                    } else {
                        for (int k = 0; k < map.get(op).size(); k++) {
                            res[map.get(op).get(k)] = brr.length - j;
                        }
                        cnt++;
                        j--;
                        continue;
                    }
                }
                if (op > brr[j - 1] && op <= brr[j]) {
                    for (int k = 0; k < map.get(op).size(); k++) {
                        res[map.get(op).get(k)] = brr.length - j;
                    }
                    cnt++;
                }
            }
            for (int j = 0; j < res.length-1; j++) {
                System.out.print(res[j]+" ");
            }
            if (res.length > 1) {
                System.out.println(res[res.length-1]);
            }
        }
    }

}
