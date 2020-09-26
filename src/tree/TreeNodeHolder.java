package tree;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/14 22:19
 * @Version 1.0
 */

public class TreeNodeHolder {

    public static TreeNode getInstance() {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);

        root.left = root1;

        root.right = root2;

        root2.left = root3;
        root2.right = root4;
        return root;
    }

    public static TreeNode getInstance2() {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(0);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;
        return root;
    }

}
