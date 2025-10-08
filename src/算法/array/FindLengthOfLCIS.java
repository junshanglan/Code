package 算法.array;


/**
 *674. 最长连续递增序列
 *
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 */
public class FindLengthOfLCIS {

    public static void main(String[] args) {
        // [1,3,5,4,7]
        // 2,2,2,2,2,2
        int[] nums = {1,3,5,7};
        int lengthOfLCIS = findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxLen = Integer.MIN_VALUE;
        int i = 0,j = 1;
        int count = 1;
        while (j < nums.length) {
            if (nums[i] < nums[j]) {
                count++;
                i++;
                j++;
            }else {
                if (maxLen < count) {
                    maxLen = count;
                }
                count = 1;
                i++;
                j++;
            }
        }
        if (maxLen < count) {
            maxLen = count;
        }
        return maxLen;
    }
}
