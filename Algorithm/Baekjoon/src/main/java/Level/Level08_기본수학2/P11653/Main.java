package Level.Level08_기본수학2.P11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] prime;      // 에라토스테네스 체 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            return;
        }

        prime = new boolean[n + 1];
        makeFilter();


        while (prime[n]) {      // n이 소수가 될 때까지 루프
            for (int i = 2; i < n; i++) {
                if (!prime[i] && n % i == 0) {
                    sb.append(i).append('\n');
                    n = n / i;
                    break;
                }
            }
        }
        sb.append(n);

        System.out.println(sb);
    }

    // 에라토스테네스 체 알고리즘
    // false == 소수
    public static void makeFilter() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            for (int j = i * i; j < prime.length; j+= i) {
                prime[j] = true;
            }
        }
    }
}
