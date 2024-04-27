package Level.Level02_조건문.P14681;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x, y;
        boolean valid_value = true;
        Scanner scanner = new Scanner(System.in);

        x = scanner.nextInt();
        y = scanner.nextInt();

        if (!(x == 0 || y == 0)) {
            valid_value = false;
        }
        if (!(x >= -1000 && x <= 1000) || !(y >= -1000 && y <= 1000)) {
            valid_value = false;
        }

        if (valid_value) {
            System.out.println("잘못된 입력값입니다.");
            return;
        }

        if (x > 0 && y > 0) {
            System.out.println("1");
        } else if (x < 0 && y > 0) {
            System.out.println("2");
        } else if (x < 0 && y < 0) {
            System.out.println("3");
        } else if (x > 0 && y < 0) {
            System.out.println("4");
        }
    }
}
