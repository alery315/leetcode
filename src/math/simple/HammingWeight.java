package math.simple;

public class HammingWeight {

    public static int hammingWeight(long n) {
        long ni = n;
        int count = 0;
        while (ni != 0) {
            if ((ni & 1) == 1) {
                count++;
            }
            ni = ni >> 1;
            if (ni == 1) {
                count++;
                return count;
            }
//            System.out.println(count + ":" + n);
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(hammingWeight(4294967293L));

    }

}
