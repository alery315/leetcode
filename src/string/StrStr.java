package string;

public class StrStr {

    public static int strStr(String haystack, String needle) {

        if (needle == "") {
            return 0;
        }

        return haystack.indexOf(needle);

//        return -1;
    }


    public static void main(String[] args) {

        String haystack = "hello", needle = "ll";

        System.out.println(strStr(haystack, needle));

    }



}
