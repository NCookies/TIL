package Level.Level07_기본수학1.P2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1		1
2~7		6
8~19		12
20~37		18
38~61		24
62~91		30
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println((n + 5) / 6);
    }
}
