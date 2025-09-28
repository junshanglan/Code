package OD.T_2025.B.双指针;

import java.util.Scanner;

/**
 * 直接遍历字符串判定，区别于双指针法
 */
public class 字符串序列判定2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String l = scanner.nextLine();
        if (s.length() == 0) {
            System.out.println(-1);
            return ;
        }
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (l.indexOf(c) != -1) {
                result = l.indexOf(c);
                continue;
            }
            break;
        }
        System.out.println(result);
    }
}
