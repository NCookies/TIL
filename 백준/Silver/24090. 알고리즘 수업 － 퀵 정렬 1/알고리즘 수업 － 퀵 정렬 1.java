import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k = 0;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1);

        if (cnt < k) {
            System.out.println("-1");
        }
    }

    static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(a, lo, hi);
            if (pivot == -1) {
                return;
            }

            quickSort(a, lo, pivot - 1);
            quickSort(a, pivot + 1, hi);
        }
    }

    static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                swap(a, ++i, j);

                if (++cnt == k) {
                    System.out.println(a[i] + " " + a[j]);
                    return -1;
                }
            }
        }

        if (i + 1 != hi) {
            swap(a, i + 1, hi);

            if (++cnt == k) {
                System.out.println(a[i + 1] + " " + a[hi]);
                return -1;
            }
        }

        return i + 1;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
