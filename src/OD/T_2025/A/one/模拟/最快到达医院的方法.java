package OD.T_2025.A.one.模拟;

import java.util.Scanner;

public class 最快到达医院的方法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double aDis = scanner.nextDouble();
        double bDis = scanner.nextDouble();
        double taxi = scanner.nextDouble();
        double wait = scanner.nextDouble();
        double walk = scanner.nextDouble();

        double aTime = aDis * 1000 / taxi + wait;
        double bTime = bDis * 1000 / walk;

        if (aTime > bTime) {
            System.out.println("Walk");
        }else if (aTime < bTime) {
            System.out.println("Taxi");
        }else{
            System.out.println("Same");
        }

    }
}
