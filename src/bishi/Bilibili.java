package bishi;

import com.sun.corba.se.spi.ior.IORFactories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/4 19:01
 * @Version 1.0
 */

public class Bilibili {



    public static void main(String[] args) {
        // [1,1,1,0,0,0,1,1,1,1,0],2
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split("]");
        String s1 = strings[0].replace("[", "");
        s1 = s1.replace(" ", "");
        String s2 = strings[1];
        s2 = s2.replace(" ", "");
        s2 = s2.replace(",", "");
        int k = Integer.parseInt(s2);
        int[] nums = new int[(s1.length() + 1) / 2];
        strings = s1.split(",");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        List<Integer> list = new ArrayList<>();
        int flag = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                flag = nums[i];
                continue;
            }
            if (nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                if (flag == 0) {
                    list.add(-cnt);
                } else {
                    list.add(cnt);
                }
                cnt = 1;
                flag = nums[i];
            }
            if (i == nums.length - 1) {
                if (flag == 0) {
                    list.add(-cnt);
                } else {
                    list.add(cnt);
                }
            }
        }
        System.out.println("");



    }
}
