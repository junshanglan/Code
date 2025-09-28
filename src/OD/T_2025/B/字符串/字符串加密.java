package OD.T_2025.B.字符串;

import java.util.Scanner;

public class 字符串加密 {
    public static void main(String[] args) {
        int[] ans = new int[50];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 4;
        ans[3] = 7;
        for (int i = 4; i < 50; i++) {
            // 英文字母就 26个，偏移量需要求余数
            ans[i] =(ans[i-1] + ans[i-2] + ans[i-3]) % 26;
        }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n-- > 0){
            String input = scanner.nextLine();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < input.length(); i++) {
                int diff = (input.charAt(i) - 'a' + ans[i] )% 26;
                char c = (char) ('a' + diff);
                sb.append(c);
            }
            System.out.println(sb);
        }


    }
}
