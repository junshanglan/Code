package OD.T_2025.A.one.滑动窗口;

import java.util.Scanner;

public class 字符串计数匹配 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        // 包含的字母数
        int k = scanner.nextInt();
        int n = data.length();
        if (n < k + 10) {
            System.out.println(0);
            return;
        }
        int res = 0;
        int left = 0;
        int charCount = 0;
        int numCount = 0;
        int[] numArr = new int[10];
        for (int right = 0; right < n; right++) {
            char cur = data.charAt(right);
            if (Character.isLetter(cur)) {
                charCount++;
            }
            if (Character.isDigit(cur)) {
                int idx = cur - '0';
                numArr[idx]++;
                if (numArr[idx] == 1) {
                    numCount++;
                }
            }
            // 字母数超了，收缩窗口
            if (left <= right && charCount > k) {
                char c = data.charAt(left);
                if (Character.isLetter(c)) {
                    charCount--;
                }
                if (Character.isDigit(c)) {
                    int idx = c - '0';
                    numArr[idx]--;
                    if (numArr[idx] == 0) {
                        numCount--;
                    }
                }
                left++;
            }
            //当达到要求
            if (numCount == 10 && charCount == k) {
                int tempNumCount = numCount;
                int tempCharCount = charCount;
                int[] tmpNumArr = numArr.clone();
                int tempLeft = left;
                // 收缩左边界
                while (tempLeft <= right && tempNumCount == 10 && tempCharCount == k) {
                    res++;
                    char c = data.charAt(tempLeft);
                    if (Character.isLetter(c)){
                        tempCharCount--;
                    }
                    if (Character.isDigit(c)) {
                        int idx = c - '0';
                        tmpNumArr[idx]--;
                        if (tmpNumArr[idx] == 0) {
                            tempNumCount--;
                        }
                    }
                    tempLeft++;
                }
            }
        }
        System.out.println(res);

    }
}
