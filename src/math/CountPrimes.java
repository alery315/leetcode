package math;

public class CountPrimes {

    // 这里有埃氏筛 o(nloglogn)与欧拉筛 o(n)
    // 下面的代码是欧拉筛
    public static int countPrimes(int n) {
        int cnt = 0;
        int[] prime = new int[n];
        boolean[] vis = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (!vis[i]) prime[cnt++] = i;
            for (int j = 0; j < cnt; j++) {
                if (i * prime[j] >= n) break;
                vis[i * prime[j]] = true;
                if (i % prime[j] == 0) break;
            }
        }

        for (int i = 0; i < cnt; i++) {
            System.out.println(prime[i]);
        }

        return cnt;

    }

    public static void main(String[] args) {

        System.out.println(countPrimes(109));

    }

}
