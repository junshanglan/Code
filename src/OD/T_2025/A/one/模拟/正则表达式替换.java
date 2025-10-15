package OD.T_2025.A.one.模拟;

import java.util.Scanner;

public class 正则表达式替换 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String replaceStr = "(^|$|[,+])";
        StringBuilder sb = new StringBuilder();
        int bracketCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '[') {
                bracketCount++;
                sb.append(c);
            }else if (c == ']') {
                bracketCount--;
                sb.append(c);
            }else if (c == '_' && (i != 0 && input.charAt(i - 1) !='\\' && bracketCount == 0)){
                sb.append(replaceStr);
            }else{
                sb.append(c);
            }
        }
        System.out.println(sb);

    }
}
