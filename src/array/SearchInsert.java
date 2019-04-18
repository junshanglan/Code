package array;

/**
 *35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class SearchInsert {

    public static void main(String[] args) {
        // [1,3,5,6], 5
        int[] nums = {1,3,5,6,7,9,33,66,88};
        int target = 22;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length-1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int middle = (low + high)/2;
            if (target > nums[middle]) {
                low = middle + 1;
            }else if(target < nums[middle]) {
                high = middle - 1;
            }else {
                return middle;
            }
        }
        return low;
    }
}
