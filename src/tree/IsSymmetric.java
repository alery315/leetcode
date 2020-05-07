package tree;

public class IsSymmetric {

    public boolean flag = true;

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return flag;
        if (root.left == null && root.right == null) return flag;
        dfs(root.left,root.right);
        return flag;
    }

    public void dfs(TreeNode left, TreeNode right) {
//        System.out.println(left.val + ":" + right.val);

        if (left != null && right != null) {
            if (left.val != right.val){
                flag = false;
                return;
//            System.out.println("value not equal");
            }
        }else if (left == null && right == null){
            return;
        }else {
            flag = false;
            return;
        }




        if (left.left == null && right.right == null) {

        } else if (left.left != null && right.right != null) {
            dfs(left.left, right.right);
        } else {
//            System.out.println("one null,other is not null1");
            flag = false;
            return;
        }
        if (left.right == null && right.left == null) {

        } else if (left.right != null && right.left != null) {
            dfs(left.right, right.left);
        } else {
//            System.out.println("one null,other is not null2");
            flag = false;
            return;
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(44);
        TreeNode root6 = new TreeNode(3);
        root.left = root1;
        root.right = root2;

        root1.left = root3;
//        root1.right = root4;

//        root2.left = root5;
        root2.right = root6;

        System.out.println(new IsSymmetric().isSymmetric(root));

    }


}
