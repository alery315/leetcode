package niuke;

import javax.swing.plaf.metal.MetalIconFactory;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-26 19:05
 */
public class Main13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        long[][] array = new long[2][m + 1];

        for (int j = 1; j < m; j++) {
            array[0][j] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                array[1][j] = 0;
                array[1][j] += array[1][j - 1];
                array[1][j] += array[0][j];
                if (array[1][j] > 1000000007) {
                    array[1][j] %= 1000000007;
                }
                if (j >= 2) {
                    array[0][j - 1] = array[1][j - 1];
                }

//                for (int k = 1; k <= j; k++) {
//                    array[1][j] += array[0][k];
//                    if (array[1][j] > 1000000007) {
//                        array[1][j] %= 1000000007;
//                    }
//                }


            }
            array[0][1] = array[1][1];
            array[0][m] = array[1][m];
//            for (int k = 1; k <= m; k++) {
//                array[0][k] = array[1][k];
//            }
        }

        System.out.println(array[1][m]);

    }

}
