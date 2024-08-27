package OD.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-07
 * @Author：landaguo
 */
public class 小明找位置 {

    /**
     * 93,95,97,100,102,123,155
     * 110
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = scanner.nextInt();
        int idx = Arrays.binarySearch(data, target);

        if (idx < 0) {
            idx = -idx - 1;
        }
        System.out.println(idx + 1);
    }

}
