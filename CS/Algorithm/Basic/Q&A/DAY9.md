# [DAY 9] 탐욕 알고리즘

## [프로그래머스] 조이스틱 (풀이)

https://school.programmers.co.kr/learn/courses/30/lessons/42860

### 코드

```java
class Solution {
    static public int solution(String name) {
        int answer = 0;

        int n = name.length();
        int upDown = 0;
        int leftRight = n - 1;

        for (int i = 0; i < n; i++) {
            if (name.charAt(i) <= 'N') {
                upDown += name.charAt(i) - 65;
            } else {
                upDown += 91 - name.charAt(i);
            }

            // 연속된 A의 다음 문자를 찾을 때까지 탐색
            int nextMove = i + 1;
            while (nextMove < n && name.charAt(nextMove) == 'A') {
                nextMove++;
            }

            leftRight = Math.min(leftRight, 
                        Math.min(i + i + (n - nextMove), (n - nextMove) + (n - nextMove) + i));
        }

        answer = upDown + leftRight;

        return answer;
    }
}
```

### 풀이

이 문제의 핵심을 정리하자면 다음과 같다.

1. 어떤 위치의 문자가 A가 아니라면 반드시 방문해야 한다. 즉, 문자가 A인 위치는 생략해도 된다.
2. 조이스틱을 위아래로 움직여 알파벳을 만드는 횟수는 정해져 있다. (고정)
3. 따라서 조이스틱을 좌우로 움직이는 횟수가 가장 적은 경우를 찾아야 한다.
4. A가 연속된 구간을 만날 때마다 어떻게 해야 움직이는 횟수가 가장 적은지 탐색한다.

조이스틱을 좌우로 최소한으로 움직이는 경우는 3가지가 있다.

- 원점으로부터 오른쪽 끝까지 탐색하는 경우 => `n - 1`

- 원점으로부터 x까지 이동하고 다시 왼쪽으로 이동해서 y까지 탐색하는 경우</br>
    => `x + x + (n - y)` : 오른쪽으로 x만큼 이동 + 다시 왼쪽으로 x만큼 이동 + 왼쪽으로 y까지(n-y) 이동

- 원점으로부터 왼쩍으로 이동해 y까지 탐색하고 다시 오른쪽으로 x까지 탐색하는 경우</br>
    => `(n - y) + (n - y) + x` : 왼쪽으로 y까지(n-y) 이동 + 오른쪽으로 원점까지(n-y) 이동 + 오른쪽으로 x까지 이동

### 참고

- [C++ 극도로 상세하고 쉬운 풀이](https://school.programmers.co.kr/questions/76244)
- [중요한 힌트 정리해드립니다.](https://school.programmers.co.kr/questions/47855)
