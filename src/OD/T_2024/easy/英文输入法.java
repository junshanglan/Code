package OD.T_2024.easy;

import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.TreeSet;

/**
 * @Description：
 * @Date：2024-05-20
 * @Author：landaguo
 */
public class 英文输入法 {
    /**
     * 知识点：
     * [^a-zA-Z]
     * 去匹配目标字符串中非a—z也非A—Z的字符.
     *
     * The furthest distance in the world, Is not between life and death, But when I stand in front of you, Yet you don't know that I love you.
     * f
     *
     * I love you
     * He
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String pre = scanner.nextLine();

        String[] temp = word.split("[^a-zA-Z]");
        TreeSet<String> cache = new TreeSet<>();
        Collections.addAll(cache,temp);

        StringJoiner sj = new StringJoiner(" ");
        cache.stream().filter(v -> v.startsWith(pre)).forEach(v -> sj.add(v));

        if (sj.length() != 0) {
            System.out.println(sj);
        }else{
            System.out.println(pre);
        }


    }
}
