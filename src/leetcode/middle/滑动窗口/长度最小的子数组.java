package leetcode.middle.滑动窗口;

public class 长度最小的子数组 {
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0,right = 0;
        int sum = nums[0];
        while (left <= right && right <nums.length) {
            if (sum >=target) {
                ans = Math.min(right - left + 1,ans);
                sum-= nums[left];
                left++;
            }else{
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            }
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }
}

