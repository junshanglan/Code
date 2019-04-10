package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，
 * 但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        // "bella","label","roller"
        // "cool","lock","cook"
        char b = 'b';

        String s = "abcdea";
//        System.out.println(s.contains("a"));
//        System.out.println(s.indexOf(b));
//        String i = s.substring(0, 1) + s.substring(2);
//        System.out.println(i);
        System.out.println(s.indexOf("a"));
        String[] A = {"bellal","labell","rollerl",};
        List<String> result = findCommonCharacters(A);
        System.out.println(result);

    }
    public static List<String> findCommonCharacters(String[] A){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < A[0].length(); i++) {
            Character temp = A[0].charAt(i);
            int count = 0;
            for (int j = 1; j < A.length; j++) {
                int index = A[j].indexOf(temp);
                if ( index!= -1){
                    A[j] = A[j].substring(0,index) +A[j].substring(index+1);
                    count++;
                }
            }
            if (count == A.length -1) {
                result.add(temp.toString());
            }
        }
        return result;
    }
}
