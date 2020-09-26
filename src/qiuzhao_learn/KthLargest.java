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

    public int kthLargest(TreeNode root, int k) {
        cnt = k;
        dfs(root, k);
        return res;
    }

    public static void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (cnt == 0) return;
        dfs(root.right, k);
        if (--cnt == 0) {
            res = root.val;
        }
        dfs(root.left, k);

    }

}
