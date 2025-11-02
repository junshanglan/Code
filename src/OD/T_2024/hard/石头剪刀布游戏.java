package OD.T_2024.hard;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Description：
 * @Date：2024-08-28
 * @Author：landaguo
 */
public class 石头剪刀布游戏 {

    /**
     *  A   B   C
     * 石头 剪刀 布
     * --------------
     * abc1 A
     * def A
     * alic A
     * xyz B
     * @param args
     */
    public static void main(String[] args) {
        // TODO 示例代码更优雅
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> aGroup = new TreeSet<>();
        TreeSet<String> bGroup = new TreeSet<>();
        TreeSet<String> cGroup = new TreeSet<>();
        while (scanner.hasNextLine()) {
            String[] temp = scanner.nextLine().split(" ");
            if (temp[1].equals("A")) {
                aGroup.add(temp[0]);
            }else if (temp[1].equals("B")) {
                bGroup.add(temp[0]);
            }else if (temp[1].equals("C")) {
                cGroup.add(temp[0]);
            }
        }
        if (aGroup.size() > 0 && bGroup.size() > 0 && cGroup.size() > 0) {
            System.out.println("NULL");
        } else if (aGroup.size() > 0 && bGroup.size() > 0) {
            println(aGroup);
        } else if (aGroup.size() > 0 && cGroup.size() > 0) {
            println(cGroup);
        } else if (bGroup.size() > 0 && cGroup.size() > 0) {
            println(bGroup);
        }
    }

    public static void println(TreeSet input){
        Iterator iterator = input.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
