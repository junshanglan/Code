package OD.T_2025.A.two.数学原理;

import java.util.Scanner;

public class 统计差异值大于相似值二元组个数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = scanner.nextInt();
        }
        int[] highPosNum = new int[50];
        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(inputArr[i]);
            int len = s.length();
            if ("0".equals(s)) {
                highPosNum[0]++;
            }else{
                highPosNum[len]++;
            }
        }
        long res = 0l;
        for (int i = 0; i < highPosNum.length; i++) {
            for (int j = i+1; j < highPosNum.length; j++) {
                res += 1l * highPosNum[i] * highPosNum[j];
            }
        }
        System.out.println(res);

    }
}
