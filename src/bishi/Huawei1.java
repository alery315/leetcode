package bishi;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/26 19:03
 * @Version 1.0
 */
/*
performance
Adam,125
Andy,110
Bill,92
Evan,154
C,200


D,120


organization
Aaron,Abel,Adam
Aaron,Abel,Andy
Bobbbb,Jone,Bill
Bobbbb,Jone,Evan
CCCCC,CC,C
CCCCC,DD,D
eof
 */

public class Huawei1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();

        int flag = 1;
        while (!s.equals("eof")) {
            if (s.trim().equals("") || s.trim().equals("\n")) {
                s = sc.nextLine();
                continue;
            }
            if (s.equals("performance")) {
                flag = 1;
                s = sc.nextLine();
                continue;
            } else if (s.equals("organization")) {
                flag = 0;
                s = sc.nextLine();
                continue;
            }
            if (flag == 1) {
                String name = s.split(",")[0];
                Integer num = Integer.valueOf(s.split(",")[1]);
                map.put(name, num);
            } else if (flag == 0) {
                String[] strings = s.split(",");
                if (map1.containsKey(strings[0])) {
                    List<String> t = map1.get(strings[0]);
                    t.add(strings[1]);
                    map1.put(strings[0], t);
                } else {
                    List<String> t = new ArrayList<>();
                    t.add(strings[1]);
                    map1.put(strings[0], t);
                }
                if (map2.containsKey(strings[1])) {
                    List<String> t = map2.get(strings[1]);
                    t.add(strings[2]);
                    map2.put(strings[1], t);
                } else {
                    List<String> t = new ArrayList<>();
                    t.add(strings[2]);
                    map2.put(strings[1], t);
                }
            }
            s = sc.nextLine();
        }
        for (String s1 : map1.keySet()) {
            int sum1 = 0;
            List<String> listt = map1.get(s1);
            HashSet<String> set = new HashSet<>(listt);
            for (String s2 : set) {
                int sum2 = 0;
                List<String> list = map2.get(s2);
                for (int i = 0; i < list.size(); i++) {
                    sum2 += map.get(list.get(i));
                }
                map.put(s2, sum2);
                sum1 += sum2;
            }
            map.put(s1, sum1);
        }
        Map<String, Integer> mapa = new HashMap<>();
        Map<String, Integer> mapb = new HashMap<>();
        Map<String, Integer> mapc = new HashMap<>();
        for (String s1 : map1.keySet()) {
            mapa.put(s1, map.get(s1));
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mapa.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + "<" + entry.getValue() + ">");
            List<String> list1 = map1.get(entry.getKey());
            mapb.clear();
            for (int i = 0; i < list1.size(); i++) {
                mapb.put(list1.get(i), map.get(list1.get(i)));
            }
            List<Map.Entry<String, Integer>> list2 = new ArrayList<>(mapb.entrySet());
            Collections.sort(list2, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o2.getValue().equals(o1.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for (Map.Entry<String, Integer> entry2 : list2) {
                System.out.println("-" + entry2.getKey() + "<" + entry2.getValue() + ">");
                List<String> list3 = map2.get(entry2.getKey());
                mapc.clear();
                for (int i = 0; i < list3.size(); i++) {
                    mapc.put(list3.get(i), map.get(list3.get(i)));
                }
                List<Map.Entry<String, Integer>> list4 = new ArrayList<>(mapc.entrySet());
                Collections.sort(list4, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (o2.getValue().equals(o1.getValue())) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });
                for (Map.Entry<String, Integer> entry3 : list4) {
                    System.out.println("--" + entry3.getKey() + "<" + entry3.getValue() + ">");
                }
            }
        }
    }
}
