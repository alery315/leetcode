package string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        int len = strs.length;
        String s = "";
        if (len == 0) return s;
        int min_len = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min_len = Math.min(min_len, strs[i].length());
        }
        for (int i = 0; i < min_len; i++) {
            char t = strs[0].charAt(i);
            for (int j = 0; j < len; j++) {
                if (strs[j].charAt(i) != t) return s;
            }
            s += t;
        }
        return s;
    }

    public static void main(String[] args) {

        String[] strings = new String[]{"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings));


    }

}
