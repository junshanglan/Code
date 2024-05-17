package OD;

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
     * 10
     *
     * bb12-34aa
     * -31
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
            if (c >= '0' && c <= '9') {
                if (isNegative) {
                    negative.append(c);
                }else{
                    ans = ans.add(new BigInteger(c + ""));
                }
            }else{
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
