package leetcode.hot100.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词438 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(),pLen = p.length();
        if (sLen < pLen) {
            return ans;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount,pCount)){
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }

    // 时间复杂度高
//    public static List<Integer> findAnagrams(String s, String p) {
//        List<Integer> ans = new ArrayList<>();
//        int dis = p.length();
//        char[] charArray = p.toCharArray();
//        Arrays.sort(charArray);
//        int left = 0,right = left + dis;
//        while (right <= s.length()) {
//            String substring = s.substring(left, right);
//            char[] charArray1 = substring.toCharArray();
//            Arrays.sort(charArray1);
//            if (Arrays.equals(charArray,charArray1)) ans.add(left);
//            left++;
//            right = left + dis;
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
