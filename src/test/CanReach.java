package test;

/**
 * @auther alery
 * @create 2020-01-03 15:33
 */
public class CanReach {

    public boolean flag = false;

    public CanReach() {
        System.out.println("can reach");
    }

    public CanReach(boolean flag) {
        this.flag = flag;
    }

    public boolean canReach(int[] arr, int start) {

        int[] visited = new int[arr.length];
        System.out.println("yes i can");
        dfs(arr, start, visited);

        return flag;
    }

    public void dfs(int[] arr, int start,int[] vis) {
//        System.out.println(arr[start]);
        if (flag == true || vis[start] == 1) return;
        if (arr[start] == 0) flag = true;
        vis[start] = 1;
        if (0 <= start + arr[start] && start + arr[start] < arr.length) dfs(arr, start + arr[start],vis);
        if (0 <= start - arr[start] && start - arr[start] < arr.length) dfs(arr, start - arr[start],vis);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{0,1};

        System.out.println(new CanReach().canReach(arr, 1));


    }


}
