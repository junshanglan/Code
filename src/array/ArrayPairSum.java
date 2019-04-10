package array;
/**
 *561 数组拆分I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 */

public class ArrayPairSum {

    public static int arrayPairSum(int[] nums){
        int i,j,temp;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                temp =nums[i];
                for (j = i-1; j >= 0 && temp <nums[j] ; j--) {
                    nums[j+1] = nums[j];
                }
                nums[j+1] =temp;
            }
        }

        int sum = 0;
        for (int k = 0; k < nums.length; k+=2) {
            sum += nums[k];
        }
        return sum;
    }
}
