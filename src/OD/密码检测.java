package OD;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 密码输入检测
 */
public class 密码检测 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '<') {
                stack.add(input.charAt(i));
            }else{
                stack.removeLast();
            }
        }

        int upper = 0;
        int lower = 0;
        int digit = 0;
        int is_special_letter = 0;
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) > 'a' && stack.get(i) < 'z') {
                lower++;
            }else if (stack.get(i) > 'A' && stack.get(i) < 'Z') {
                upper++;
            }else if (stack.get(i) > '0' && stack.get(i) < '9') {
                digit++;
            }else{
                is_special_letter++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        sb.append(",");
        // 密码的长度大于8
        if (sb.length() > 8 &&upper > 0 && lower > 0 && digit > 0 && is_special_letter > 0) {
            sb.append("true");
        }else{
            sb.append("false");
        }

        System.out.println(sb.toString());

    }

}
