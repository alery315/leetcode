package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @auther alery
 * @create 2019-09-17 上午10:03
 */

public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {

        int len = nums1.length > nums2.length ? nums1.length : nums2.length;

        int[] result = new int[len];
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap();

        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                continue;
            }
            map.put(i, 1);
        }

        for (int i : nums2) {
            if (map.containsKey(i)) {
                if (map.get(i) > 0) {
                    map.put(i, map.get(i) - 1);
                    result[count++] = i;
                }
            }
        }



        int[] t = new int[count];

        System.arraycopy(result,0,t,0,count);

        return t;
    }

    public static void main(String[] args) {


        int[] nums1 = {1,2,2,1}, nums2 = {2,2,8,4};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));


    }

}
