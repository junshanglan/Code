package 算法.string;


/**
 * 443. 压缩字符串
 *
 * 给定一组字符，使用原地算法将其压缩。
 *
 * 压缩后的长度必须始终小于或等于原数组长度。
 *
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 *
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 *
 *
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["a","a","b","b","c","c","c"]
 *
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 *
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 */
public class Compress {

    public static void main(String[] args) {
        //  {'a','a','b','b','c','c','c'};
        // ['a','b','b','b','b','b','b','b','b','b','b','b','b']
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = compress(chars);
        System.out.println(compress);
    }

    public static int compress(char[] chars) {
        char tempChar ;
        int i = 0,index = -1,j;
        while (i < chars.length) {
            tempChar = chars[i];
            chars[++index] = tempChar;
            Integer count = 1;
            for (j = i+1; j < chars.length; j++) {
                if (tempChar != chars[j]){
                    i = j;
                    break;
                }
                count++;
            }
            if (count != 1){
                String countTemp = count.toString();
                for (int k = 0; k < countTemp.length(); k++) {
                    chars[++index] = countTemp.charAt(k);
                }
            }
            if (j == chars.length)
                break;
        }
        return ++index;
    }
}
