package Level.Level10_시간복잡도.P24264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알고리즘 수업 - 알고리즘의 수행 시간 3
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        System.out.println(n * n);
        System.out.print(2);
    }
}
