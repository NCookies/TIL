package Level.Level06_심화1.P25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 너의 학점은
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double sum = 0, creditSum = 0;
        double credit, subjectScore;

        for (int subject = 0; subject < 20; subject++) {
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();     // 과목명은 버림

            credit = Double.parseDouble(st.nextToken());
            subjectScore = confirmGrade(st.nextToken());

            if (subjectScore == -1) {
                continue;
            }

            sum += credit * subjectScore;
            creditSum += credit;
        }

        System.out.printf("%6f", sum / creditSum);
    }

    public static double confirmGrade(String s) {
        switch (s) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "P":
                return -1;
            case "F":
            default:
                return 0;
        }
    }
}
