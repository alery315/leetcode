package bishi;

import java.util.*;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/16 21:16
 * @Version 1.0
 */

public class Guanglianda3 {

    static class Node {
        int x;
        int hp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].x = sc.nextInt();
            nodes[i].hp = sc.nextInt();
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });
        int res = 0;
        int p = 0;
        while (p < n) {
            int del = nodes[p].hp;
            res += del;
            int j = p + 1;
            while (j < n && nodes[j].x <= 2 * y + nodes[p].x) {
                nodes[j].hp -= del;
                j++;
            }
            int k = p + 1;
            while (k < n && nodes[k].hp <= 0) {
                k++;
            }
            p = k;
        }
        System.out.println(res);
    }
}
