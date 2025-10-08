package 算法.array;

import java.util.Arrays;

/**
 *747. 至少是其他数字两倍的最大数
 *
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 */
public class DominantIndex {

    public static void main(String[] args) {
        // 30,20,150,100,40
        // 3, 6, 1, 0   1,2,3,4
        int[] nums = {1,2,3,4};
        int i = dominantIndex(nums);
        System.out.println(i);
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length <2) {
            return nums.length == 0?-1:0;
        }
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        int result = -1;
        int len = numsCopy.length;
        boolean flag = numsCopy[len - 1] >=numsCopy[len -2]*2 ?true:false;
        if (flag) {
            int target = numsCopy[len - 1];
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
}
