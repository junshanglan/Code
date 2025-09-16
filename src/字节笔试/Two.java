package 字节笔试;

import java.util.Scanner;
import java.util.Stack;

/**
 * 2. 识别有效括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 3. 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 */
public class Two {

    //
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();
        if (charArray.length == 0){
            System.out.println(false);
            return;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (stack.empty()) {
                stack.add(charArray[i]);
                continue;
            }
            // 如果匹配则出栈，不匹配则入栈
            if (match(stack.peek(),charArray[i])){
                stack.pop();
            }else{
                stack.add(charArray[i]);
            }
        }
        if (stack.size() == 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    // 匹配规则
    private static boolean match(Character sourceChar,Character targetChar){
        if (sourceChar == '(' && targetChar == ')') {
            return true;
        }else if(sourceChar == '[' && targetChar == ']'){
            return true;
        }else if(sourceChar == '{' && targetChar == '}'){
            return true;
        }
        return false;
    }
}
