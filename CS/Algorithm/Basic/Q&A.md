# [DAY 1] 선택정렬

## [2750번] 수 정렬하기 (풀이)

### 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 선택 정렬
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;

            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
```

### 풀이

첫 번째 줄에서 n을 받고, n번만큼 루프를 돌며 입력 데이터를 읽어온다.

이후 입력 데이터가 저장된 배열을 선택 정렬을 사용해 오름차순으로 정렬한다. 선택 정렬은 주어진 리스트에서 최소값을 찾고, 이를 맨 앞에 위치한 값을 교체하는 것을 반복하는 제자리 정렬 알고리즘 중 하나이다.

이를 구현하기 위해 2중 for문을 사용했으며, 따라서 위 프로그램의 시간복잡도는 
이다.

## [28116번] 선택 정렬의 이동 거리 (출제)

### 문제 및 관련 링크

- [문제 링크](https://www.acmicpc.net/problem/28116)
- [코드 링크(Java) - 664ms](https://github.com/NCookies/TIL/blob/master/%EB%B0%B1%EC%A4%80/Silver/28116.%E2%80%85%EC%84%A0%ED%83%9D%E2%80%85%EC%A0%95%EB%A0%AC%EC%9D%98%E2%80%85%EC%9D%B4%EB%8F%99%E2%80%85%EA%B1%B0%EB%A6%AC/%EC%84%A0%ED%83%9D%E2%80%85%EC%A0%95%EB%A0%AC%EC%9D%98%E2%80%85%EC%9D%B4%EB%8F%99%E2%80%85%EA%B1%B0%EB%A6%AC.java)
- [코드 링크(C) - 200ms](https://github.com/NCookies/TIL/blob/master/%EB%B0%B1%EC%A4%80/Silver/28116.%E2%80%85%EC%84%A0%ED%83%9D%E2%80%85%EC%A0%95%EB%A0%AC%EC%9D%98%E2%80%85%EC%9D%B4%EB%8F%99%E2%80%85%EA%B1%B0%EB%A6%AC/%EC%84%A0%ED%83%9D%E2%80%85%EC%A0%95%EB%A0%AC%EC%9D%98%E2%80%85%EC%9D%B4%EB%8F%99%E2%80%85%EA%B1%B0%EB%A6%AC.c)

### 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 각 숫자가 몇 번째 인덱스에 있는지 저장하고 있는 배열
        // Ex) [1, 3, 5, 2, 4]를 입력으로 받았을 때
        // idxArr[1]에는 1, [2]에는 4, [3]에는 2, [4]에는 5, [5]에는 3이 저장됨
        int[] idxArr = new int[N + 1];

        // 수열 A를 저장하고 있는 배열
        int[] numArr = new int[N + 1];

        // 각 숫자의 이동거리를 저장하는 배열
        int[] answer = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            idxArr[num] = i;
            numArr[i] = num;
        }

        // 수열 A는 1부터 N까지 있으므로 1부터 시작
        for (int i = 1; i <= N; i++) {
            // 현재 최소값이 와야하는 위치의 값이 최소값이 아닌 경우
            if (numArr[i] != i) {
                // 정렬되지 않은 부분의 최소값이 저장된 위치
                int minIndex = idxArr[i];

                // 최소값이 저장된 위치와 현재 정렬하려는 위치 간의 거리
                int distance = minIndex - i;

                // 이동한 값들의 숫자에 거리 추가
                answer[numArr[i]] += distance;
                answer[numArr[minIndex]] += distance;

                // 선택 정렬에서 정렬된 부분까지는(배열의 인덱스 i까지) 더 이상 사용하지 않기 때문에
                // 값을 스왑하지 않고 인덱스 값을 대입해주기만 함
                idxArr[numArr[i]] = idxArr[i];
                numArr[minIndex] = numArr[i];
            }

            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb);
    }
}
```

### 풀이

이 문제 풀이의 핵심은 다음과 같다.

1. 수열 A에는 1부터 N까지의 정수가 중복되지 않고 한 번씩 등장한다.
2. 따라서 선택 정렬의 과정에서 다음으로 와야할 최소값을 알 수 있다.

**입력**

위의 내용을 응용하여 문제를 풀기 위해서 두 개의 배열을 생성한다. 참고로 직관적으로 배열의 인덱스와 입력값을 매칭시키기 위해 배열 크기를 N + 1로 설정했다. (모든 배열의 0번방은 쓰지 않는다.)

- `numArr[n + 1]` : 수열 A를 저장하고 있는 배열
- `idxArr[n + 1]`
  - $A_i$가 저장된 위치를 저장하고 있는 배열
  - 이 배열은 양의 정수 $A_i$번째 방에, $A_i$가 `numArr`에 저장된 위치를 저장한다.
  - 만약 이 배열을 맵이나 딕셔너리로 대체하려면 key에는 $A_i$를, value에는 $A_i$가 `numArr`에 저장된 위치를 저장한다.

따라서 데이터 입력 시 두 배열의 초기화는 이렇게 이루어진다.

```java
// 각 숫자가 몇 번째 인덱스에 있는지 저장하고 있는 배열
// Ex) [1, 3, 5, 2, 4]를 입력으로 받았을 때
// idxArr[1]에는 1, [2]에는 4, [3]에는 2, [4]에는 5, [5]에는 3이 저장됨
int[] idxArr = new int[N + 1];

// 수열 A를 저장하고 있는 배열
int[] numArr = new int[N + 1];

// 각 숫자의 이동거리를 저장하는 배열
int[] answer = new int[N + 1];

st = new StringTokenizer(br.readLine());
for (int i = 1; i <= N; i++) {
    int num = Integer.parseInt(st.nextToken());
    idxArr[num] = i;
    numArr[i] = num;
}
```

