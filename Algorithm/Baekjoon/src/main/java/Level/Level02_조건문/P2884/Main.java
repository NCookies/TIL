package Level.Level02_조건문.P2884;

import java.util.Scanner;


/*
1. 주어진 M에서 45만큼 뺀다
2. 만약 M의 값이 음수라면 H에서 1을 빼고 M에는 60 + (M - 45)를 대입한다.
3. 이 때 H의 값이 -1이 된다면 23으로 바꿔준다.
 */
public class Main {
    public static void main(String[] args) {
        int h, m;
        int diff = 0;
        Scanner scanner = new Scanner(System.in);

        h = scanner.nextInt();
        m = scanner.nextInt();

        diff = m - 45;

        if (diff < 0) {
            h -= 1;
            m = 60 + diff;

            if (h < 0) {
                h = 23;
            }
        } else {
            m = diff;
        }

        System.out.println(h + " " + m);
    }
}
