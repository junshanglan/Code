package OD.T_2025.C.one;

import java.util.*;

/**
 * 13
 * 3,3,7,4,4,4,4,7,7,3,5,5,5
 * 53,80,68,24,39,76,66,16,100,55,53,80,55
 *
 * 输出：5,3,7,4
 */
public class 统计射击比赛成绩 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] ids = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] scores = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent( ids[i],e -> new ArrayList<>()).add(scores[i]);
        }
        List<Person> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() < 3) {
                map.remove(entry.getKey());
                continue;
            }
            List<Integer> value = entry.getValue();
            Collections.sort(value,Collections.reverseOrder());
            result.add(new Person(entry.getKey(),value.get(0) + value.get(1) + value.get(2)));
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).id);
            if (i != result.size() -1 ) {
                System.out.print(",");
            }
        }


    }
}

class Person implements Comparable<Person>{
     int id;

     int score;

    Person(int id,int score){
        this.id = id;
        this.score = score;
    }


    @Override
    public int compareTo(Person other) {
        if (this.score != other.score) {
            return other.score - this.score;
        }
        return other.id - this.id;
    }
}
