package Level.Level07_기본수학1.P2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int i;

        for (i = 1; v > up; i++) {
            v = v - (up - down);
        }

        System.out.println(i);
    }
}
