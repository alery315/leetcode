package leetcode;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-25 14:50
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}
