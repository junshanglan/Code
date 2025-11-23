package leetcode.middle.字符串;

import java.util.HashSet;

public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0,right = 1;
        HashSet<Character> set = new HashSet();
        set.add(s.charAt(0));
        int res = 1;
        while (right < s.length()) {
            if (s.charAt(left) != s.charAt(right)){
                if (!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    res = Math.max(res,set.size());
                    right++;
                }else{
                    set.remove(s.charAt(left));
                    left++;
                }
            }else{
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("aabaab!bb");
        System.out.println(i);
    }
}
