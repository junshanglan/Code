package OD.T_2025.A.one.模拟;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            String tmp = list.get(i);
            while (tmp.length() > 0) {
                if (!list.contains(tmp)) {
                    break;
                }
                tmp = tmp.substring(0,tmp.length() - 1);
            }
            if (tmp.length() == 0) {
                res = list.get(i);
                break;
            }
        }
        System.out.println(res);
    }


}
