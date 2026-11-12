package task2;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        int[] residents = new int[n];
        for (int i = 0; i < n; i++) {
            residents[i] = scanner.nextInt();
        }

        int totalResidents = 0;
        int totalLeft = 0, countLeft = 0;
        int totalRight = 0, countRight = 0;

        for (int i = 0; i < n; i++) {
            totalResidents += residents[i];
            if ((i + 1) % 2 != 0) { // Odd house number (left side)
                totalLeft += residents[i];
                countLeft++;
            } else { // Even house number (right side)
                totalRight += residents[i];
                countRight++;
            }
        }

        System.out.println("Total residents: " + totalResidents);
        System.out.println("Residents on the left: " + totalLeft);
        System.out.println("Residents on the right: " + totalRight);

        System.out.print("Average per house on the left: ");
        if (countLeft == 0) {
            System.out.println("N/A");
        } else {
            double avg = (double) totalLeft / countLeft;
            if (avg == (int) avg) {
                System.out.println((int) avg);
            } else {
                System.out.println(avg);
            }
        }

        System.out.print("Average per house on the right: ");
        if (countRight == 0) {
            System.out.println("N/A");
        } else {
            double avg = (double) totalRight / countRight;
            if (avg == (int) avg) {
                System.out.println((int) avg);
            } else {
                System.out.println(avg);
            }
        }

        scanner.close();
    }
}