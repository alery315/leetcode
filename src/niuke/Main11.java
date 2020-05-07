package niuke;

import java.util.Scanner;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-26 19:05
 */
public class Main11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array_map = new int[10];
        String num_s = sc.nextLine();
        for (int i = 1; i < 10; i++) {
            array_map[i] = sc.nextInt();
        }
        char[] chars_num = num_s.toCharArray();
        for (int i = 0; i < chars_num.length; i++) {
            if (chars_num[i] > '0' && chars_num[i] <= '9') {
                int index = chars_num[i] - '0';
                chars_num[i] = (char) ('0' + array_map[index]);
//                System.out.println(array_map[index]);
            }
        }

        System.out.println(new String(chars_num));
    }

}
