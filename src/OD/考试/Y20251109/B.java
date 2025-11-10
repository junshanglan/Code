package OD.考试.Y20251109;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        List<AP> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int s = scanner.nextInt();
            list.add(new AP(x,y,s));
        }
        Map<String,Integer> map = new HashMap<>();
        int dis = 2 * D;
        for (AP ap : list) {
            for (int i = - dis; i <= dis; i++) {
                for (int j = -dis; j <=dis ; j++) {
                    int newX = ap.x  + i;
                    int newY = ap.y  + j;
                    int xAbs = Math.abs(ap.x - newX);
                    int yAbs = Math.abs(ap.y - newY);
                    if (xAbs <= D && yAbs <= D) {
                        int d =Math.max(xAbs,yAbs);
                        int xinhao = (int) Math.floor(ap.s / (1 + d));
                        String pos = newX + " " + newY;
                        map.put(pos,map.getOrDefault(pos,0) + xinhao);
                    }
                }
            }
        }
        List<Point> pointList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pointList.add(new Point(entry.getKey(),entry.getValue()));
        }
        Collections.sort(pointList);

        System.out.println(pointList.get(0).pos);
    }
}

class AP{
    int x;
    int y;
    int s;

    public AP(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
}

class Point implements Comparable<Point>{
    String pos;
    int wifi;

    public Point(String pos, int wifi) {
        this.pos = pos;
        this.wifi = wifi;
    }

    @Override
    public int compareTo(Point o) {
        if (this.wifi == o.wifi) {
            return this.pos.compareTo(pos);
        }
        return o.wifi - this.wifi;
    }
}