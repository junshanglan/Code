package test;

import java.util.*;
/**
 * @Description：
 * @Date：2024-05-09
 * @Author：landaguo
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = Arrays.copyOf(data,data.length);
        int i = 0;
        int j = 1;
        while (i != j) {
            if (j == data.length - 1) {
                j = 0;
            }
            if (data[j] < data[i]) {
                result[i] += result[j];
                i++;
            }else{
                j++;
            }
        }

    }
}

