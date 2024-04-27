package Level.Level08_기본수학2.P1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[n + 1];

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * 2; j <= n; j += i) {
                prime[j] = true;
            }
        }

        for (int k = m; k <= n; k++) {
            if (!prime[k]) {
                sb.append(k).append('\n');
            }
        }

        System.out.println(sb);
    }
}
