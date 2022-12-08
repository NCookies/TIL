package Level.Level02_조건문.P2753;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int year;
        Scanner scanner = new Scanner(System.in);

        year = scanner.nextInt();
        if (((year % 4 == 0) && (year % 100 != 0)) | (year % 400 == 0)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
