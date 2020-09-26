package bishi;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/21 15:44
 * @Version 1.0
 */

public class Cucc1 {

    static void fun(String s) {
        System.out.println(s + "+");
    }

    static void fun(Object i) {
        System.out.println(i + ":");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fun(null);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();


    }

}
