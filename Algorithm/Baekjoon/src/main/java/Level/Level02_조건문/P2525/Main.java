package Level.Level02_조건문.P2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int h, m;
        int time;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(br.readLine());

        m += time;

        if (m >= 60) {
            h += m / 60;
            m = m % 60;
        }

        if (h >= 24) {
            h = h % 24;
        }

        System.out.println(h + " " + m);
    }
}
