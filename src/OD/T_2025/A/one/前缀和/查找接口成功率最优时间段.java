package OD.T_2025.A.one.前缀和;

import java.util.*;

public class 查找接口成功率最优时间段 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minAvgLost = Integer.parseInt(scanner.nextLine());
        int[] ans = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int len = ans.length;
        if (len == 0) {
            System.out.println("NULL");
            return;
        }
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + ans[i-1];
        }
        int currentLen = 0;
        Map<Integer, List<String>> resMap = new HashMap<>();
        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (j - i < currentLen) {
                    continue;
                }
                int sum = (prefixSum[j] -prefixSum[i]) ;
                if((double)sum / (j - i) <= minAvgLost ) {
                    currentLen = Math.max(currentLen,j - i) ;
                    resMap.putIfAbsent(currentLen,new ArrayList<>());
                    resMap.get(currentLen).add(i + "-" + (j - 1));
                }
            }
        }
        List<String> list = resMap.get(currentLen);
        Collections.sort(list);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
