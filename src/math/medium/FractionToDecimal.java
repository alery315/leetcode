package math.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther alery
 * @create 2019-12-13 13:50
 */
public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) return "0";
        if (denominator == 0) return "";

        StringBuilder fraction = new StringBuilder();

        if (numerator > 0 ^ denominator > 0) fraction.append('-');

        long num = Math.abs(Long.valueOf(numerator));
        long denom = Math.abs(Long.valueOf(denominator));

        fraction.append(num / denom);

        long reminder = num % denom;

        if (reminder != 0) fraction.append('.');

        Map<Long, Integer> map = new HashMap<>();

        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                fraction.insert(map.get(reminder), "(");
                fraction.append(")");
                break;
            }
            map.put(reminder, fraction.length());
            reminder *= 10;
            fraction.append(reminder / denom);
            reminder %= denom;
        }

        return fraction.toString();
    }

    public static void main(String[] args) {

        System.out.println(new FractionToDecimal().fractionToDecimal(-1,-2147483648));


    }

}
