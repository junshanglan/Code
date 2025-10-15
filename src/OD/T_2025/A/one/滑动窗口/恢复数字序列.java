package OD.T_2025.A.one.滑动窗口;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 恢复数字序列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int num = scanner.nextInt();
        Map<Character,Integer> targetMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            targetMap.put(c,targetMap.getOrDefault(c,0) + 1);
        }
        int max = 1000 - num + 1;
        int  i = 0;
        for (; i <= max; i++) {
            Map<Character,Integer> windowMap = new HashMap<>();
            for (int j =  i; j < i + num; j++) {
                String s = String.valueOf(j);
                for (int k = 0; k < s.length(); k++) {
                    char c = s.charAt(k);
                    windowMap.put(c,windowMap.getOrDefault(c,0) + 1);
                }
            }
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if (!windowMap.containsKey(key) || windowMap.get(key) != value) {
                    flag = false;
                    break;
                }
            }
            if (flag && targetMap.size() == windowMap.size()) {
                System.out.println(i);
                return;
            }
        }

    }
}
