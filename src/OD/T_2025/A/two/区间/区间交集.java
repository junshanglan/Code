package OD.T_2025.A.two.区间;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 区间交集 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> inputList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[2];
            tmp[0] = scanner.nextInt();
            tmp[1] = scanner.nextInt();
            inputList.add(tmp);
        }
        // 先按照起点排序，再按照终点排序
        inputList.sort(Comparator.comparing((int[] a) -> a[0]).thenComparing(a -> a[1]));
        List<int[]> mergeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] one = inputList.get(i);
            for (int j = i+ 1; j < n; j++) {
                int[] two = inputList.get(j);
                if (two[0] <= one[1]) {
                    mergeList.add(new int[]{two[0], Math.min(one[1],two[1])});
                }
            }
        }
        if (mergeList.isEmpty()) {
            System.out.println("None");
            return;
        }
        mergeList.sort(Comparator.comparing((int[] a) -> a[0]).thenComparing(a -> a[1]));
        int[] prev = mergeList.get(0);
        for (int i = 1; i < mergeList.size(); i++) {
            int[] cur = mergeList.get(i);
            if(prev[1] >= cur[0]){
                prev[1] = Math.max(prev[1],cur[1]);
            }else{
                System.out.println(prev[0] + " " + prev[1]);
                prev = cur;
            }
        }
        System.out.println(prev[0] + " " + prev[1]);

    }
}
