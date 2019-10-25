package math;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) return ret;
        List<Integer> l = new ArrayList<>();
        l.add(1);
        ret.add(l);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
            }
            list.add(1);
            ret.add(list);
        }

        return ret;
    }

    public static void main(String[] args) {


        List<List<Integer>> ret = generate(6);
        for (List<Integer> integers : ret) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }


}
