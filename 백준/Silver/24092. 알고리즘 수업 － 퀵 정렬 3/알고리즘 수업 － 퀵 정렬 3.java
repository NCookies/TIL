import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arrA;
    static int[] arrB;

    static int eq;
    static int flag = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arrA = new int[n];
        arrB = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        if (compare() != -1) {
            quickSort(arrA, 0, n - 1);
        }

        System.out.println(flag);
    }

    static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        if (flag == 1) return;

        int pivot = partition(a, lo, hi);

        quickSort(a, lo, pivot - 1);
        quickSort(a, pivot + 1, hi);
    }

    static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                swap(a, ++i, j);
            }
        }

        if (i + 1 != hi) {
            swap(a, i + 1, hi);
        }

        return i + 1;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        // 스왑한 데이터만을 비교
        // 값을 스왑한 이후의 부분이 같다면 배열 B와 비교 작업 수행
        if (eq == i || eq == j) {
            eq = compare();
        }
    }

    static int compare() {
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] != arrB[i]) {
                // 값이 다른 인덱스 반환
                return i;
            }
        }

        // 두 배열이 같은 경우
        flag = 1;
        return -1;
    }
}
