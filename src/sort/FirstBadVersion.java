package sort;

public class FirstBadVersion {

    boolean[] table;

    public void setTable(int len, int n) {
        table = new boolean[len + 1];
        for (int i = 1; i < n; i++) {
            table[i] = false;
        }
        for (int i = n; i < len + 1; i++) {
            table[i] = true;
        }
    }

    public boolean isBadVersion(int version) {
        return table[version];
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n, mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    public static void main(String[] args) {

        FirstBadVersion firstBadVersion = new FirstBadVersion();
        firstBadVersion.setTable(9,4);
        System.out.println(firstBadVersion.firstBadVersion(9));

    }

}
