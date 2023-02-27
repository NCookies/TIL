package Level.Level05_문자열.P5622;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int data = System.in.read();
        int time = 0;

        while (data >= 65) {
            switch(data) {
                case 'A' : case 'B': case 'C' :
                    time += 3;
                    break;

                case 'D' : case 'E': case 'F' :
                    time += 4;
                    break;

                case 'G' : case 'H': case 'I' :
                    time += 5;
                    break;

                case 'J' : case 'K': case 'L' :
                    time += 6;
                    break;

                case 'M' : case 'N': case 'O' :
                    time += 7;
                    break;

                case 'P' : case 'Q': case 'R' : case 'S' :
                    time += 8;
                    break;

                case 'T' : case 'U': case 'V' :
                    time += 9;
                    break;

                case 'W' : case 'X': case 'Y' : case 'Z' :
                    time += 10;
                    break;
            }

            data = System.in.read();
        }

        System.out.println(time);
    }
}
