package string;

/**
 * @Description
 * @auther alery
 * @create 2019-09-17 下午4:16
 */

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map1[(int) s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            map2[(int) t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {

        String s = "aaaaaa", t = "na";

        System.out.println(isAnagram(s, t));

    }

}
