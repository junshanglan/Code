package OD.T_2025.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 国际移动用户识别码 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] settings = scanner.nextLine().split(",");
        String str = scanner.nextLine();
        List<String> res = new ArrayList<>();
        for (String setting : settings) {
            if (match(setting, str)){
                res.add(setting);
            }
        }
        if (res.isEmpty()){
            System.out.println("null");
        }else{
            Collections.sort(res);
            System.out.println(String.join(",",res));
        }
    }

    public static boolean match(String pattern,String str){
        // 如果字符为*，完全匹配
        if ("*".equals(pattern)) return true;
        int n = str.length();
        int m = pattern.length();
        for (int i = 0; i < pattern.length(); i++) {
            // 相等匹配
            if (pattern.charAt(i) == str.charAt(i)) {
                continue;
            } else if (pattern.charAt(i) == '?') {
                // 问号匹配的是奇数位
                if (i % 2 != 0) {
                    return false;
                }
            } else if (pattern.charAt(i) == '*'){
                // 判断后缀是否匹配
                String suffix = pattern.substring(i+1);
                int pos = suffix.length() - 1;
                for (; pos > 0; pos--,n--) {
                    if (suffix.charAt(pos) == '?') {
                        if (n % 2 != 0){
                            break;
                        }
                    }
                    if (suffix.charAt(pos) != str.charAt(n)) {
                        break;
                    }
                }
                return pos < 0;
            }else {
                return false;
            }
        }
        return m == n;
    }
}
