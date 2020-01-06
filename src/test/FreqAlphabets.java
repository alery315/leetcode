package test;

/**
 * @auther alery
 * @create 2020-01-06 20:09
 */
public class FreqAlphabets {

    public String freqAlphabets(String s) {

        int p = s.indexOf("#");
        StringBuilder sb = new StringBuilder(s);
        while (p != -1) {
            char new_s = (char) (Integer.valueOf(sb.substring(p - 2, p)) - 10 + 'j');
            sb.replace(p - 2, p + 1, new_s + "");
            p = sb.indexOf("#");
        }
        for (int i = 0; i < sb.length(); i++) {
            if ('1' <= sb.charAt(i) && sb.charAt(i) <= '9') {
                sb.replace(i, i + 1, (char) (Integer.valueOf(sb.substring(i, i + 1)) - 1 + 'a') + "");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new FreqAlphabets().freqAlphabets("10#11#12"));


    }


}
