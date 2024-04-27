package Level.Level08_기본수학2.P2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = 0;
        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;

                if (min == 0) {
                    min = i;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int divisor = 2; divisor <= Math.sqrt(num); divisor++) {
            if (num % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
