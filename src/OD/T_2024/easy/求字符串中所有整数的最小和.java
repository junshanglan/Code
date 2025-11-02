package OD.T_2024.easy;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-17
 * @Author：landaguo
 */
public class 求字符串中所有整数的最小和 {

    /**
     * bb1234aa
     * 答案 : 10
     * bb12-34aa
     * 答案: -31
     *
     * 补充用例： bb12-34a-a-11
     * 1、结果要用大数进行处理
     * 2、要消化每次负数，再循环中就要处理掉
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        boolean isNegative = false;
        StringBuilder negative = new StringBuilder();
        BigInteger ans = new BigInteger("0");

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 区分数字和非数字的情况
            if (c >= '0' && c <= '9') {
                if (isNegative) {
                    negative.append(c);
                }else{
                    ans = ans.add(new BigInteger(c + ""));
                }
            }else{
                // 区分字母和负号的情况
                if (isNegative && negative.length() > 0) {
                    ans = ans.subtract(new BigInteger(negative.toString()));
                    negative = new StringBuilder();
                }
                isNegative = c == '-';
            }
        }
        if (negative.length() > 0){
            ans = ans.subtract(new BigInteger(negative.toString()));
        }
        System.out.println(ans);
    }
}
