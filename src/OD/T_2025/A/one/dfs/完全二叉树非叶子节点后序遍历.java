package OD.T_2025.A.one.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 完全二叉树非叶子节点后序遍历 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<String> res = new ArrayList<>();
        dfs(array, array.length, 0, res);
        System.out.println(String.join(" ",res));
    }

    private static boolean dfs(int[] data, int n, int pos, List<String> res){
        if (pos >= n){
            return false;
        }

        boolean left = dfs(data,n,2 * pos + 1,res);

        boolean right = dfs(data,n,2 * (pos + 1),res);

        if (left || right){
            res.add(data[pos] + "");
        }
        return true;
    }
}
