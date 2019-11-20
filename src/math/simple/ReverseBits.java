package math.simple;

public class ReverseBits {

    /**
     * 左移情况,末尾全部补0
     * 右移情况,与最高位相同,最高位为1就补1,0就是补0
     * ret先左移空出一个0,每次取n的最后一位,然后加到ret上,然后n右移一位
     *
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret += n & 1;
            n >>= 1;
        }

        return ret;
    }

    public static int reverseBits2(int i) {
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        return (i << 24) | ((i & 0xff00) << 8) | ((i >>> 8) & 0xff00) | i >> 24;
    }

    public static void main(String[] args) {

        System.out.println(reverseBits2(43261596));
        System.out.println(Integer.reverse(43261596));


    }

}
