package tree;

/**
 * @auther alery
 * @create 2019-12-12 20:48
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.left != null) {
            TreeNode t = lowestCommonAncestor(root.left, p, q);
            if (t != null) return t;
        }

        if (root.right != null) {
            TreeNode t = lowestCommonAncestor(root.right, p, q);
            if (t != null) return t;
        }

        if (findNode(root, p) && findNode(root, q)) {
            return root;
        }

        return null;
    }

    public boolean findNode(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;

        if (root.left != null) {
            if (findNode(root.left, p)) {
                return true;
            }
        }
        if (root.right != null) {
            if (findNode(root.right, p)) {
                return true;
            }
        }

        return false;

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

        TreeNode node = new LowestCommonAncestor().lowestCommonAncestor(root, root2, root5);

        System.out.println(node.val);

    }

}
