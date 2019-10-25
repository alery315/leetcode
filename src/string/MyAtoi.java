package string;

public class MyAtoi {

    public static int myAtoi(String str) {

        if (str.length() == 0) {
            return 0;
        }

        long m = Integer.MAX_VALUE, n = Integer.MIN_VALUE;

        int i = 0;

        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if (i == str.length()) {
            return 0;
        }

        if (notScale(str.charAt(i))) {
            return 0;
        }

        while (notScale(str.charAt(i))) {
            i++;
        }

        int flag = 0;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            flag = str.charAt(i) == '+' ? 0 : 1;
            i++;
            if (i < str.length() && (str.charAt(i) < '0' || str.charAt(i) > '9')) {
                return 0;
            }
        }

        long result = 0;

        while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            result = (str.charAt(i) - '0') + result * 10;
            i++;
            if (result > m || result < n) {
                if (flag == 0) {
                    return (int) m;
                } else {
                    return (int) n;
                }

            }
        }
        if (flag == 1) {
            result *= -1;
        }
        if (result <= m && result >= n) {
            return (int) result;
        } else if (flag == 0) {
            return (int) m;
        } else {
            return (int) n;
        }

    }



    public static boolean notScale(char c) {
        if (c >= '0' && c <= '9' || c == '+' || c == '-') {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(myAtoi("18446744073709551617"));


    }

}
