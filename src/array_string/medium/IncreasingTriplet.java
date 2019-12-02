package array_string.medium;

/**
 * @auther alery
 * @create 2019-12-01 14:08
 */
public class IncreasingTriplet {


    public boolean increasingTriplet(int[] nums) {

        int min, medium, max;
        min = medium = max = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= medium) {
                medium = nums[i];
            } else if (nums[i] <= max) {
                max = nums[i];
            }
        }
        if (min == Integer.MAX_VALUE || medium == Integer.MAX_VALUE || max == Integer.MAX_VALUE) {
            return false;
        }
        return min < medium && medium < max;
    }

    /**
     * 这个更加简化,找到第一个比前两个数大的就可以返回true
     * 原理和tail数组是一样的，min就是tail[0], max就是tail[1],不能求出具体的三元子序列，
     * 若求三元子序列，记下第三个数位置，向左遍历
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        int l=nums.length;
        int min=Integer.MAX_VALUE, max=Integer.MAX_VALUE;
        for(int i=0;i<l;i++){
            if(nums[i]<=min)//最小
                min=nums[i];
            else if(nums[i]<=max)//第二小
                max=nums[i];
            else
                return true;

        }
        return false;
    }


    public static void main(String[] args) {

        int[] nums = {1, 3, 7, 2, 2, 9};
        System.out.println(new IncreasingTriplet().increasingTriplet(nums));


    }


}
