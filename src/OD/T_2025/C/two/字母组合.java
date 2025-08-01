package OD.T_2025.C.two;

import java.util.*;

/**
 * 78
 * ux
 * 输出：uw,vw,vx,
 * 78
 * x
 * 输出：uw,vw,
 */
public class 字母组合 {

    static String[] letterArr = {"abc","def","ghi","jkl","mno","pqr","st","uv","wx","yz"};

    static Set<Character> filterSet = new HashSet<>();
    static Set<Character> used = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String filterStr = scanner.nextLine();
        for (int i = 0; i < filterStr.length(); i++) {
            filterSet.add(filterStr.charAt(i));
        }
        List<String> letterList = new ArrayList<>();
        for (int i = 0; i < nums.length(); i++) {
            letterList.add(letterArr[nums.charAt(i) - '0']);
        }
        StringBuilder res = new StringBuilder();
        dfs(letterList,0,new StringBuilder(),res,used);
        System.out.println(res);

    }
    static void dfs(List<String> letterList,int index,StringBuilder path,StringBuilder res,Set<Character> used) {
        if (index == letterList.size()) {
            if (notContainAllFilterLetter(used)){
                res.append(path).append(",");
            }
            return;
        }
        for (char c : letterList.get(index).toCharArray()) {
            path.append(c);
            used.add(c);
            dfs(letterList,index + 1,path,res,used);
            path.deleteCharAt(path.length() - 1);
            used.remove(c);
        }
    }
    static boolean notContainAllFilterLetter(Set<Character> used){
        for (Character c : filterSet) {
            if (!used.contains(c)) {
                return true;
            }
        }
        return false;
    }

}
