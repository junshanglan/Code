package OD.T_2025.A.two.双指针;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 优雅子数组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(countArr(nums,k));
    }

    private static int countArr(int[] nums,int k){
        if (k < 0){
            return 0;
        }
        int left =  0;
        int ans = 0;
        int valid = 0;
        int n = nums.length;
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            int x = nums[right];
            countMap.put(x,countMap.getOrDefault(x,0) + 1);

            // 等于k的时候才加上，避免重复计算
            if (countMap.get(x) == k) {
                valid++;
            }
            while (valid > 0) {
                ans += n - right;
                int y = nums[left];
                countMap.put(y,countMap.get(y) - 1);

                // 不同的数字达到k-1才valid--
                if (countMap.get(y) ==  k - 1) {
                    valid--;
                }
                left++;
            }
        }
        return ans;
    }
}
