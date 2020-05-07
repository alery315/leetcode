package alibaba;

import java.util.Scanner;

public class EqualDiffArray {


    public static void main(String[] args) {

        int n, m, op;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        op = sc.nextInt();
        int[][] array = new int[n][m];
        int[][] ops = new int[op][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < op; i++) {
            for (int j = 0; j < 2; j++) {
                ops[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int a = -1;
            int pa = 0;
            int p = 0;
            int pb = 0;
            int b = -1;
            while (p < m) {
                if (array[i][p] != 0) {
                    a = array[i][p];
                    pa = p;
                    p++;
                    break;
                }
                p++;
            }
            if (p == m) {
                continue;
            }
            while (p < m) {
                if (array[i][p] != 0) {
                    b = array[i][p];
                    pb = p;
                    break;
                }
                p++;
            }
            if (p == m) {
                break;
            }

            int temp = (b - a) / (pb - pa);
            int init = a - pa * temp;
            // fill
            for (int j = 0; j < m; j++) {
                array[i][j] = init + j * temp;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = -1;
            int pa = 0;
            int p = 0;
            int pb = 0;
            int b = -1;
            while (p < n) {
                if (array[p][i] != 0) {
                    a = array[p][i];
                    p++;
                    pa = p;
                    break;
                }
                p++;
            }
            if (p == n) {
                continue;
            }
            while (p < n) {
                if (array[p][i] != 0) {
                    b = array[p][i];
                    pb = p;
                    break;
                }
                p++;
            }
            if (p == n) {
                break;
            }

            int temp = (b - a) / (pb - pa);
            int init;
            init = a - pa * temp;
            // fill
            for (int j = 0; j < m; j++) {
                array[j][i] = init + j * temp;
            }
        }

        for (int i = 0; i < op; i++) {
            if (array[ops[i][0]-1][ops[i][1]-1] == 0) {
                System.out.println("unknown");
            } else {
                System.out.println(array[ops[i][0] - 1][ops[i][1] - 1]);
            }
        }

    }

}
