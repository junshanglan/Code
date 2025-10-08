package 算法.array;

/**
 *53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        // 输入: [-2,1,-3,4,-1,2,1,-5,4],
        // 输出: 6
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);

    }


    // TODO
    /*public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;

    }*/

    public static int maxSubArray(int[] nums) {
        int current=nums[0];
        int sum=nums[0];
        //我们考虑如果全是负数，那么返回最大的负数，如果最后的和为正，那么就使用扫描法
        for(int i=1;i<nums.length;i++) {
            if(current<0)
                current=nums[i]; //当前数小于0 肯定会舍去（否则将会影响接下来的和），换为下一个数
            else
                current+=nums[i]; //如果当前数不小于0，那么他会对接下来的和有积极影响

            if(current>sum)
                sum=current; //这里既实现了负数返回最大也实现了扫描法
            //这里其实已经隐式的列举了所有可能，保留了所有可能的最大值
        }
        return sum;
    }

}
