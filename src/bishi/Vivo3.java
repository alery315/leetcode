package bishi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 20:59
 * @Version 1.0
 */

public class Vivo3 {
    public String compileSeq(String input) {
        // write code here
        if (input == null || input.equals("")) {
            return "";
        }
        String[] strings = input.split(",");
        int[] arr = new int[strings.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
        if (!map.containsKey(-1)) {
            return "";
        }
//        int[] arr2 = new int[max_v + 1];
//        for (int i = 0; i < arr.length; i++) {
//            arr2[]
//        }
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        int[] visit = new int[strings.length];
        while (cnt < strings.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == -1 && visit[i] != 1) {
                    list.add(i);
                    visit[i] = 1;
                    cnt++;
                    if (map.containsKey(i)) {
                        for (int j = 0; j < map.get(i).size(); j++) {
                            arr[map.get(i).get(j)] = -2;
                        }
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == -2 && visit[i] != 1) {
                    arr[i] += 1;
                }
            }
        }
        String s = "";
        for (int i = 0; i < list.size()-1; i++) {
            s += list.get(i);
            s += ",";
        }
        if (list.size() >= 1) {
            s += list.get(list.size() - 1);
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Vivo3().compileSeq("1,2,-1,1"));
        System.out.println(new Vivo3().compileSeq("1,1,1"));
    }
}
