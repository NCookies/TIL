import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 정렬
        Arrays.sort(arr);
//        quickSort(arr, 0, n - 1);

        // 명예 점수들을 오름차순으로 정렬했을 때 첫 번째 명예 점수는 반드시 1이어야 함
        long hackers = arr[0] - 1;
        arr[0] = 1;

        /*
         * 한 번의 Defile 프로젝트 실행만으로 모든 국회의원을 없애려면
         * 명예 점수를 오름차순으로 정렬했을 때
         * 이전 명예 점수와 같거나 1만큼 커야 한다.
         */
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                int next = arr[i - 1] + 1;  // 현재 위치에 들어갈 명예 점수

                hackers += arr[i] - next;
                arr[i] = next;
            }
        }

        System.out.println(hackers);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        
        int pivot = partition(arr, lo, hi);
        
        quickSort(arr, lo, pivot - 1);
        quickSort(arr, pivot + 1, hi);
    }
    
    private static int partition(int[] arr, int lo, int hi) {
        int pivotIndex = lo + (hi - lo) / 2;
        int pivot = arr[pivotIndex];
        
        // 피벗값을 가장 오른쪽으로 이동
        swap(arr, pivotIndex, hi);

        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, hi);
        return i;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
