package Level.Level05_문자열.P2908;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] input_data = new int[7];

        for (int i = 0; i < input_data.length; i++) {
            input_data[i] = System.in.read() - 48;
        }

        int tmp;
        tmp = input_data[0];
        input_data[0] = input_data[2];
        input_data[2] = tmp;

        tmp = input_data[4];
        input_data[4] = input_data[6];
        input_data[6] = tmp;

        int a, b;
        a = input_data[0] * 100 + input_data[1] * 10 + input_data[2];
        b = input_data[4] * 100 + input_data[5] * 10 + input_data[6];

        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
