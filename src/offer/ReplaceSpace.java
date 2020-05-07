package offer;

/**
 * @author alery
 * @Description
 * @create 2020-05-07 22:29
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "we are the world";
        System.out.println(new ReplaceSpace().replaceSpace(s));
    }
}
