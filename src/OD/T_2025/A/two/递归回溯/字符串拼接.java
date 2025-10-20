package OD.T_2025.A.two.递归回溯;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 字符串拼接 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        String inputStr = split[0];
        int targetLength = Integer.parseInt(split[1]);
        Set<String> uniqueSet = new HashSet<>();
        boolean[]  used = new boolean[inputStr.length()];

        dfs(inputStr, "", targetLength, uniqueSet,used);

        System.out.println(uniqueSet.size());
    }

    private static void dfs(String input,String currentStr,int targetLength,Set<String> uniqueSet,boolean[]  used){
        if (currentStr.length() == targetLength) {
            uniqueSet.add(currentStr);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            // 当前节点要没使用过，且不能连续重复字符
            if (used[i] || (!currentStr.isEmpty() &&  currentStr.charAt(currentStr.length()-1)  == input.charAt(i))){
                continue;
            }
            used[i] = true;
            dfs(input, currentStr + input.charAt(i), targetLength, uniqueSet,used);
            used[i] = false;
        }
    }
}
