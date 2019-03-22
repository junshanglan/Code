package array;

import java.util.Arrays;

/**
 * @author landaguo
 * @Title: MissingNumber
 * @Package array
 * @Description: aa
 * @create: 2019-03-22 15:39
 * @Copyrigth 版权所有 (C) 广州如约数据科技有限公司.
 */
public class MissingNumber {

    public static void main(String[] args) {
        // [9,6,4,2,3,5,7,0,1]
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int i = missingNumber(nums);
        System.out.println(i);
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != result) {
                return result;
            }
            result++;
        }
        return result;
    }
}
