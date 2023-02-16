package Level.Level07_기본수학1.P2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 5 == 0) {
            System.out.println(n / 5);
            return;
        }

        for (int i = 0; i <= 3; i++) {
            int r = (n % 5) + (i * 5);
            if (r % 3 == 0) {
                if (n / 5 - i < 0) break;
                System.out.println((n / 5 - i) + r / 3);
                return;
            }
        }

        if (n % 3 == 0) {
            System.out.println(n / 3);
            return;
        } else {
            System.out.println(-1);
        }
    }
}
