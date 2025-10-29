package OD.T_2025.A.two.双指针;

import java.util.Arrays;
import java.util.Scanner;

public class 数字序列比大小 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] aArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] bArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(aArr);
        Arrays.sort(bArr);
        int aLeft = 0,aRight = n - 1;
        int bLeft = 0,bRight = n - 1;
        int ans = 0;
        while (aLeft <= aRight) {
            // 最大对最大
            if (aArr[aRight] > bArr[bRight]) {
                ans++;
                aRight--;
                bRight--;
            }else if (aArr[aRight] < bArr[bRight]) {
                ans--;
                aLeft++;
                bRight--;
            }else{
                // 考虑相等情况
                if (aArr[aLeft] > bArr[bLeft]) {
                    ans++;
                    aLeft++;
                    bLeft++;
                }else{
                    // aleft 不大于bLeft ,可能小于等于
                    if (bArr[bRight] > aArr[aLeft]) {
                        ans--;
                    }
                    aLeft++;
                    bRight--;
                }
            }
        }
        System.out.println(ans);
    }
}
