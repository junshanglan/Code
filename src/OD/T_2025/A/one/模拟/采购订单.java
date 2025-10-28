package OD.T_2025.A.one.模拟;

import java.util.*;

public class 采购订单 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Good> goodList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            int count = scanner.nextInt();
            int price = scanner.nextInt();
            int pr = scanner.nextInt();
            goodList.add(new Good(id,count,price,pr));
        }
        List<Good> result = new ArrayList<>();
        Map<Integer,Good> goodMap = new HashMap<>();
        for (Good good : goodList) {
            if (good.pr == 0) {
                if (good.price > 100) {
                    result.add(good);
                }else{
                    if (goodMap.get(good.id) == null) {
                        goodMap.put(good.id,good);
                    }else{
                        goodMap.get(good.id).count += good.count;
                    }
                }
            }
        }
        for (Map.Entry<Integer, Good> item : goodMap.entrySet()) {
            if (item.getValue().count >= 100) {
                item.getValue().price = (int)Math.ceil(item.getValue().price * 0.9);
            }
            result.add(item.getValue());
        }
        result.sort((a,b) ->{
            if (a.id == b.id) {
                return b.count -a.count;
            }
            return a.id - b.id;
        });
        for (Good good : result) {
            System.out.print(good.id + " " +good.count + " " + good.price + "\n");
        }
    }
}

class Good{
    int id;
    int count;
    int price;
    int pr;

    public Good(int id, int count, int price, int pr) {
        this.id = id;
        this.count = count;
        this.price = price;
        this.pr = pr;
    }
}
