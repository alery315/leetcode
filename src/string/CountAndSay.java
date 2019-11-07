package string;

public class CountAndSay {

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 1) return "1";
        sb.append("1");
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder temp_sb = new StringBuilder();
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(j) != sb.charAt(j + 1)) {
                    temp_sb.append(count);
                    temp_sb.append(sb.charAt(j));
                    count = 1;
                } else {
                    count++;
                }
            }
            temp_sb.append(count);
            temp_sb.append(sb.charAt(sb.length() - 1));
            sb = temp_sb;
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(countAndSay(7));

    }

}
