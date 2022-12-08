package Level.Level05_함수.P1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 100) {
            System.out.println(n);
            return;
        }

        int cnt = 99;
        for (int i = 100; i <= n; i++) {
            if (i >= 1000) {
                break;
            }
            if (hansu(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean hansu(int n) {
        int n1, n2, n3;

        n1 = n % 10;
        n = n / 10;

        n2 = n % 10;
        n = n / 10;

        n3 = n % 10;

        return (n1 - n2) == (n2 - n3);
    }
}
