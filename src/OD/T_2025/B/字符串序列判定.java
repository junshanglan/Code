package OD.T_2025.B;

import java.util.Scanner;

/**
 * 双指针法求解
 */
public class 字符串序列判定 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String l = scanner.nextLine();
        int pos1 = 0,pos2 = 0;

        while (pos1 <s.length() && pos2 < l.length()){
            if (s.charAt(pos1) == l.charAt(pos2)) {
                //如果匹配到最后一个字符，pos1 = s.length
                pos1++;
                pos2++;
            }else{
                pos2++;
            }
        }
        if (pos1 != s.length() ) {
            System.out.println(-1);
        }else{
            System.out.println(pos2-1);
        }


    }
}
