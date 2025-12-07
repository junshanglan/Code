package leetcode.hot100.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int target = -nums[first];
            int left = first + 1,right = nums.length - 1;
            while (left < right) {
                int sum  = nums[left] + nums[right];
                if (sum == target) {
                    ans.add(Arrays.asList(nums[first],nums[left],nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }else if (sum > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] tmp = {0,0,0};
        List<List<Integer>> lists = threeSum(tmp);
        System.out.println(lists);
    }
}
