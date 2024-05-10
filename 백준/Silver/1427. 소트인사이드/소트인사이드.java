import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] digits = br.readLine().chars()
                .map(Character::getNumericValue)
                .toArray();

        quickSort(digits, 0, digits.length - 1);

        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }

        System.out.println(sb);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        quickSort(a, lo, pivot - 1);
        quickSort(a, pivot + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int pivotIndex = lo + (hi - lo) / 2;
        int pivot = a[pivotIndex];

        swap(a, pivotIndex, hi);

        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] >= pivot) {
                swap(a, i, j);
                i++;
            }
        }

        swap(a, i, hi);

        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
