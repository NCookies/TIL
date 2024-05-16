# [DAY 3] 퀵 정렬

## [16678번] 모독 (풀이)

### 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 정렬
        quickSort(arr, 0, n - 1);

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
```

### 풀이

왕은 단 1번의 "Defile" 프로젝트 실행을 통해 모든 국회의원을 없애려고 한다. 프로젝트 내용은 다음과 같다.

```
 1. 모든 국회의원을 모독해서 각각의 명예 점수를 1씩 감소시킨다.
 2. (1)로 인해 1명이라도 국회의원에서 박탈당한 사람이 발생했다면 국민들의 분노를 이용해 (1)로 돌아간다.
 3. (1)에 의해 국회의원에서 박탈당한 사람이 없다면 프로젝트를 종료한다.
```

프로젝트를 한 번만 수행하기 위해서는 명예 점수들을 **오름차순으로 정렬**했을 때 이전의 명예 점수와 같거나 1만큼 커야한다. 이렇게 해야 프로젝*트를 *실행했을 때 도미노처럼 연쇄작용으로 모든 국회의원을 없앨 수 있다.

예를 들어보자.
1. 입력 값으로 7 3 6 2 4가 들어왔다. (arr : `[7, 3, 6, 2, 4]`)
2. 정렬하면 2 3 4 6 7이 된다. (arr : `[2, 3, 4, 6, 7]`)
3. 가장 작은 명예 점수는 반드시 1이어야 한다. (arr : `[1, 3, 4, 6, 7]`, hackers = `1`)
4. 명예 점수는 앞의 명예 점수보다 1만큼 크거나 같아야 한다. 3이 2가 되기 위해서는 해커가 한 명 더 필요하다. (arr : `[1, 2, 4, 6, 7]`, hackers = 2)
5. 4는 2보다 크므로 명예 점수 3이 되어야 한다. (arr : `[1, 2, 3, 6, 7]`, hackers = 3)
6. 이를 반복한다.
7. 최종적으로 명예 점수는 1 2 3 4 5와 같은 형태가 된다. (arr : `[1, 2, 3, 4, 5]`, hackers = 7)

## [2751번] 수 정렬하기 2 (출제)

### 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.shuffle(list);

        quickSort(list, 0, n - 1);

        for (int i = 0 ; i < n; i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static void quickSort(ArrayList<Integer> arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(arr, lo, hi);

        quickSort(arr, lo, pivot);
        quickSort(arr, pivot + 1, hi);
    }

    private static int partition(ArrayList<Integer> arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        // 피벗으로 중간값 선택
        // int 값의 오버플로우를 대비하여 다음과 같이 수식을 구성함
        int pivot = arr.get(mid);
        lo--; hi++;

        while (lo <= hi) {
            do {
                lo++;
            } while (arr.get(lo) < pivot);

            do {
                hi--;
            } while (arr.get(hi) > pivot && lo <= hi);

            if (lo < hi) {
                swap(arr, lo, hi);
            } else {
                break;
            }
        }

        return hi;
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}
```

### 풀이

구현된 퀵 정렬은 가운데 피벗으로, 흔히 볼 수 있는 코드와 크게 다를 것이 없다. 다만 이 문제 같은 경우 퀵 정렬의 최악의 경우인 역정렬을 입력 데이터로 넣어두었기 때문에 시간 복잡도가 $O(n^2)$이 되는 경우가 발생한다. ([링크 참고](https://www.acmicpc.net/board/view/31887))

따라서 일반적인 방법으로는 이 문제를 퀵 정렬로 풀 수 없다. 대신 꼼수를 사용했다. 입력된 데이터를 랜덤으로 섞어서 최악의 경우를 의미 없게 만드는 것이다. (아주 낮은 확률로 섞은 이후 역정렬 데이터가 될 수도 있지만...) 이렇게 하면 정상적으로 문제 풀이에 성공한 것을 확인할 수 있다.
