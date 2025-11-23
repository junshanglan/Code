package leetcode.middle.滑动窗口;

import sun.reflect.annotation.AnnotationSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 重复的DNA序列 {

    /**
     * 暴力求解
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        int left = 0,right = 9;
        Map<String,Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        while (right < s.length()) {
            String tmp = s.substring(left, right + 1);
            map.put(tmp,map.getOrDefault(tmp,0) + 1);
            if (map.get(tmp) == 2) {
                ans.add(tmp);
            }
            left++;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String substring = "0123456789a".substring(0, 9);
        System.out.println(substring);
    }
}
