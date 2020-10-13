package bishi;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/10/10 19:30
 * @Version 1.0
 */

public class Jianshe2 {


    public void dfs(int x, int n, int[][] M, int[] visited) {
        visited[x] = 1;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && M[x][i] == 1) {
                dfs(i, n, M, visited);
            }
        }
    }


    public int findFriendNum(int[][] M) {
        // write code here
        int n = M.length;
        int cnt = 0;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, n, M, visited);
                cnt++;
            }
        }
        return cnt;
    }


}
