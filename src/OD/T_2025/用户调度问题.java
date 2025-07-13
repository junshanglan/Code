package OD.T_2025;

import java.util.Scanner;

/**
 * 不用考虑全局最优，只需要考虑局部最优即可
 * 不是使用动态规划求全局最优
 */
public class 用户调度问题 {

    private static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] res = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = scanner.nextInt();
            }
        }
        // 求当前用户最小系统消耗
        System.out.println(getResult(res));
    }

    private static int getResult(int[][] res){
        int sum = 0;
        int last = -1;

        for (int i = 0; i < n; i++) {
            last = getMinIdx(last, res[i]);
            sum += res[i][last];
        }
        return sum;
    }

    private static int getMinIdx(int excludeIdx,int arr[]) {
        int maxFlag = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i <  3; i++) {
            if (i == excludeIdx) continue;
            if (arr[i] < maxFlag){
                maxFlag = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}
