package OD.T_2024.easy;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-15
 * @Author：landaguo
 */
public class 找座位 {

    /**
     * 10001
     *
     * 0101
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                boolean isLeftEmpty = (i == 0 || chars[i - 1] == '0');
                boolean isRightEmpty = (i == chars.length -1 || chars[i + 1] == '0');

                if (isLeftEmpty && isRightEmpty) {
                    ans++;
                    chars[i] = '1';
                }
            }
        }
        System.out.println(ans);
    }
}
