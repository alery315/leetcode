package niuke;

import java.util.Scanner;
public class SystemInOut {

    public static void main(String[] args) {

        int d, w;
        int[] position;
        int[] supply;
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        d = Integer.parseInt(s.split(" ")[0]);
        w = Integer.parseInt(s.split(" ")[1]);
        s = sc.nextLine();

        String[] strings = s.split(" ");
        int len = strings.length;
        position = new int[len];
        supply = new int[len];

        for (int i = 0; i < len; i++) {
            position[i] = Integer.parseInt(strings[i]);
        }
        s = sc.nextLine();
        strings = s.split(" ");
        for (int i = 0; i < len; i++) {
            supply[i] = Integer.parseInt(strings[i]);
        }

        int start = -1;
        int max_supply = 0;
        int p_max_supply = -1;
        int count = 0;
        while (d > w) {
            for (int i = start+1; i < len; i++) {
                if (position[i] <= w) {
                    if (supply[i] >= max_supply) {
                        max_supply = supply[i];
                        p_max_supply = i;
                    }
                } else {
                    break;
                }
            }
            w += max_supply;
            start = p_max_supply;
            count++;
            if (w >= d) {
                break;
            }
            if (start == -1) {
                System.out.println("-1");
                return;
            }
            max_supply = 0;
            p_max_supply = -1;
        }
        System.out.println(count);
    }

}
