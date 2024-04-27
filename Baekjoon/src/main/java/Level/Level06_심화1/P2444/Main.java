package Level.Level06_심화1.P2444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 별 찍기 - 7
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(n - i - 1));
            sb.append("*".repeat(Math.max(0, (i + 1) * 2 - 1)));
            sb.append('\n');
        }

        for (int i = 0; i < n - 1; i++) {
            sb.append(" ".repeat(i + 1));
            sb.append("*".repeat(Math.max(0, (n - i - 1) * 2 - 1)));
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
