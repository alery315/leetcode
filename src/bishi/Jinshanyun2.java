package bishi;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/16 19:27
 * @Version 1.0
 */
/*
3 5 6 -1 -1 2 7 -1 -1 4 -1 -1 1 9 -1 -1 8 -1 -1
5 1
3 5 6 7 9 -1 -1 8 -1 2 -1 -1 11
8 9
 */

public class Jinshanyun2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode getCommon(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = getCommon(root.left, p, q);
        TreeNode right = getCommon(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int[] arr = new int[strings.length];
        int[] arr2 = new int[strings.length];
        HashMap<Integer, TreeNode> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            if (arr[i] != -1) {
                arr2[cnt++] = arr[i];
            }
            map.put(arr[i], new TreeNode(arr[i]));
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i = 1;
        int p = 0;
        int len = arr.length;
        for (; i < len; ) {
            TreeNode node = map.get(arr2[p]);
            if (i < len) {
                if (arr[i] != -1) {
                    node.left = map.get(arr[i]);
                    map.get(arr[i]).parent = node;
                } else {
                    node.left = null;
                }
            }
            i++;
            if (i < len) {
                if (arr[i] != -1) {
                    node.right = map.get(arr[i]);
                    map.get(arr[i]).parent = node;
                } else {
                    node.right = null;
                }
            }
            i++;
            p++;
        }
        TreeNode node = getCommon(map.get(arr[0]), map.get(a), map.get(b));
        int res = node.val;
        if (res == a) {
            System.out.println(map.get(a).parent.val);
        } else if (res == b) {
            System.out.println(map.get(b).parent.val);
        } else {
            System.out.println(res);
        }

    }

}
