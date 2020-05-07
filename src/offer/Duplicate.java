package offer;

import java.util.HashMap;

/**
 * @author alery
 * @Description
 * @create 2020-05-07 20:42
 */
public class Duplicate {

    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length < 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                map.put(numbers[i], 1);
            }
        }
        return false;
    }

    public static boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || length < 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] > length) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        int[] dup = new int[1];
        System.out.println(duplicate2(array, 7, dup));
        System.out.println(dup[0]);
    }

}
