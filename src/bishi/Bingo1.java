package bishi;

import java.util.Arrays;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/10 19:54
 * @Version 1.0
 */

public class Bingo1 {

    @SuppressWarnings("unchecked")
    public static void quickSort(Object[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high;
        Object pivot = array[low];
        while (i < j) {
            while (i < j && ((Comparable<Object>) array[j]).compareTo(pivot) <= 0) {
                j--;
            }
            if (i < j) array[i] = array[j];
            while (i < j && ((Comparable<Object>) array[i]).compareTo(pivot) >= 0) {
                i++;
            }
            if (i < j) array[j] = array[i];
        }
        array[i] = pivot;
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);
    }

    public static <T extends Comparable<? super T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void sort(int[] array) {
        Integer[] t = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            t[i] = array[i];
        }
        quickSort(t, 0, t.length - 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = t[i];
        }
    }

    public static void sort(float[] array) {
        Float[] t = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            t[i] = array[i];
        }
        quickSort(t, 0, t.length - 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = t[i];
        }
    }

    public static void main(String[] args) {
        sort(new Integer[]{new Integer(4), new Integer(3), new Integer(4), new Integer(1), new Integer(8)});
        sort(new int[]{1, 2, 3, 4, 4, 5, 5});
        sort(new float[]{1.2f,3.3f,4.65f,2.11f});
    }


}
