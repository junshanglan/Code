package leetcode.hot100.哈希表;

import java.util.*;

public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num - 1)){

            }
        }
    }
}
