package tree;

public class MaxDepth {

    public int depth = 1;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, depth);
        return depth;
    }

    public  void dfs(TreeNode root, int depth) {
        if (depth > this.depth) this.depth = depth;
        if (root == null) return;
//        System.out.println(root.val);
        if (root.left != null) dfs(root.left, depth + 1);
        if (root.right != null) dfs(root.right, depth + 1);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        TreeNode root5 = new TreeNode(4);
        root.left = root1;
        root.right = root2;

        root2.left = root3;
        root2.right = root4;

        root4.right = root5;

        System.out.println(new MaxDepth().maxDepth(null));


    }

}
