package 算法.array;

/**
 * 169. 求众数
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    public static void main(String[] args) {
        //{1,2,3,4,5,5,5}
        int[] nums = {3,3,4};
        System.out.println(majorityElement(nums));

    }

    public static int majorityElement(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            int count = 1;
            for (int j = i+1; j < nums.length; j++) {
                if (temp == nums[j])
                    count++;
            }
            if (count > nums.length/2)
                break;
        }
        return temp;
    }
}
