package string;

/**
 * @Description
 * @auther alery
 * @create 2019-09-17 下午2:47
 */

public class ReverseString {

    public static void reverseString(char[] chars) {

        int len = chars.length;

        for (int i = 0; i < len / 2; i++) {
            char c = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = c;
        }

    }

    public static void main(String[] args) {

        char[] chars = {'1', '2', '3', '4', '5'};

        reverseString(chars);

        System.out.println(chars);


    }

}
