package OD.T_2025.A.one.并查集;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeAreATeam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tmp = scanner.nextLine().split(" ");
        // 人数
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        if (n  < 1 || n > 100000 || m < 1 || m > 100000) {
            System.out.println("Null");
            return;
        }
        List<String> commandList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            commandList.add(scanner.nextLine());
        }

        int[] ans = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            ans[i] = i;
        }
        for (int i = 0; i < commandList.size(); i++) {
            String[] tmpStr = commandList.get(i).split(" ");
            int a = Integer.parseInt(tmpStr[0]);
            int b = Integer.parseInt(tmpStr[1]);
            int c = Integer.parseInt(tmpStr[2]);
            if (a < 0 || a > n || b <0 || b > n || (c != 0 && c!= 1)) {
                System.out.println("da pian zi");
                continue;
            }
            if (c == 0) {
                merge(a,b,ans);
                continue;
            }
            if (c == 1) {
                if (find(a,ans) != find(b,ans)) {
                    System.out.println("we are not a team");
                }else{
                    System.out.println("we are a team");
                }
            }
        }


    }

    private static int find(int i,int[] ans){
        if (ans[i] == i) return i;
        return find(ans[i],ans);
    }
    
    private static void merge(int a,int b,int[] ans){
        int rootA = find(a,ans);
        int rootB = find(a,ans);
        int min = Math.min(rootA, rootB);
        ans[a] = min;
        ans[b] = min;
    }
}
