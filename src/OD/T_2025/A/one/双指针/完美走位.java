package OD.T_2025.A.one.双指针;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 完美走位 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = input.length();
        if (n % 4 != 0) {
            System.out.println(-1);
            return;
        }
        int avg = n / 4;

        Map<Character,Integer> cntMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {char c = input.charAt(i);
            cntMap.put(c,cntMap.getOrDefault(c,0) + 1);
        }
        Map<Character,Integer> targetMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() > avg) {
                targetMap.put(entry.getKey(),entry.getValue() - avg);
            }
        }
        if (targetMap.isEmpty()) {
            System.out.println(0);
            return;
        }
        int left = 0,right = 0;
        int minValue = Integer.MAX_VALUE;
        while (right < n) {
            if (meetContain(targetMap,left,right,input)) {
                minValue = Math.min(minValue,right - left + 1);
                left++;
            }else{
                right++;
            }
        }
        System.out.println(minValue);
    }
    private static boolean meetContain(Map<Character,Integer> targetMap,int left,int right,String input){
        Map<Character,Integer> tmpMap = new HashMap<>();
        for (int i = left; i <= right; i++) {
            char c = input.charAt(i);
            tmpMap.put(c,tmpMap.getOrDefault(c,0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            Character key = entry.getKey();
            if (tmpMap.get(key) == null) {
                return false;
            }
            if (tmpMap.get(key) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
