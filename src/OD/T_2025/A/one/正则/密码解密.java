package OD.T_2025.A.one.正则;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 密码解密 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 26; i >= 1; i--) {
            String regexStr = Integer.toString(i);
            if (i > 9) {
                regexStr += "\\*";
            }
            Pattern compile = Pattern.compile(regexStr);
            // 需要替换的字符
            String replaceChar = String.valueOf((char) ('a' + i - 1));
            Matcher matcher = compile.matcher(input);
            input = matcher.replaceAll(replaceChar);
        }
        System.out.println(input);
    }
}
