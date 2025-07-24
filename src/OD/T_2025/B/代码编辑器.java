package OD.T_2025.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2025-05-27
 * @Author：landaguo
 */
public class 代码编辑器 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cmdCnt = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        List<String> cmdList = new ArrayList<>();
        for (int i = 0; i < cmdCnt; i++) {
            cmdList.add(scanner.nextLine());
        }
        StringBuilder sb = new StringBuilder(input);
        int index = 0;
        for (int i = 0; i < cmdList.size(); i++) {
            String[] tmp = cmdList.get(i).split(" ");
            String cmd = tmp[0];
            String operator = tmp[1];
            switch (cmd) {
                case "FORWARD":
                    index = Math.min(index + Integer.parseInt(operator),sb.length());
                    break;
                case "BACKWARD":
                    index = Math.max(index - Integer.parseInt(operator),0);
                    break;
                case "SEARCH-FORWARD":
                    // 向后
                    int pos = sb.indexOf(operator,index);
                    if (pos != -1) {
                        index = pos;
                    }
                    break;
                case "SEARCH-BACKWARD":
                    int pos1 = sb.lastIndexOf(operator, index);
                    if (pos1 != -1) {
                        index = pos1;
                    }
                    break;
                case "INSERT":
                    sb.insert(index,operator);
                    break;
                case "REPLACE":
                    int end = Math.min(index + operator.length(), sb.length());
                    sb.replace(index,end,operator);
                    break;
                case "DELETE":
//                    int min = Math.min(index + Integer.parseInt(operator), sb.length());
//                    sb.delete(index,min);

                    int delLen = Integer.parseInt(operator);
                    if(index < sb.length()) {
                        int toDelete = Math.min(delLen, sb.length() - index);
                        sb.delete(index, index + toDelete);
                    }
                    break;

            }
        }
        System.out.println(sb);
    }


}
