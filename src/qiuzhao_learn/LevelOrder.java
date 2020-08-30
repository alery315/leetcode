package qiuzhao_learn;

import sun.reflect.generics.tree.Tree;
import tree.TreeNode;
import tree.TreeNodeHolder;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/8/14 22:17
 * @Version 1.0
 */

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return lists;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nodeList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                nodeList.add(node);
                list.add(node.val);
            }
            lists.add(list);
            for (int i = 0; i < nodeList.size(); i++) {
                TreeNode node = nodeList.get(i);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }

        return lists;
    }

    public static void main(String[] args) {

        new LevelOrder().levelOrder(TreeNodeHolder.getInstance());

    }

}
