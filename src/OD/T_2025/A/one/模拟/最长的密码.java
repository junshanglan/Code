package OD.T_2025.A.one.模拟;

import java.util.*;

/**
 * 可以进行剪枝操作
 */
public class 最长的密码 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.asList(scanner.nextLine().split(" "));

        list.sort((a,b) -> {
            if (a.length() == b.length()) {
                return b.compareTo(a);
            }
            return b.length() - a.length();
        });
        if (list.get(list.size() - 1).length() != 1) {
            System.out.println("");
            return;
        }

        Set<String> setStr = new HashSet<>();
        Map<String,Boolean> mp = new HashMap<>();
        for (String s : list) {
            setStr.add(s);
            mp.put(s,false);
        }
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            String tmp = list.get(i);
            if (mp.get(tmp) == true) {
                continue;
            }
            while (tmp.length() > 0) {
                tmp = tmp.substring(0,tmp.length() - 1);
                if (!setStr.contains(tmp)) {
                    break;
                }
                if (mp.get(tmp)) break;
                mp.put(tmp,true);
            }
            if (tmp.length() == 0) {
                res = list.get(i);
                break;
            }
        }
        System.out.println(res);
    }


}
