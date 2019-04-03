package backtrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {
        //  S = "a1b2c"   "abc" "aBc" "aBC" "abC" "abc"    "Abc" "ABc" "ABC" "AbC" "Abc"
        String s = "abc";
        letterCasePermutation(s);
        String substring = s.substring(2,3);
        substring.toUpperCase();
        String s1 = s.substring(0, 2) + s.substring(2, 3).toUpperCase() + s.substring(3);
//		System.out.println(s1);

        List<String> res = new LinkedList<>();
        dfs("", s, res, 0);
        System.out.println(res);
    }
    public static List<Integer> letterCasePermutation(String S) {
        List<Integer> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                list.add(i);
            } else {

            }
        }
        System.out.println(list.toString());
        return list;
    }

    public static void dfs(String pre, String S, List<String> res, int index){
        System.out.println(pre+"-----------");
        // 判断结束的条件，因为没有for循环所以只能这么判断
        if (index == S.length())
            res.add(pre);
        else {
            //System.out.println(pre + "//////////////" + index);
            char ch = S.charAt(index);
            // 指定这是一个字母啊，就是数字，
            if (!Character.isLetter(ch))
                dfs(pre + ch, S, res, index + 1);
            else {
                // System.out.println("xiaoxie");
                // 将字符参数转化为小写的
                ch = Character.toLowerCase(ch);
                dfs(pre + ch, S, res, index + 1);
                // System.out.println("===========" + index);
                // 将字符参数转化为大写的
                ch = Character.toUpperCase(ch);
                dfs(pre + ch, S, res, index + 1);
            }
        }
    }
}