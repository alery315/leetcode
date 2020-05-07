package niuke;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-13 22:36
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                sb.append("%20");
            }
        }


        return sb.toString();
    }

}
