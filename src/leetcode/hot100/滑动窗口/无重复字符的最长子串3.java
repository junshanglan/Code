package leetcode.hot100.滑动窗口;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串3 {

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0,right = 0;
        Set<Character> set = new HashSet<>();
        while (left <= right && right < s.length()){
            while (right < s.length() && !set.contains(s.charAt(right)) ) {
                set.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans,set.size());
            set.remove(s.charAt(left));
            left++;

        }
        return ans;
    }

    public static void main(String[] args) {
        String abcabcbb = "dvdf";
        int i = lengthOfLongestSubstring(abcabcbb);
        System.out.println(i);
    }
}
