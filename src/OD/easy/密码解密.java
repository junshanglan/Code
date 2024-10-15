package OD.easy;

import java.util.Scanner;

public class 密码解密 {

    /**
     * 20*19*20*
     * 189
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char target = 'z';
        for (int i = 26; i >=1 ; i--) {
            String key = i > 9 ? i + "\\*" : i +"";
            input = input.replaceAll(key,target +"");
            target--;
        }
        System.out.println(input);
    }
}
