package midium_array_string;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        int[] vis = new int[strs.length];
        int[] lens = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            lens[i] = strs[i].length();
        }
        List<String> list ;
        for (int i = 0; i < strs.length; i++) {
            int[] map1 = new int[26];
            if (vis[i] == 0) {
                list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
                for (int j = 0; j < strs[i].length(); j++) {
                    map1[strs[i].charAt(j) - 'a']++;
                }
                vis[i] = 1;
            } else {
                continue;
            }
            for (int j = i + 1; j < strs.length; j++) {
                int[] map2 = new int[26];
                if (lens[j] != lens[i] || vis[j] == 1) {
                    continue;
                }
                int flag = 1;
                for (int k = 0; k < strs[i].length(); k++) {
                    map2[strs[j].charAt(k) - 'a']++;
                }
                for (int k = 0; k < 26; k++) {
                    if (map1[k] != map2[k]) flag = 0;
                }
                if (flag == 1) {
                    vis[j] = 1;
                    list.add(strs[j]);
                }

            }

        }

        return lists;

    }

    /**
     * 先把字符串转为char[],然后排序,排完序作为hash的key,
     * 判断map中是否有这个key,新建or添加
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s_arr = strs[i].toCharArray();
            Arrays.sort(s_arr);
            String key = String.valueOf(s_arr);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }


        return lists;
    }


    public static void main(String[] args) {
        String[] strings = new String[]{"paw","daa","dad","day","day","mig","len","rat"};
        List<List<String>> lists ;

        lists = new GroupAnagrams().groupAnagrams2(strings);

        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }


    }

}