**정렬 및 루프**

**선택 정렬**은 루프를 돌면서 배열의 현재 인덱스에 정렬되지 않은 값들 중 최소값이 와야한다. 그리고 이 문제에서는 현재 인덱스와 최소값이 위치한 인덱스의 차이를 구해야 하는거고.

만약 선택정렬을 직접 구현하게 되면 for문 두 개를 중첩해서 사용해야 한다. 따라서 시간복잡도는 $O(n^2)$가 된다. 해당 문제는 입력 데이터의 길이인 N이 굉장히 크기 때문에 $O(n^2)$ 정도의 시간이면 `시간 초과`가 발생하는 것 같다.

여기서 우리는 배열을 순회하면서 현재 인덱스에 어떤 값이 와야하는지 알 수 있고, 그 값의 위치도 알고 있다. 왜냐? $A_i$는 1부터 N까지의 모든 양의 정수가 중복되지 않고 꼭 한 번씩 등장하기 때문이다. 이들의 위치를 저장하고 있는 배열(맵 또는 딕셔너리)도 만들었고.

그래서 위 내용을 구현하자면 다음과 같다.

```java
// 수열 A는 1부터 N까지 있으므로 1부터 시작
for (int i = 1; i <= N; i++) {
    // 현재 최소값이 와야하는 위치의 값이 최소값이 아닌 경우
    if (numArr[i] != i) {
        // 정렬되지 않은 부분의 최소값이 저장된 위치
        int minIndex = idxArr[i];

        // 최소값이 저장된 위치와 현재 정렬하려는 위치 간의 거리
        int distance = minIndex - i;

        // 이동한 값들의 숫자에 거리 추가
        answer[numArr[i]] += distance;
        answer[numArr[minIndex]] += distance;

        // 선택 정렬에서 정렬된 부분까지는(배열의 인덱스 i까지) 
        // 더 이상 사용하지 않기 때문에
        // 값을 스왑하지 않고 인덱스 값을 대입해주기만 함
        idxArr[numArr[i]] = idxArr[i];
        numArr[minIndex] = numArr[i];
    }

    sb.append(answer[i]).append(' ');
}

System.out.println(sb);
```

# [DAY 2] 재귀

## [4779번] 칸토어 집합 (출제)

### 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] charArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        
        // 입력 끝날 때까지 루프
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            
            // 3^n 만큼 "-" 반복
            charArr = "-".repeat((int) Math.pow(3, n)).toCharArray();

            // 완전 이진 트리의 전위 탐색 과정과 유사함
            cantor(charArr.length, 0);
            System.out.println(charArr);
        }
    }

    static void cantor(int length, int startIndex) {
        // 선의 길이가 1이 되면 재귀 종료
        if (length == 1) {
            return;
        }

        //
        int nextLength = length / 3;

        // 3등분한 가운데 문자열을 공백으로 대체
        for (int i = 0; i < nextLength; i++) {
            charArr[i + startIndex + nextLength] = ' ';
        }

        // 각각 3등분 후의 왼쪽과 오른쪽 문자열에 재귀 함수 호출
        cantor(nextLength, startIndex);
        cantor(nextLength, startIndex + 2 * nextLength);
    }
}
```

### 풀이

$n^3$개의 '-'로 이루어진 문자열을 3등분하고 그 중 가운데 문자열을 공백으로 대체해야 한다. 그리고 나머지 두 덩이의 문자열을 다시 3등분하고 가운데 문자열을 공백으로 바꾼다. 이를 연속된 '-'의 개수가 1개가 될 때까지 반복하는 것이다.

나는 이 부분에서 이진트리의 전위 탐색을 떠올렸고 그 구현 코드를 가져와서 적용했다.

## [17478번] 재귀함수가 뭔가요? (풀이)

### 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        recur(0);

        sb.append("라고 답변하였지.\n");
        System.out.println(sb);
    }

    static void recur(int depth) {
        String underBar = "_".repeat(depth * 4);

        // 재귀 종료
        if (depth == n) {
            sb.append(underBar).append("\"재귀함수가 뭔가요?\"\n");
            sb.append(underBar).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");

            return;
        }

        sb.append(underBar).append("\"재귀함수가 뭔가요?\"\n");
        sb.append(underBar).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        sb.append(underBar).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        sb.append(underBar).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        recur(++depth);

        sb.append("_".repeat(depth * 4)).append("라고 답변하였지.\n");
    }
}
```

### 풀이

언뜻 봤을 때 복잡해보이지만 규칙이 있다.

제일 먼저 첫 번째 문장은 한 번만 출력된다.

```
어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
```

그리고 재귀 때마다 4줄의 문장이 반복된다.

```
"재귀함수가 뭔가요?"
"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
```

재귀의 마지막에는 두 개의 문장을 출력하고

```
"재귀함수가 뭔가요?"
"재귀함수는 자기 자신을 호출하는 함수라네"
```

재귀가 종료되며 아래 문장을 출력한다.

```
라고 답변하였지.
```

재귀 시 수행되는 모든 문장의 앞에는 재귀 깊이 * 4개의 `_`가 붙는다.

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
