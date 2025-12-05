package leetcode.hot100.哈希表;

import java.util.*;
/**
 * 字符串排序啊
 */
public class 字母异位词分组no49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

    }
}
