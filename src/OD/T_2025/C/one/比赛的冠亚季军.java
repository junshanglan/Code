package OD.T_2025.C.one;

import java.util.*;

/**
 * @Description：
 * @Date：2025-07-30
 * @Author：landaguo
 */
public class 比赛的冠亚季军 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] people =  Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Integer::parseInt).toArray();

        List<Athlete> athletes = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            athletes.add(new Athlete(i,people[i]));
        }
        List<Athlete> winner = new ArrayList<>();
        List<Athlete> loser = new ArrayList<>();
        complete(athletes,winner,loser);

        Collections.sort(winner);
        Collections.sort(winner);
    }

    public static void complete(List<Athlete> all,List<Athlete> winner,List<Athlete> loser){
        List<Athlete> result = new ArrayList<>();
        for (int i = 0; i < all.size(); i+=2) {
            int len = all.size();
            Athlete one = all.get(i);
            Athlete two = all.get(i + 1);
            if (one.score >= two.score) {
                result.add(one);
                if (len <= 4) {
                    winner.add(one);
                    loser.add(two);
                }
            }else{
                result.add(two);
                if (len <= 4) {
                    winner.add(two);
                    loser.add(one);
                }
            }
        }
        if (all.size() > 3) {
            complete(result,winner,loser);
        }
    }


}

class Athlete implements Comparable<Athlete>{
    Integer id;
    Long score;
    Athlete(int id,long score){
        this.id = id;
        this.score = score;
    }


    @Override
    public int compareTo(Athlete o) {
        // 分数大的在前，若相等，id小的在前
        if (this.score != o.score) {
            return this.score.compareTo(o.score);
        }
        return this.id - o.id;
    }
}
