package array;


import java.util.Arrays;

/**
 *628. 三个数的最大乘积
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 */
public class MaximumProduct {

    public static void main(String[] args) {
        // nums = [0,0,1,1,1,2,2,3,3,4],
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = maximumProduct(nums);
        System.out.println(i);
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int arrLen = nums.length;
        int first = nums[arrLen-1];
        int second = 0;
        if (nums[0] * nums[1] > nums[arrLen-2] * nums[arrLen-3]){
            second = nums[0] * nums[1];
        }else {
            second = nums[arrLen-2] * nums[arrLen-3];
        }
        return first * second;
    }
}
