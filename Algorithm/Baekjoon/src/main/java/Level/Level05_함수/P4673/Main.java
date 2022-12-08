package Level.Level05_함수.P4673;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int result = dn(i + 1);
            if (result < 10000 && result > 0) {
                arr[result]++;
            }
        }

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] == 0) {
                sb.append(j).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int dn(int n) {
        int d = n;
        while (n != 0) {
            d += n % 10;
            n /= 10;
        }

        return d;
    }
}
