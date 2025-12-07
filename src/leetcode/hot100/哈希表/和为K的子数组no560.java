package leetcode.hot100.哈希表;

public class 和为K的子数组no560 {

    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]  tmp = {1,1,1};
        int k = 2;
        subarraySum(tmp,k);
    }
}
