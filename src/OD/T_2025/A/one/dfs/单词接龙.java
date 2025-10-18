package OD.T_2025.A.one.dfs;

import java.util.*;

/**
 * 0
 * 6
 * word
 * dd
 * da
 * dc
 * dword
 * d
 * 输出： worddwordda
 *
 */
public class 单词接龙 {

    static  class CustomComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startIdx = scanner.nextInt();
        int n = scanner.nextInt();
        Map<Character, List<String>> data = new HashMap<>();
        String currStr = "";
        for (int i = 0; i < n; i++) {
            String tmp = scanner.next();
            if (i != startIdx) {
                data.putIfAbsent(tmp.charAt(0), new ArrayList<>());
                data.get(tmp.charAt(0)).add(tmp);
            }else{
                currStr = tmp;
            }
        }
        // 接龙
        char endChar = currStr.charAt(currStr.length() - 1);
        String res = currStr;
        while(!currStr.isEmpty()) {
            if (data.get(endChar) != null) {
                data.get(endChar).sort((a,b) -> {
                    if (a.length() != b.length()) {
                        return b.length() - a.length();
                    }
                    return a.compareTo(b);
                });
                res += data.get(endChar).get(0);
                currStr = data.get(endChar).get(0);
                data.get(endChar).remove(0);
                endChar = currStr.charAt(currStr.length() - 1);
            }else{
                currStr = "";
            }
        }
        System.out.println(res);

    }


}
