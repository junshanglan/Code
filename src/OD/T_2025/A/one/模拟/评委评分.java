package OD.T_2025.A.one.模拟;

import java.util.*;

public class 评委评分 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] one = scanner.nextLine().split(",");
        int m = Integer.parseInt(one[0]);
        // 选手数
        int n = Integer.parseInt(one[1]);
        if (m < 3 || n < 3){
            System.out.println(-1);
            return;
        }
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            personList.add(new Person(i + 1));
        }
        for (int i = 0; i < m; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            // 评委的评分数组
            for (int j = 0; j < array.length; j++) {
                if (array[j] > 10 || array[j] < 1){
                    System.out.println(-1);
                    return;
                }
                personList.get(j).sum += array[j];
                personList.get(j).scorelist.add(array[j]);
                Collections.reverse(personList.get(j).scorelist);
            }
        }
        Collections.sort(personList);

        for (int i = 0; i < 3; i++) {
            if (i != 2){
                System.out.print(personList.get(i).num);
                System.out.print(",");
            }else{
                System.out.print(personList.get(i).num);
            }
        }

    }
}

class Person implements Comparable<Person> {
    int num;
    int sum = 0;
    List<Integer> scorelist = new ArrayList<>();

    Person(int num){
        this.num = num;
    }

    @Override
    public int compareTo(Person o) {
        if (this.sum == o.sum) {
            for (int i = 0; i < scorelist.size(); i++) {
                if (this.scorelist.get(i) != o.scorelist.get(i)) {
                    return o.scorelist.get(i).compareTo(this.scorelist.get(i));
                }
            }
        }else{
            return o.sum - this.sum;
        }
        return 0;
    }
}
