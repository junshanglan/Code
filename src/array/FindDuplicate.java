package array;

/**
 *287 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindDuplicate {

    public static void main(String[] args) {
        //[1,3,4,2,2]
        int[] nums = {1,3,4,2,2};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }

    public static int findDuplicate(int[] nums) {
        /*for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }*/

        /*Arrays.sort(nums);
        int i = 0,j = nums.length-1;
        while (i < j) {
            if (nums[i] == nums[i+1]) {
                return nums[i];
            }else
                i++;
            if (nums[j] == nums[j-1]) {
                return nums[j];
            }else
                j--;
        }
        return -1;*/
        int low = 1,high = nums.length-1;
        while (low < high) {
            int mid = (low + high)/2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <=  mid)
                    count++;
            }
            if (count <= mid)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
