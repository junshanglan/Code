package OD.T_2024.easy;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-04-29
 * @Author：landaguo
 */
public class 最长子字符串的长度 {

    /**
     * alolobo
     * 6
     *
     * looxdolx
     *7
     *
     * bcbcbc
     * 6
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int oNum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'o') {
                oNum++;
            }
        }
        if (oNum % 2 == 0) {
            System.out.println(input.length());
        }else{
            System.out.println(input.length() - 1);
        }
    }
}
