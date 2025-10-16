package OD.T_2025.A.one.模拟;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 跳房子I {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int target = scanner.nextInt();
        String substring = input.substring(1, input.length() - 1);
        String[] split = substring.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int max = Integer.MAX_VALUE;
        Map<Integer,Integer> hash = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int left = target - num;
            if (hash.containsKey(left)){
                if (max > i + hash.get(left)) {
                    max = i + hash.get(left);
                    ans[0] = left;
                    ans[1] = num;
                }
            }
            if (!hash.containsKey(num)) {
                hash.put(num, i);
            }
        }
        System.out.println("[" + ans[0] + "," + ans[1] + "]");

    }
}
