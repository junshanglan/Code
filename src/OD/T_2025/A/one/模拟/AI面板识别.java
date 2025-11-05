package OD.T_2025.A.one.模拟;

import java.util.*;

/**
 * 优先队列
 */
public class AI面板识别 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double height = 0;
        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            pq.add(new Item(id,x1,y1));
            height = (y2 - y1) * 0.5;
        }
        while (!pq.isEmpty()){
            Item first = pq.poll();
            if (pq.isEmpty() || pq.peek().y - first.y > height){
                System.out.print(first.id + " ");
            }else{
                List<Item> ans = new ArrayList<>();
                ans.add(first);

                while (!pq.isEmpty() && pq.peek().y -first.y <= height){
                    ans.add(pq.poll());
                }
                ans.sort(Comparator.comparingInt(a -> a.x));
                for (Item an : ans) {
                    System.out.print(an.id + " ");
                }
            }
        }
    }
}

class Item implements Comparable<Item>{

    int id;
    int x;
    int y;
    Item(int id,int x,int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Item o) {
        return this.y -o.y;
    }
}