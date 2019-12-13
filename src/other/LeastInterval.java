package other;

import java.util.*;

/**
 * @auther alery
 * @create 2019-12-13 15:50
 */
public class LeastInterval {

    /**
     * 方法错误
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            } else {
                map.put(tasks[i], 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder task = new StringBuilder();
        int pre_len = 0;
        int cnt = 0;
        int pre_cnt = 0;
        while (cnt < tasks.length) {
            for (Map.Entry<Character, Integer> entry : list) {
                if (entry.getValue() > 0) {
                    task.append(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                    cnt++;
                    if (cnt - pre_cnt == n + 1) {
                        pre_cnt = cnt;
                        break;
                    }
                }
            }
            int diff = task.length() - pre_len;
            if (diff < n + 1 && cnt != tasks.length) {
                for (int i = 0; i < n + 1 - diff; i++) {
                    task.append('*');
                }
            }
            pre_cnt = cnt;
            pre_len = task.length();
        }

        System.out.println(task.toString());

        return pre_cnt;
    }

    /**
     * 解题思路：
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，
     *      如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     *      则retCount++ ==> A->B->X->A->B->X->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval2(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) return tasks.length;
        //步骤1
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        //步骤2
        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        int i = 24;
        //步骤3
        while (i >= 0 && counts[i] == maxCount) {
            retCount++;
            i--;
        }
        //步骤4
        return Math.max(retCount, tasks.length);
    }

    
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//        char[] tasks = {'G', 'C', 'A', 'H', 'A', 'G', 'G', 'F', 'G', 'J', 'H', 'C', 'A', 'G', 'E', 'A', 'H', 'E', 'F', 'D', 'B', 'D', 'H', 'H', 'E', 'G', 'F', 'B', 'C', 'G', 'F', 'H', 'J', 'F', 'A', 'C', 'G', 'D', 'I', 'J', 'A', 'G', 'D', 'F', 'B', 'F', 'H', 'I', 'G', 'J', 'G', 'H', 'F', 'E', 'H', 'J', 'C', 'E', 'H', 'F', 'C', 'E', 'F', 'H', 'H', 'I', 'G', 'A', 'G', 'D', 'C', 'B', 'I', 'D', 'B', 'C', 'J', 'I', 'B', 'G', 'C', 'H', 'D', 'I', 'A', 'B', 'A', 'J', 'C', 'E', 'B', 'F', 'B', 'J', 'J', 'D', 'D', 'H', 'I', 'I', 'B', 'A', 'E', 'H', 'J', 'J', 'A', 'J', 'E', 'H', 'G', 'B', 'F', 'C', 'H', 'C', 'B', 'J', 'B', 'A', 'H', 'B', 'D', 'I', 'F', 'A', 'E', 'J', 'H', 'C', 'E', 'G', 'F', 'G', 'B', 'G', 'C', 'G', 'A', 'H', 'E', 'F', 'H', 'F', 'C', 'G', 'B', 'I', 'E', 'B', 'J', 'D', 'B', 'B', 'G', 'C', 'A', 'J', 'B', 'J', 'J', 'F', 'J', 'C', 'A', 'G', 'J', 'E', 'G', 'J', 'C', 'D', 'D', 'A', 'I', 'A', 'J', 'F', 'H', 'J', 'D', 'D', 'D', 'C', 'E', 'D', 'D', 'F', 'B', 'A', 'J', 'D', 'I', 'H', 'B', 'A', 'F', 'E', 'B', 'J', 'A', 'H', 'D', 'E', 'I', 'B', 'H', 'C', 'C', 'C', 'G', 'C', 'B', 'E', 'A', 'G', 'H', 'H', 'A', 'I', 'A', 'B', 'A', 'D', 'A', 'I', 'E', 'C', 'C', 'D', 'A', 'B', 'H', 'D', 'E', 'C', 'A', 'H', 'B', 'I', 'A', 'B', 'E', 'H', 'C', 'B', 'A', 'D', 'H', 'E', 'J', 'B', 'J', 'A', 'B', 'G', 'J', 'J', 'F', 'F', 'H', 'I', 'A', 'H', 'F', 'C', 'H', 'D', 'H', 'C', 'C', 'E', 'I', 'G', 'J', 'H', 'D', 'E', 'I', 'J', 'C', 'C', 'H', 'J', 'C', 'G', 'I', 'E', 'D', 'E', 'H', 'J', 'A', 'H', 'D', 'A', 'B', 'F', 'I', 'F', 'J', 'J', 'H', 'D', 'I', 'C', 'G', 'J', 'C', 'C', 'D', 'B', 'E', 'B', 'E', 'B', 'G', 'B', 'A', 'C', 'F', 'E', 'H', 'B', 'D', 'C', 'H', 'F', 'A', 'I', 'A', 'E', 'J', 'F', 'A', 'E', 'B', 'I', 'G', 'H', 'D', 'B', 'F', 'D', 'B', 'I', 'B', 'E', 'D', 'I', 'D', 'F', 'A', 'E', 'H', 'B', 'I', 'G', 'F', 'D', 'E', 'B', 'E', 'C', 'C', 'C', 'J', 'J', 'C', 'H', 'I', 'B', 'H', 'F', 'H', 'F', 'D', 'J', 'D', 'D', 'H', 'H', 'C', 'D', 'A', 'J', 'D', 'F', 'D', 'G', 'B', 'I', 'F', 'J', 'J', 'C', 'C', 'I', 'F', 'G', 'F', 'C', 'E', 'G', 'E', 'F', 'D', 'A', 'I', 'I', 'H', 'G', 'H', 'H', 'A', 'J', 'D', 'J', 'G', 'F', 'G', 'E', 'E', 'A', 'H', 'B', 'G', 'A', 'J', 'J', 'E', 'I', 'H', 'A', 'G', 'E', 'C', 'D', 'I', 'B', 'E', 'A', 'G', 'A', 'C', 'E', 'B', 'J', 'C', 'B', 'A', 'D', 'J', 'E', 'J', 'I', 'F', 'F', 'C', 'B', 'I', 'H', 'C', 'F', 'B', 'C', 'G', 'D', 'A', 'A', 'B', 'F', 'C', 'D', 'B', 'I', 'I', 'H', 'H', 'J', 'A', 'F', 'J', 'F', 'J', 'F', 'H', 'G', 'F', 'D', 'J', 'G', 'I', 'E', 'B', 'C', 'G', 'I', 'F', 'F', 'J', 'H', 'H', 'G', 'A', 'A', 'J', 'C', 'G', 'F', 'B', 'A', 'A', 'E', 'E', 'A', 'E', 'I', 'G', 'F', 'D', 'B', 'I', 'F', 'A', 'B', 'J', 'F', 'F', 'J', 'B', 'F', 'J', 'F', 'J', 'F', 'I', 'E', 'J', 'H', 'D', 'G', 'G', 'D', 'F', 'G', 'B', 'J', 'F', 'J', 'A', 'J', 'E', 'G', 'H', 'I', 'E', 'G', 'D', 'I', 'B', 'D', 'J', 'A', 'A', 'G', 'A', 'I', 'I', 'A', 'A', 'I', 'I', 'H', 'E', 'C', 'A', 'G', 'I', 'F', 'F', 'C', 'D', 'J', 'J', 'I', 'A', 'A', 'F', 'C', 'J', 'G', 'C', 'C', 'H', 'E', 'A', 'H', 'F', 'B', 'J', 'G', 'I', 'A', 'A', 'H', 'G', 'B', 'E', 'G', 'D', 'I', 'C', 'G', 'J', 'C', 'C', 'I', 'H', 'B', 'D', 'J', 'H', 'B', 'J', 'H', 'B', 'F', 'J', 'E', 'J', 'A', 'G', 'H', 'B', 'E', 'H', 'B', 'F', 'F', 'H', 'E', 'B', 'E', 'G', 'H', 'J', 'G', 'J', 'B', 'H', 'C', 'H', 'A', 'A', 'B', 'E', 'I', 'H', 'B', 'I', 'D', 'J', 'J', 'C', 'D', 'G', 'I', 'J', 'G', 'J', 'D', 'F', 'J', 'E', 'F', 'D', 'E', 'B', 'D', 'B', 'C', 'B', 'B', 'C', 'C', 'I', 'F', 'D', 'E', 'I', 'G', 'G', 'I', 'B', 'H', 'G', 'J', 'A', 'A', 'H', 'I', 'I', 'H', 'A', 'I', 'F', 'C', 'D', 'A', 'C', 'G', 'E', 'G', 'E', 'E', 'H', 'D', 'C', 'G', 'D', 'I', 'A', 'G', 'G', 'D', 'A', 'H', 'H', 'I', 'F', 'E', 'I', 'A', 'D', 'H', 'B', 'B', 'G', 'I', 'C', 'G', 'B', 'I', 'I', 'D', 'F', 'F', 'C', 'C', 'A', 'I', 'E', 'A', 'E', 'J', 'A', 'H', 'C', 'D', 'A', 'C', 'B', 'G', 'H', 'G', 'J', 'G', 'I', 'H', 'B', 'A', 'C', 'H', 'I', 'D', 'D', 'C', 'F', 'G', 'B', 'H', 'E', 'B', 'B', 'H', 'C', 'B', 'G', 'G', 'C', 'F', 'B', 'E', 'J', 'B', 'B', 'I', 'D', 'H', 'D', 'I', 'I', 'A', 'A', 'H', 'G', 'F', 'B', 'J', 'F', 'D', 'E', 'G', 'F', 'A', 'G', 'G', 'D', 'A', 'B', 'B', 'B', 'J', 'A', 'F', 'H', 'H', 'D', 'C', 'J', 'I', 'A', 'H', 'G', 'C', 'J', 'I', 'F', 'J', 'C', 'A', 'E', 'C', 'H', 'J', 'H', 'H', 'F', 'G', 'E', 'A', 'C', 'F', 'J', 'H', 'D', 'G', 'G', 'D', 'D', 'C', 'B', 'H', 'B', 'C', 'E', 'F', 'B', 'D', 'J', 'H', 'J', 'J', 'J', 'A', 'F', 'F', 'D', 'E', 'F', 'C', 'I', 'B', 'H', 'H', 'D', 'E', 'A', 'I', 'A', 'B', 'F', 'G', 'F', 'F', 'I', 'E', 'E', 'G', 'A', 'I', 'D', 'F', 'C', 'H', 'E', 'C', 'G', 'H', 'F', 'F', 'H', 'J', 'H', 'G', 'A', 'E', 'H', 'B', 'G', 'G', 'D', 'D', 'D', 'F', 'I', 'A', 'F', 'F', 'D', 'E', 'H', 'J', 'E', 'D', 'D', 'A', 'J', 'F', 'E', 'E', 'E', 'F', 'I', 'D', 'A', 'F', 'F', 'J', 'E', 'I', 'J', 'D', 'D', 'G', 'A', 'C', 'G', 'G', 'I', 'E', 'G', 'E', 'H', 'E', 'D', 'E', 'J', 'B', 'G', 'I', 'J', 'C', 'H', 'C', 'C', 'A', 'A', 'B', 'C', 'G', 'B', 'D', 'I', 'D', 'E', 'H', 'J', 'J', 'B', 'F', 'E', 'J', 'H', 'H', 'I', 'G', 'B', 'D'};
        System.out.println(new LeastInterval().leastInterval2(tasks, 2));

    }


}
