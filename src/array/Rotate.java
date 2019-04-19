package array;

/**
 *189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class Rotate {
    public static void main(String[] args) {
        // 1,2,3,4,5,6,7
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int k = 3;
        //rotate(nums,k);
        System.out.println(nums.length);
    }
    // TODO
    /*public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[i];
            int j = i + k;
            //while ()
            for (int j = 0; j < nums.length; j++) {

            }
        }
    }*/
}

