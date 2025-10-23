package OD.T_2025.A.one.正则;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 相对开音节 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String regex = "^[a-z]+$";
        int res = 0;
        String match = "[b-df-hj-np-tv-z][aeiou][b-df-hj-np-qstv-z]e";
        for (int i = 0; i < input.length; i++) {
            String tmp = input[i];
            if (tmp.matches(regex)) {
                tmp = new StringBuilder(tmp).reverse().toString();
            }
            if (tmp.length() >= 4) {
                for (int j = 0; j <= tmp.length() - 4; j++) {
                    String substring = tmp.substring(j, j + 4);
                    if (substring.matches(match)) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
