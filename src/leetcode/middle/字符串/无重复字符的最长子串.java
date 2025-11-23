package leetcode.middle.字符串;

import java.util.HashSet;

public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0,right = 0;
        HashSet<Character> set = new HashSet();
        int res = 1;
        for (; left < s.length(); left++) {
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right < s.length() && !set.contains(s.charAt(right)) ) {
                set.add(s.charAt(right));
                right++;
            }
            res = Math.max(res,right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }
}
