package niuke;

import tree.TreeNode;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-22 21:40
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return Math.max(left, right) + 1;

    }
}
