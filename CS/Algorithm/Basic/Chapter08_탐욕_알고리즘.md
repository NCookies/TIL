# 탐욕 알고리즘

## 특징

- `greedy algorithm`
- 각 단계에서 `국소 최적해(locally optimal solution)`를 찾음으로써 최종적으로는 `전역 최적해(globally optimal solution)`를 구하게 된다.
- 각각의 단계에서 최적의 수를 찾아내면 된다.
- 항상 성공하는 것은 아니지만 간단해서 구현하기 좋다.
- 올바른 답을 내놓지 못할 수는 있어도 정답에 상당히 가깝다. 그저 "정답에 상당히 가까운" 답이기만 해도 충분할 때도 있다.

## 근사 알고리즘

탐욕 알고리즘은 거의 정답과 비슷한 답을 유추한다. 정확한 답을 계산하는 데 시간이 너무 많이 걸린다면 `근사 알고리즘(approximation algorithm)`을 사용할 수 있다.

## NP-완전 문제

`집합 커버링 문제(set-covering problem)`를 풀기 위해서는 가능한 모든 집합을 계산해야 한다.

### 외판원 문제

외판원 문제는 확인해야 할 경우의 수가 N!(N은 도시 개수)이다. `팩토리얼 함수(factorial funciton)`다. 

도시의 수가 늘어나면 경로의 수가 매우 빠르게 증가한다. 도시의 수가 많을 경우, 외판원 문제에 대한 정확한 해답을 구하는 게 어렵다.

외판원 문제와 집합 커버링 문제는 공통점이 있다. *모든 가능한 경우를 다 따져서 최단/최소를 구해야 한다.* 이런 문제를 `NP-완전 문제(NP-complete problem)`라고 한다.

### NP-완전 문제 판별

풀려고 하는 문제가 NP-완전 문제라는 것을 알아낸다는 것은 좋은 일이다. 문제를 완벽하게 풀려는 노력을 멈추고, 대신 근사 알고리즘을 써서 풀 수 있을테니 말이다. 그러나 어떤 문제가 NP-완전인지 아는 것은 어려운 일이다. 보통 쉽게 풀리는 NP-완전 문제 사이에는 조그만 차이밖에 없기 때문이다.

풀려는 문제가 NP-완전 문제인지 아닌지 알 수 있는 쉬운 방법은 존재하지 않지만, 몇 가지 참고 사항은 있다.

```
- 항목이 적을 때는 알고리즘이 빠른데, 항목이 늘어나면서 갑자기 느려진다.
- "X의 모든 조합"이라고 하면 보통 NP-완전 문제이다.
- 더 작은 하위 문제로 변환할 수 없어서 X의 가능한 모든 버전을 계산해야 한다면 아마도 NP-완전 문제일 것이다.
- 문제가 수열(외판원 문제와 같은 도시의 순서같이)을 포함하고 풀기가 어려우면 NP-완전 문제일 수 있다.
- 만약 문제에 집합(라디오 방송국 집합처럼)을 포함하고 풀기가 어려우면 NP-완전 문제일 수 있다.
- 문제를 집합 커버링 문제나 외판원 문제로 재정의할 수 있다면, 명백하게 NP-완전 문제이다.
```