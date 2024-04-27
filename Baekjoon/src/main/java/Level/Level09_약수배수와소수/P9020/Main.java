package Level.Level09_약수배수와소수.P9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드바흐의 추측
public class Main {
    public static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        makePrimeFilter();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int a = n / 2;
            int b = n / 2;

            while (true) {
                if (!prime[a] && !prime[b]) {
                    sb.append(a).append(" ").append(b).append('\n');
                    break;
                }

                a--;
                b++;
            }
        }

        System.out.println(sb);
    }

    public static void makePrimeFilter() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * 2; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
}
