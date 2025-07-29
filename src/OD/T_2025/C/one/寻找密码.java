package OD.T_2025.C.one;

import java.util.*;

/**
 * 使用剪枝思想减少复杂度
 * 不用剪枝可能复杂度会溢出
 */
public class 寻找密码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.asList(scanner.nextLine().split(" "));
        Collections.sort(list, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        Map<String,Boolean> mp = new HashMap<>();
        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            strSet.add(list.get(i));
            mp.put(list.get(i),false);
        }
        if (list.get(0).equals("")) {
            System.out.println("");
            return;
        }

        String res = "";
        for (int i = list.size() - 1; i >= 0 ; i--) {
            String tmp = list.get(i);
            // 剪枝,此前缀无法匹配到1位字符
            if (mp.get(tmp)) {
                continue;
            }
            while (!tmp.isEmpty()) {
                tmp = tmp.substring(0,tmp.length()-1);
                if (!strSet.contains(tmp)) break;
                if (mp.get(tmp)) break;
                mp.put(tmp,true);
            }
            if (tmp.isEmpty()) {
                res = list.get(i);
                break;
            }
        }
        System.out.println(res);
    }
}
