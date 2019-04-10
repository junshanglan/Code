package hashtable;

/**
 * 771. 宝石与石头
 *
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        // J = "aA", S = "aAAbbbbaaaa"
        String J = "aA", S = "aAAbbbbaaaa";
        int i = numJewelsInStones(J, S);
        System.out.println(i);
    }

    public static int numJewelsInStones(String J, String S) {
        int num = 0;
        for (int i = 0; i < J.length(); i++) {
            char jewel =J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                if (jewel == S.charAt(j))
                    num++;
            }
        }
        return num;
    }
}
