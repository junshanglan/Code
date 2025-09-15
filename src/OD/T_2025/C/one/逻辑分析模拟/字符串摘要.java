package OD.T_2025.C.one.逻辑分析模拟;

import java.util.*;

/**
 * new AbstractMap.SimpleEntry<>
 */
public class 字符串摘要 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        StringBuilder sb = new StringBuilder();
        input.chars().filter(e -> Character.isLetter(e)).forEach(e -> sb.append((char)e));
        List<Map.Entry<Character,Integer>> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == sb.length() - 1) {
                list.add(new AbstractMap.SimpleEntry<>(sb.charAt(i),0));
                continue;
            }
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                char key = sb.charAt(i);
                Map<Character, Integer> continueMap = new HashMap<>();
                 i = calContinueChar(sb,i,continueMap);
                list.add(new AbstractMap.SimpleEntry<>(key,continueMap.get(key)));
            }else{
                Map<Character, Integer> cntMap = new HashMap<>();
                int count = calLetter(sb, sb.charAt(i), i + 1);
                cntMap.put(sb.charAt(i), count);
                list.add(new AbstractMap.SimpleEntry<>(sb.charAt(i),cntMap.get(sb.charAt(i))));
            }
        }
        list.sort((a,b)->cmp(a,b));
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Character,Integer> entry : list) {
            res.append(entry.getKey()).append(entry.getValue());
        }
        System.out.println(res);
    }

    public static int calContinueChar(StringBuilder sb,int index,Map<Character, Integer> continueMap){
        continueMap.put(sb.charAt(index),1);
        for (; index < sb.length() - 1; index++) {
            if (sb.charAt(index) == sb.charAt(index + 1)) {
                continueMap.put(sb.charAt(index),continueMap.get(sb.charAt(index)) + 1);
                continue;
            }
            break;
        }
        return index;
    }
    public static int calLetter(StringBuilder sb,Character c,int index){
        int count = 0;
        for (; index < sb.length(); index++) {
            if (sb.charAt( index) == c) count++;
        }
        return count;
    }

    public static int cmp(Map.Entry<Character,Integer> a,Map.Entry<Character,Integer> b){
        if (!a.getValue().equals(b.getValue())) {
            return b.getValue().compareTo(a.getValue());
        }
        return a.getKey().compareTo(b.getKey());
    }
}






