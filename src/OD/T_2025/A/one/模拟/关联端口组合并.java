package OD.T_2025.A.one.模拟;

import java.util.*;

/**
 * 1<=N<=100
 */
public class 关联端口组合并 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        if (m < 1 || m > 10) {
            System.out.println("[[]]");
            return;
        }
        List<List<Integer>> data = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] split = scanner.nextLine().split(",");
            if (split.length< 1 || split.length > 100) {
                System.out.println("[[]]");
                return;
            }
            List<Integer> tmp = new ArrayList<>();
            for (String s : split) {
                tmp.add(Integer.parseInt(s));
            }
            Collections.sort(tmp);
            data.add(tmp);
        }
        boolean flag = true;
        while (flag) {
            flag = dfs(data);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (List<Integer> item : data) {
            sb.append("[");
            Set<Integer> tmpSet = new LinkedHashSet<>(item);
            for (Integer i : tmpSet) {
                sb.append(i + ",");
            }
            sb.setLength(sb.length() - 1 );
            sb.append("],");
        }
        sb.setLength(sb.length() -1 );
        sb.append("]");
        System.out.println(sb);
    }

    public static boolean dfs(List<List<Integer>> data){
        boolean flag = false;
        for (int i = data.size() -1 ; i > 0; i--) {
            for (int j = i -1 ; j >= 0 ; j--) {
                if (countSameNum(data.get(i),data.get(j))){
                    data.get(j).addAll(data.get(i));
                    Collections.sort(data.get(j));
                    data.remove(i);
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean countSameNum(List<Integer> list1,List<Integer> list2){
        int count = 0;
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        for (Integer i : set1) {
            for (Integer j : set2) {
                if (i == j) {
                    count++;
                }
                if (count >= 2) return true;
            }
        }
        return false;
    }
}
