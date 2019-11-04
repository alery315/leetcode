package tree;

public class IsValidBST {

    public int flag = 1;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        dfs(root);
        return flag == 1 ? true : false;
    }

    public  void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.val <= root.left.val)
            flag = 0;
        if (root.right != null && root.val >= root.right.val)
            flag = 0;
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(7);
        TreeNode root5 = new TreeNode(4);
        root.left = root1;
        root.right = root2;

        root2.left = root3;
        root2.right = root4;

//        root4.right = root5;

        System.out.println(new IsValidBST().isValidBST(root));


    }

}
