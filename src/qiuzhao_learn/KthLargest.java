package qiuzhao_learn;

import tree.TreeNode;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/22 21:57
 * @Version 1.0
 */

public class KthLargest {

    public static int cnt = 0;
    public static int res = 0;

    public static int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public static void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.right, k);
        if (cnt == k) return;
        cnt++;
        if (cnt == k) {
            res = root.val;
        }
        dfs(root.left, k);

    }

}
