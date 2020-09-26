package bishi;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/13 16:14
 * @Version 1.0
 */

public class Sina2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static List<Integer> list = new ArrayList<>();

    static TreeNode fun(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode new_root = fun(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return new_root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            inOrder(root.left);
        }

        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        int[] arr = new int[strings.length];
        int len = arr.length;

        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            map.put(arr[i], new TreeNode(arr[i]));
        }
        if (len < 2) {
            System.out.println(arr[0]);
        }
        int i = 1;
        int p = 0;

        for (; i < len; ) {
            TreeNode node = map.get(arr[p]);
            if (i < len) {
                node.left = map.get(arr[i]);
            }
            i++;
            if (i < len) {
                node.right = map.get(arr[i]);
            }
            i++;
            p++;
        }
        TreeNode root = map.get(arr[0]);
        TreeNode res = fun(root);
        inOrder(res);
        for (int j = 0; j < list.size() - 1; j++) {
            System.out.print(list.get(j) + ",");
        }
        if (list.size() > 1) {
            System.out.println(list.get(list.size() - 1));
        }
    }
}
