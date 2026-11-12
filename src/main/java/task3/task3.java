package task3;
import java.util.Scanner;
import java.util.ArrayList;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] grades = new int[n][m];
        double totalSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grades[i][j] = scanner.nextInt();
                totalSum += grades[i][j];
            }
        }

        double[] studentAverages = new double[n];
        double maxAvg = -1.0;

        for (int i = 0; i < n; i++) {
            double sSum = 0;
            for (int j = 0; j < m; j++) {
                sSum += grades[i][j];
            }
            double avg = sSum / m;
            studentAverages[i] = avg;
            if (avg > maxAvg) {
                maxAvg = avg;
            }
        }

        double groupAvg = totalSum / (n * m);

        System.out.println("Student averages:");
        for (int i = 0; i < n; i++) {
            if (studentAverages[i] == (int) studentAverages[i]) {
                System.out.println((int) studentAverages[i]);
            } else {
                System.out.println(studentAverages[i]);
            }
        }

        System.out.println("\nGroup average:");
        if (groupAvg == (int) groupAvg) {
            System.out.println((int) groupAvg);
        } else {
            System.out.println(groupAvg);
        }

        System.out.println("\nHighest-performing student:");
        for (int i = 0; i < n; i++) {
            if (Math.abs(studentAverages[i] - maxAvg) < 1e-9) {
                System.out.println(i + 1);
            }
        }

        System.out.println("\nStudents with at least one grade below 5:");
        ArrayList<Integer> below5 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean hasBelow = false;
            for (int j = 0; j < m; j++) {
                if (grades[i][j] < 5) {
                    hasBelow = true;
                    break;
                }
            }
            if (hasBelow) {
                below5.add(i + 1);
            }
        }

        if (below5.isEmpty()) {
            System.out.println("None");
        } else {
            for (int s : below5) {
                System.out.println(s);
            }
        }

        scanner.close();
    }
}