import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] charArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            charArr = "-".repeat((int) Math.pow(3, n)).toCharArray();

            cantor(charArr.length, 0);

            System.out.println(charArr);
        }
    }

    static void cantor(int length, int startIndex) {
        if (length == 1) {
            return;
        }

        int nextLength = length / 3;

        for (int i = 0; i < nextLength; i++) {
            charArr[i + startIndex + nextLength] = ' ';
        }

        cantor(nextLength, startIndex);
        cantor(nextLength, startIndex + 2 * nextLength);
    }
}