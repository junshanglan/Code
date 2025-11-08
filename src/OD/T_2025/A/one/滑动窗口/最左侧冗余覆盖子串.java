package OD.T_2025.A.one.滑动窗口;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * abc
 * aababbcd
 * 2
 *
 */
public class 最左侧冗余覆盖子串 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String target = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        int len = source.length() + k;
        if (target.length() < len) {
            System.out.println(-1);
            return;
        }
        Map<Character,Integer> sourceMap = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            sourceMap.put(c,sourceMap.getOrDefault(c,0) + 1);
        }

        int left = 0;
        int right = source.length() + k - 1;
        while (right < target.length()) {
            Map<Character,Integer> targetMap = new HashMap<>();
            for (int i = left; i <= right; i++) {
                char c = target.charAt(i);
                targetMap.put(c,targetMap.getOrDefault(c,0) + 1);
            }
            if (compareChar(sourceMap,targetMap)) {
                System.out.println(left);
                return;
            }else{
                right++;
                left++;
            }
        }
        System.out.println(-1);

    }

    private static boolean compareChar(Map<Character,Integer> sourceMap,Map<Character,Integer> targetMap) {
        // 对比是否包含所有字母，且字母个数是大于等于
        Set<Character> characters = targetMap.keySet();
        for (Map.Entry<Character, Integer> entry : sourceMap.entrySet()) {
            Character key = entry.getKey();
            if (!characters.contains(key)) {
                return false;
            }else{
                if (targetMap.get(key) < entry.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
