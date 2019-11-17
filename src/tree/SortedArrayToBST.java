package tree;


import java.util.Arrays;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {

        return dfs(nums, 0, nums.length - 1);

    }

    public TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);

        return root;

    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = new SortedArrayToBST().sortedArrayToBST(nums);
        System.out.println(root.val);

        int max_value = Integer.MAX_VALUE;
        System.out.println(max_value);

        int b = 1234;
        int c = b + (max_value - b) / 2;
        int d = (max_value + b) >>> 1;
        int e = (max_value + b) >> 1;
        System.out.println(c);
        System.out.println(d);


    }
}
