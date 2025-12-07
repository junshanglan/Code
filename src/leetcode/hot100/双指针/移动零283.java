package leetcode.hot100.双指针;

import java.util.Arrays;

public class 移动零283 {
    public static void moveZeroes(int[] nums) {
        int left = 0,right = 0,n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                swap(left,right,nums);
                left++;
            }
            right++;
        }
    }

    public static void swap(int left,int right,int[] nums) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

    public static void main(String[] args) {
        int[]  tmp = {0,1,0,3,12};
        moveZeroes(tmp);
        System.out.println(Arrays.toString(tmp));
    }

    // 暴力迭代
//    public static void moveZeroes(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0){
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] != 0) {
//                        int tmp = nums[j];
//                        nums[j]= nums[i];
//                        nums[i]= tmp;
//                        break;
//                    }
//                }
//            }
//        }
//    }
}
