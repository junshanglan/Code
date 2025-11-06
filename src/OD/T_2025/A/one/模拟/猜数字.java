package OD.T_2025.A.one.模拟;

import java.util.Scanner;

/**
 * 数据量小，枚举所有值进行匹配
 *
 * 6
 * 4815 1A1B
 * 5716 0A1B
 * 7842 0A1B
 * 4901 0A0B
 * 8585 3A0B
 * 8555 2A1B
 */
public class 猜数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 输入
        String[][] ans = new String[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = scanner.next();
            ans[i][1] = scanner.next();
        }
        int matchCount = 0;
        String result = "";
        for (int i = 0; i < 10000; i++) {
            String answer = String.format("%04d",i);


            boolean isMatch = true;
            for (String[] pair : ans) {
                String input = pair[0];
                String guess = pair[1];

                int countA = 0;
                int countB = 0;
                int[] v1 = new int[10];
                int[] v2 = new int[10];
                for (int j = 0; j < answer.length(); j++) {
                    int c1 = answer.charAt(j) - '0';
                    int c2 = input.charAt(j) - '0';
                    if (c1 == c2){
                        countA++;
                    }else{
                        v1[c1]++;
                        v2[c2]++;
                    }
                }
                for (int j = 0; j < 10; j++) {
                    countB += Math.min(v1[j],v2[j]);
                }
                if (!guess.equals(countA + "A" + countB + "B")) {
                    isMatch = false;
                    break;
                }
            }
            // 一组比较之后
            if (isMatch) {
                matchCount++;
                result = answer;
                if (matchCount > 1){
                    System.out.println("NA");
                    return;
                }
            }
        }
        System.out.println(matchCount == 1 ? result : "NA");
    }
}
