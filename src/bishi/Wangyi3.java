package bishi;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 15:58
 * @Version 1.0
 */

public class Wangyi3 {

    public static Map<Integer, List<Integer>> map;
    public static Map<Integer, Map<Integer, Integer>> maps;
    public static int dfs(int root) {
        if (map.get(root) == null) {
            return 1;
        }
        List<Integer> list = map.get(root);
        int max_res = 0;
        for (int i = 0; i < list.size(); i++) {
            int t = dfs(list.get(i)) + 1;
            max_res = Math.max(max_res, t);
            if (maps.containsKey(root)) {
                maps.get(root).put(list.get(i), max_res);
            } else {
                Map<Integer, Integer> map1 = new HashMap<>();
                map1.put(list.get(i), max_res);
                maps.put(root, map1);
            }
        }
        return max_res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n - 1];
        map = new HashMap<>();
        maps = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            int t = sc.nextInt();
            array[i] = t;
            if (map.containsKey(t)) {
                map.get(t).add(i + 1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i + 1);
                map.put(t, list);
            }
        }
        int res = dfs(0);
        System.out.println(k + 1);

    }

}
