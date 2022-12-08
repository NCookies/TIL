package Level.Level07_기본수학1.P1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int fixedCoast = Integer.parseInt(st.nextToken());
        int variableCoast = Integer.parseInt(st.nextToken());
        int profit = Integer.parseInt(st.nextToken());

        int pv = profit - variableCoast;
        if (pv <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(fixedCoast / pv + 1);
        }
    }
}
