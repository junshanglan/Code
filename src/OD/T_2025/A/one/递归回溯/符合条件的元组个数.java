package OD.T_2025.A.one.递归回溯;

import java.util.*;

public class 符合条件的元组个数 {

    static int k,target,n;
    static boolean[] visited ;
    static int[]  array;
    static int res;
    static List<List<Integer>> numberList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array.length;
        k = scanner.nextInt();
        target = scanner.nextInt();
        visited = new boolean[n];
        dfs(0,new ArrayList<>());
        System.out.println(res);
    }
    private static void dfs(int index,List<Integer> ans){
        if (ans.size() == k) {
            int tmp = 0;
            for (Integer an : ans) {
                tmp += an;
            }
            if (tmp == target && !isContains(ans)) {
                numberList.add(new ArrayList<>(ans));
                res++;
            }
            return;
        }
        if (index < 0 || index >= n ) {
            return;
        }
        for (int i = index; i < n; i++) {
            ans.add(array[i]);
            dfs(i + 1,ans);
            ans.remove(ans.size() -1 );
        }
    }

    private static boolean isContains(List<Integer> list){
        ArrayList<Integer> tmpList = new ArrayList<>(list);
        Collections.sort(tmpList);
        for (List<Integer> l : numberList) {
            if (l.toString().equals(tmpList.toString())){
                System.out.println(l.toString());
                return true;
            }
        }
        return false;
    }
}
