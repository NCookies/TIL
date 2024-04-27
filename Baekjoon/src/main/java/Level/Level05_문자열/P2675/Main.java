package Level.Level05_문자열.P2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int times = Integer.parseInt(st.nextToken());
            for (String s : st.nextToken().split("")) {
                sb.append(s.repeat(times));
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
