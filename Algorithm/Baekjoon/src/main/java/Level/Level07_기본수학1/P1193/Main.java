package Level.Level07_기본수학1.P1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * n : 입력값
 * i : 몇 번쨰 줄인지 저장하고 있는 변수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int i;

        for (i = 1; n - i > 0; i++) {
            n = n - i;
        }

        if (i % 2 == 0) {
            System.out.println(n + "/" + (i + 1 - n));
        } else {
            System.out.println((i + 1 - n) + "/" + n);
        }
    }
}
