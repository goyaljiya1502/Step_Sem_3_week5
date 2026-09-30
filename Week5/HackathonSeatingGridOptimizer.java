package Week5;

import java.util.Scanner;

public class HackathonSeatingGridOptimizer {

    private static double rowAverage(int[] row) {
        int sum = 0;

        for (int value : row) {
            sum = sum + value;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {

            double average = rowAverage(seatingScores[i]);

            if (average < threshold) {
                result = result + "Row " + i + ": Quiet Zone";
            } else {
                result = result + "Row " + i + ": Buzzing Zone";
            }

            if (i < seatingScores.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        int[][] seatingScores = new int[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of students in row " + i + ": ");
            int columns = sc.nextInt();

            seatingScores[i] = new int[columns];

            System.out.println("Enter scores:");
            for (int j = 0; j < columns; j++) {
                seatingScores[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        System.out.println(classifyRows(seatingScores, threshold));

        sc.close();
    }
}
