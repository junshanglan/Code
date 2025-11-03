package OD.T_2025.A.one.模拟;

import java.util.*;

/**
 * 5
 * a 1 3
 * a 2 1
 * a 3 2
 * p
 * p
 * 输出：
 * 2
 * 3
 *-------------
 * 7
 * a 1 4
 * a 2 1
 * a 3 3
 * p
 * a 4 2
 * p
 * p
 * 输出：
 * 2
 * 4
 * 3
 *
 */
public class 插队 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        PriorityQueue<Customer> customers = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if ("a".equals(input[0])) {
                int num = Integer.parseInt(input[1]);
                int priority = Integer.parseInt(input[2]);
                customers.add(new Customer(i,num,priority));
            }else{
                if (customers.isEmpty()) {
                    System.out.println("");
                }else{
                    System.out.println(customers.poll().num);
                }
            }
        }
    }
}

class Customer implements Comparable<Customer> {

    int index;
    int num;
    int priority;

    public Customer(int index, int num, int priority) {
        this.index = index;
        this.num = num;
        this.priority = priority;
    }



    @Override
    public int compareTo(Customer o) {
        if(this.priority == o.priority) {
            return this.index - o.index;
        }
        return this.priority - o.priority;
    }
}
