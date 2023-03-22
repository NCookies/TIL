package Level.Level11_브루트포스.P2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int length = input.length();
        int n = Integer.parseInt(input);

        /* 네 자리의 정수 B를 B(4), B의 생성자를 A라고 할 때,
         * B(4) = A + A1 + A2 + A3 + A4
         * B(4) - (A1 + A2 + A3 + A4) = A
         * 위의 수식에서 A1 ~ A4는 최대 9까지만 될 수 있기 때문에 A의 최솟값은 B에서 9를 4번 곱한 것을 뺀 만큼임
         * 따라서 정수 n의 생성자를 탐색하는 최소값은 n - (각 자릿수 * 9)임
         */
        for (int i = (n - length * 9); i < n; i++) {
            if (n == getDecomposition(i)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    public static int getDecomposition(int m) {
        int sum = m;

        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }

        return sum;
    }
}
