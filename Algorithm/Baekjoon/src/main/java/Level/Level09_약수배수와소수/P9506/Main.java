package Level.Level09_약수배수와소수.P9506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 약수들의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n != -1) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(n).append(" = ");
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    sb.append(i).append(" + ");
                }
            }

            if (sum == n) {
                sb.delete(sb.length() - 3, sb.length());
                sb.append("\n");
                result.append(sb);
            } else {
                result.append(n).append(" is NOT perfect.\n");
            }

            n = Integer.parseInt(br.readLine());
        }

        System.out.println(result);
    }
}
