import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a, b;

        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        if (a > 0 && b < 10) {
            System.out.println(a * b);
        } else {
            System.out.println("잘못된 입력입니다");
        }
    }
}