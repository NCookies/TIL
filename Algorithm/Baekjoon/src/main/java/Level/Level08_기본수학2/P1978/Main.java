package Level.Level08_기본수학2.P1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prime_num = 0;
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value == 1) {
                continue;
            }

            if (isPrime(value)) {
                prime_num++;
            }
        }

        System.out.println(prime_num);
    }

    public static boolean isPrime(int num) {
        // 어떤 수의 약수는 그 수의 제곱근까지만 확인하면 됨
        for (int divisor = 2; divisor <= Math.sqrt(num); divisor++) {
            if (num % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
