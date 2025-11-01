package OD.T_2025.A.one.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 处理器问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrStr = scanner.nextLine();
        String[] inputArr = arrStr.substring(1, arrStr.length() - 1).split(",");
        int[] data = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            data[i] = Integer.parseInt(inputArr[i].trim());
        }
        Arrays.sort(data);
        int num = scanner.nextInt();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            if (data[i] < 4) {
                list1.add(data[i]);
            }else{
                list2.add(data[i]);
            }
        }
        int len1 = list1.size();
        int len2 = list2.size();
        List<List<Integer>> ans = new ArrayList<>();
        if (num == 1) {
            if (len1 == 1 || len2 == 1) {
                if (len1 == 1) dfs(0,1,list1,new ArrayList<>(),ans);
                if (len2 == 1) dfs(0,1,list2,new ArrayList<>(),ans);
            }else if (len1 == 3 || len2 == 3) {
                if (len1 == 3) dfs(0,1,list1,new ArrayList<>(),ans);
                if (len2 == 3) dfs(0,1,list2,new ArrayList<>(),ans);
            }else if (len1 == 2 || len2 == 2) {
                if (len1 == 2) dfs(0,1,list1,new ArrayList<>(),ans);
                if (len2 == 2) dfs(0,1,list2,new ArrayList<>(),ans);
            }else if (len1 == 4 || len2 == 4) {
                if (len1 == 4) dfs(0,1,list1,new ArrayList<>(),ans);
                if (len2 == 4) dfs(0,1,list2,new ArrayList<>(),ans);
            }
        }else if (num == 2) {
            if (len1 == 2 || len2 == 2) {
                if (len1 == 2) dfs(0,2,list1,new ArrayList<>(),ans);
                if (len2 == 2) dfs(0,2,list2,new ArrayList<>(),ans);
            }else if (len1 == 4 || len2 == 4) {
                if (len1 == 4) dfs(0,2,list1,new ArrayList<>(),ans);
                if (len2 == 4) dfs(0,2,list2,new ArrayList<>(),ans);
            }else if (len1 == 3 || len2 == 3) {
                if (len1 == 3) dfs(0,2,list1,new ArrayList<>(),ans);
                if (len2 == 3) dfs(0,2,list2,new ArrayList<>(),ans);
            }
        }else if (num == 4) {
            if (len1 == 4) ans.add(list1);
            if (len2 == 4) ans.add(list2);
        }else if (num == 8) {
            if (len1 == 4 && len2 == 4) {
                ans.add(list1);
                ans.add(list2);
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int startIndex,int level,List<Integer> data,List<Integer> path,List<List<Integer>> ans){
        if (path.size() == level) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < data.size();i++) {
            path.add(data.get(i));
            dfs(i + 1,level,data,path,ans);
            path.remove(path.size() - 1);
        }
    }
}
