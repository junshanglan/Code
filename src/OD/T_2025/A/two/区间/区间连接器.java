package OD.T_2025.A.two.区间;

import java.util.*;

public class 区间连接器 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String[] split = input1.substring(1, input1.length() - 1).split("\\],\\[");
        List<int[]> rangeList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String[] tmp = split[i].split(",");
            rangeList.add(new int[]{Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1])});
        }
        // he并重叠的或者相邻的区间
        List<int[]> mergeList = mergeList(rangeList);
        // 连接器数组
        String input2 = scanner.nextLine();
        String[] connectArr = input2.substring(1, input2.length() - 1).split(",");
        List<Integer> connectList = new ArrayList<>();
        for (String s : connectArr) {
            connectList.add(Integer.parseInt(s));
        }
        // 连接逻辑
        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < mergeList.size() - 1; i++) {
            dist.add(mergeList.get(i + 1)[0] - mergeList.get(i)[1]);
        }
        Collections.sort(dist);
        Collections.sort(connectList);
        int i = 0 ,j = 0;
        int res = 0;
        while (i < dist.size() && j < connectList.size()) {
            if (connectList.get(j) >= dist.get(i)) {
                i++;
                j++;
                res++;
            }else{
                j++;
            }
        }
        System.out.println(mergeList.size() - res);
    }

    private static List<int[]> mergeList(List<int[]> ans){
        ans.sort(Comparator.comparing((int[] a) -> a[0]));
        List<int[]> mergeList = new ArrayList<>();
        int[] first = ans.get(0);
        for (int i = 1; i < ans.size(); i++) {
            int[] tmp = ans.get(i);
            if (first[1] >= tmp[0]) {
                int[] newInt = {first[0], Math.max(first[1], tmp[1])};
                first = newInt;
            }else{
                mergeList.add(first);
                first = tmp;
            }
        }
        mergeList.add(first);
        return mergeList;
    }
}
