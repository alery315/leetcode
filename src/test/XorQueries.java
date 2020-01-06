package test;

/**
 * @auther alery
 * @create 2020-01-06 20:49
 */
public class XorQueries {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int result = arr[start];
            for (int j = start + 1; j <= end; j++) {
                result = result ^ arr[j];
            }
            res[i] = result;
        }

        return res;
    }

    public int[] xorQueries2(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int[] t = new int[arr.length + 1];

        t[0] = arr[0];
        for (int i = 1; i < t.length; i++) {
            t[i] = t[i - 1] ^ arr[i - 1];
        }
        int count = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            res[count++] = t[l] ^ t[r + 1];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 8, 7};
        int[][] queries = {{1, 3}, {1, 2}, {0, 3}, {3, 3}};
        new XorQueries().xorQueries2(arr, queries);

    }

}
