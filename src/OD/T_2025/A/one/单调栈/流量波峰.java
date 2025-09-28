package OD.T_2025.A.one.单调栈;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 流量波峰 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.asList(scanner.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        if (nums.length < 3){
            System.out.println(-1);
            return;
        }
        int[] left = findLeft(nums);
        int[] right = findRight(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = left[i];
            int r = right[i];
            if (l == -1 || r == -1){
                continue;
            }
            res = Math.min(res,r-l);
        }
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static int[] findLeft(int[] nums){
        int[] left = new int[nums.length];
        Arrays.fill(left,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if (!stack.isEmpty()){
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        return left;
    }

    private static int[] findRight(int[] nums){
        int[] right = new int[nums.length];
        Arrays.fill(right,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if (!stack.isEmpty()){
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        return right;
    }
}
