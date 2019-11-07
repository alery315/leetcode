package sort;

public class FirstBadVersion {

    int[] table = new int[]{
            0, 0, 0, 0, 0
    };

    public int k;
    public boolean flag = false;

    // 栈溢出
    public int firstBadVersion(int n) {
        binarySearch(0, n - 1);
        return k;
    }

    public void binarySearch(int i, int j) {
        if (flag) {
            return;
        }
        if (i <= j) {
            if (table[i] == 1) {
                k = i;
                flag = true;
            }
            if (table[j] == 1) {
                k = j;
                flag = true;
            }
        } else {
            return;
        }
//        System.out.println(i + ":" + j);
        binarySearch(i + 1, j / 2);
        binarySearch(j / 2 + 1, j - 1);
    }

    public void setTable(int n) {
        for (int i = 0; i < n; i++) {
            table[i] = 0;
        }
        for (int i = n; i < table.length; i++) {
            table[i] = 1;
        }
    }

    public int firstBadVersion2(int n) {
        int left = 0, right = n - 1, mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (table[left] == 0 && table[mid] == 1) {
                right = mid;
                if (left + 1 == mid) return mid;
            } else if (table[mid] == 0 && table[right] == 1) {
                left = mid;
                if (mid + 1 == right) return right;
            }
        }

        return k;
    }


    public static void main(String[] args) {

        FirstBadVersion firstBadVersion = new FirstBadVersion();
        firstBadVersion.setTable(4);
        System.out.println(firstBadVersion.firstBadVersion2(5));

    }

}
