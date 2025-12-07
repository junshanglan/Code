package leetcode.hot100.哈希表;

import java.util.*;

public class 最长连续序列128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            // 当前数是连续序列中的最小数
            if (!set.contains(num - 1) ){
                int currentNum = num;
                int tmp = 1;
                while (set.contains(currentNum + 1)) {
                    tmp++;
                    currentNum++;
                }
                res = Math.max(res,tmp);
            }
        }
        return res;
    }

}
