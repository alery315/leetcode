package tree;


public class IsValidBST {

    public boolean flag = true;

    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        dfs(root, null, null);
//        return flag;
        return dfs2(root, null, null);
    }
    public  boolean dfs2(TreeNode root, Integer lower, Integer higher) {
//        if (!flag) return;
        if (root == null) return true;
        if (lower != null && root.val <= lower) return false;
        if (higher!= null && root.val >= higher) return false;

        if (! dfs2(root.left, lower, root.val)) return false;
        if (! dfs2(root.right, root.val, higher)) return false;

        return true;
    }

    public  void dfs(TreeNode root, Integer lower, Integer higher) {
//        if (!flag) return;
        if (root == null) return;
        if (lower != null && root.val <= lower) flag = false;
        if (higher!= null && root.val >= higher) flag = false;

//        if ( dfs(root.left, lower, root.val)) return true;
//        if ( dfs(root, root.val, higher)) return true;
        if (root.left != null) dfs(root.left, lower, root.val);
        if (root.right != null) dfs(root.right, root.val, higher);

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(6);
        TreeNode root5 = new TreeNode(4);
        root.left = root1;
        root.right = root2;

        root2.left = root3;
        root2.right = root4;

//        root4.right = root5;

        System.out.println(new IsValidBST().isValidBST(root));


    }

}
