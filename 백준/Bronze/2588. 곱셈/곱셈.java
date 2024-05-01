import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a, b, tmp;
        int digit = 1;
        int result = 0;

        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());

        for (int i = 0; i < 3; i++) {
            tmp = (a * (b % 10));
            System.out.println(tmp);

            b /= 10;
            result += tmp * digit;
            digit *= 10;
        }

        System.out.println(result);
    }
}
