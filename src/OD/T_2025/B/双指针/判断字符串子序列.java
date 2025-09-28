package OD.T_2025.B.双指针;

import java.util.Scanner;

/**
 * 使用双指针法
 */
public class 判断字符串子序列 {
    /**
     * abc
     * abcaybec
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        String source = scanner.nextLine();

        int t = target.length() - 1;
        int s = source.length() - 1;
        while (t >= 0 && s >= 0) {
            if(target.charAt(t) == source.charAt(s)) {
                t--;
            }
            s--;
        }

        if (s < 0) {
            System.out.println(-1);
        }else{
            System.out.println(s + 1);
        }
    }
}
