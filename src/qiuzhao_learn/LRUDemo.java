package qiuzhao_learn;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/3 19:20
 * @Version 1.0
 */

public class LRUDemo {


    public int[] LRU(int[][] operators, int k) {
        // write code here
        Lru<Integer, Integer> lru = new Lru<>(k);
        int len = operators.length;
        if (len < 1) return new int[0];
        int res_cnt = 0;
        for (int i = 0; i < len; i++) {
            if (operators[i][0] == 2) {
                res_cnt++;
            }
        }
        int[] res = new int[res_cnt];
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (operators[i][0] == 1) {
                lru.put(operators[i][1], operators[i][2]);
            } else if (operators[i][0] == 2) {
                Integer t = lru.get(operators[i][1]);
                res[cnt++] = t == null ? -1 : t;
            }
        }

        return res;

    }

    class Lru<K, V> extends LinkedHashMap<K, V> {
        private int max_entries;

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > max_entries;
        }

        Lru(int max_entries) {
            super(max_entries, 1, true);
            this.max_entries = max_entries;
        }

    }

    public static void main(String[] args) {
        new LRUDemo().LRU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}}, 3);

    }


}
