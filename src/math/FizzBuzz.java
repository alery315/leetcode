package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
                continue;
            } else if (i % 5 == 0) {
                result.add("Buzz");
                continue;
            } else if (i % 3 == 0) {
                result.add("Fizz");
                continue;
            }
            result.add(String.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> l = fizzBuzz(100);
        for (String s : l) {
            System.out.println(s);
        }

    }

}
