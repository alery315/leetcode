package bishi;



import java.util.HashMap;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 15:06
 * @Version 1.0
 */


public class Wangyi1 {

    static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }


    }

    public static int res = 0;

    public static boolean dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        int cnt = 0;
        if (node.left != null) {
            if (dfs(node.left)) {
                cnt++;
            }
        }
        if (node.right != null) {
            if (dfs(node.right)) {
                cnt++;
            }
        }
        if (cnt == 2) {
            res++;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, TreeNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] strings = s.split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[2]);
            if (!map.containsKey(String.valueOf(a))) {
                map.put(String.valueOf(a), new TreeNode(a));
            }
            if (strings[1].equals("left")) {
                TreeNode treeNode = new TreeNode(b);
                if (!map.containsKey(String.valueOf(b))) {
                    map.put(String.valueOf(b), treeNode);
                }
                map.get(String.valueOf(a)).left = treeNode;
            } else {
                TreeNode treeNode = new TreeNode(b);
                if (!map.containsKey(String.valueOf(b))) {
                    map.put(String.valueOf(b), treeNode);
                }
                map.get(String.valueOf(a)).right = treeNode;
            }
        }
        TreeNode root = map.get("1");
        dfs(root);
        System.out.println(res);

    }

}
