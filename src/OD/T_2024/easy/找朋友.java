package OD.T_2024.easy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Description：
 * @Date：2024-05-14
 * @Author：landaguo
 */
public class 找朋友 {
    /**
     *  8
     *  123 124 125 121 119 122 126 123
     *  1 2 6 5 5 6 0 0
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[n];
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] > input[i]) {
                    result[i] = j;
                    break;
                }
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < result.length; i++) {
            sj.add(result[i] + "");
        }
        System.out.println(sj);
    }
}
