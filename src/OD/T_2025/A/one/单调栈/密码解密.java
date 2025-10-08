package OD.T_2025.A.one.单调栈;

import java.util.Scanner;
import java.util.Stack;

/**
 * 20*19*20*
 * 输出：tst
 *
 * 25*21*1*14*11*1*14*7*21*1*14*7*
 * 输出：
 */
public class 密码解密 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ('*' == c) {
                res.append(map((stack)));
                continue;
            }
            if (Character.isDigit(c)){
                stack.push(c);
            }
        }
        System.out.println(res);
    }

    public static String map(Stack<Character> stack){
        StringBuilder sb  = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        if (sb.length() != 0){
            return String.valueOf((char)('a' + Integer.parseInt(sb.toString()) - 1));
        }
        return "";
    }
}
