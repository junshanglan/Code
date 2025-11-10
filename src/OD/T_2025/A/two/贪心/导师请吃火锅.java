package OD.T_2025.A.two.贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * 5 1
 * 1 4
 * 2 1
 * 3 1
 * 4 1
 * 5 1
 */
public class 导师请吃火锅 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        List<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            list.add(new Item(x,y));
        }
        Collections.sort(list);
        int res = Integer.MIN_VALUE;
        Item cur = null;
        for (int i = 0; i < list.size(); i++) {
            if (cur != null && cur.x == list.get(i).x) {
                continue;
            }
            int tmpRes = 1;
            cur = list.get(i);
            int next = cur.x + Math.max(cur.y,m);
            for (int j = i + 1; j < list.size(); j++) {
                Item tmp = list.get(j);
                if (tmp.x == next) {
                    tmpRes++;
                    next += Math.max(cur.y,m);
                }
            }
            res = Math.max(tmpRes,res);
        }

        System.out.println(res);
    }

}
class Item implements Comparable<Item> {
    int x;
    int y;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Item item) {
        if (this.x == item.x) {
            return this.y - item.y;
        }
        return this.x - item.x;
    }
}

