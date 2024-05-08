import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(recur(n));
    }

    static Long recur(int x) {
        if (x == 1 || x == 2) {
            return 1L;
        } else {
            return recur(x - 1) + recur(x - 2);
        }
    }
}
