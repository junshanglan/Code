package OD.T_2024.easy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Description:
 * @Author: landaguo
 * @CreateDate: 2024/5/1 11:18
 */
public class 转盘寿司 {
    /**
     * 3 15 6 14
     * 3 21 9 17
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = Arrays.copyOf(input,input.length);
        for (int i = 0; i < input.length; i++) {
            for (int j = i+1; j <= input.length;j++) {
                if (j >= input.length) {
                    j = 0;
                }
                if (i == j) {
                    break;
                }
                if (input[j] < input[i]) {
                    result[i] = input[i] + input[j];
                    break;
                }
            }
        }
        StringJoiner output = new StringJoiner(" ");
        for (int i = 0; i < result.length; i++) {
            output.add(result[i] + "");
        }
        System.out.println(output);

    }
}
