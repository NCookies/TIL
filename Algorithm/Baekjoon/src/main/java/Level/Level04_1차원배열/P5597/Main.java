package Level.Level04_1차원배열.P5597;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[30];

        for (int i = 0; i < arr.length - 2; i++) {
            arr[Integer.parseInt(br.readLine()) - 1]++;
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                System.out.println(j + 1);
            }
        }
    }
}
