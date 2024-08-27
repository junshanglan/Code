package OD.easy;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-07
 * @Author：landaguo
 */
public class 分割均衡字符串 {

    /**
     * XXYYXY
     * 2
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int countX = 0;
        int countY = 0;
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X'){
                countX++;
            }else{
                countY++;
            }
            if (countX == countY) {
                result++;
            }
        }
        System.out.println(result);
    }
}
