package niuke;

import java.util.*;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-15 19:54
 */
public class Main1 {
    public static void main(String[] args) {

        int x,y;
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        y = Integer.parseInt(s.split(" ")[0]);
        x = Integer.parseInt(s.split(" ")[1]);
        int[][] array = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = sc.nextInt();
            }
        }



        System.out.println("ok");

    }

    public void dfs() {

    }
}
