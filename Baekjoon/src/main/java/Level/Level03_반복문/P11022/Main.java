package Level.Level03_반복문.P11022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int times = Integer.parseInt(br.readLine());
        int a, b;

        for (int i = 0; i < times; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sb.append("Case #").append(i + 1).append(": ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(a).append(" + ").append(b).append(" = ").append(a + b);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
