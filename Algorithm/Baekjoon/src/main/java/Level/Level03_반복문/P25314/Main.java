package Level.Level03_반복문.P25314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n / 4; i++) {
            sb.append("long").append(' ');
        }
        sb.append("int");

        System.out.println(sb);
    }
}
