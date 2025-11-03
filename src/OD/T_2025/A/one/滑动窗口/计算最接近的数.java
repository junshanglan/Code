package OD.T_2025.A.one.滑动窗口;

import java.util.Arrays;
import java.util.Scanner;

public class 计算最接近的数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.substring(1).split("],");
        int[] arr = Arrays.stream(split[0].split(",")).mapToInt(Integer::parseInt).toArray();
        int[] newArr = arr.clone();
        int n = newArr.length;
        Arrays.sort(newArr);
        int median = newArr[n / 2];
        int k = Integer.parseInt(split[1]);

        int res = -1;
        int idx = 0;
        int minDiff = Integer.MAX_VALUE;
        while (idx + k <= n) {
            int tmpDiff = arr[idx];
            for (int i = idx + 1; i < idx + k; i++) {
                tmpDiff -= arr[i];
            }
            int diff = Math.abs(median - tmpDiff);
            if (diff <= minDiff) {
                minDiff = diff;
                res = idx;
            }
            idx++;
        }
        System.out.println(res);
    }
}
