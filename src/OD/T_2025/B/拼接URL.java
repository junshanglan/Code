package OD.T_2025.B;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2025-07-09
 * @Author：landaguo
 */
public class 拼接URL {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split(",");
        if (split.length != 2) {
            System.out.println("/");
            return;
        }
        String prefix = split[0];
        String suffix = split[1];
        if (!prefix.endsWith("/")){
            prefix  += "/";
        }
        if (suffix.startsWith("/")){
            suffix = suffix.substring(1);
        }
        System.out.println(prefix + suffix);
    }
}
