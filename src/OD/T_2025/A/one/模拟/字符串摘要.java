package OD.T_2025.A.one.模拟;

import java.util.*;

/**
 * abcabc
 * 输出：a1b1c1a0b0c0
 *
 * aabbcc
 * 输出：a2b2c2
 * bAaAcBb
 * a3b2b2c0
 *
 * aabcccba
 * 输出：c3a2b1a0b0
 */
class Alp implements Comparable<Alp>{
    Character c;
    int num;


    Alp(Character c,int num){
        this.c = c;
        this.num = num;
    }
    @Override
    public int compareTo(Alp o) {
        if (this.num == o.num) {
            return this.c - o.c;
        }else{
            return o.num - this.num;
        }
    }

}

public class 字符串摘要 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        List<Character> charList = new ArrayList<>();
        // 去除数字
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))){
                charList.add(input.charAt(i));
            }
        }
        List<Alp> result = new ArrayList<>();
        for (int i = 0; i < charList.size();) {
            if (i == charList.size() - 1) {
                result.add(new Alp(charList.get(i),0));
            }
            // 统计的 map中没有
            if (charList.get(i) == charList.get(i + 1)){
                int res = countContinueAlp(charList, i );
                result.add(new Alp(charList.get(i),res));
                i = i + res ;
            }else{
                // 统计后面出现的字符个数
                int res  = countNoContinue(charList,i);
                result.add(new Alp(charList.get(i),res));
                i++;
            }

        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i).c + "" + result.get(i).num);
        }
        System.out.println(sb);
    }

    private static int countContinueAlp(List<Character> charList,Integer index){
        int res = 1;
        while ((index + 1) < charList.size() && charList.get(index) == charList.get(index + 1) ){
            res++;
            index++;
        }
        return res;
    }

    private static int countNoContinue(List<Character> charList,Integer index){
        int res = 0;
        Character target = charList.get(index);
        for (int i = index + 1; i < charList.size(); i++) {
            if (charList.get(i) == target) res++;
        }
        return res;
    }
}
