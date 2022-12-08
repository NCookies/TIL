package Level.Level03_반복문.P1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int times = 0;
        int new_num = 0;
        int n;

        n = num;
        while (true) {
            times++;
            new_num = ((n % 10) * 10) + ((n / 10 + n % 10) % 10);

            if (num == new_num) {
                break;
            }

            n = new_num;
        }

        System.out.println(times);
    }
}
