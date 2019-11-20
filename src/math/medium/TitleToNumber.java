package math.medium;

/**
 * @auther alery
 * @create 2019-11-20 22:36
 */
public class TitleToNumber {

    public int titleToNumber(String s) {
        int len = s.length();
        int exp = 1;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            ans += exp * (s.charAt(i) - 'A' + 1);
            exp *= 26;
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new TitleToNumber().titleToNumber("AB"));

    }

}
