## 그래프의 소개

- `최단 경로 문제(shortest-path problem)` : 최단 경로, 즉 가장 짧은 것을 찾아야 함

어떤 문제를 그래프로 풀기 위해서는 아래 절차를 거친다.

1. 문제를 그래프로 모형화한다.
2. 너비 우선 탐색으로 문제를 푼다.

- `그래프(graph)`
  - 항목들이 서로 어떻게 연결되어 있는지를 모형화하는 방법
  - `정점(node)`과 `간선(edge)`로 이루어짐

## 너비 우선 탐색

- `너비 우선 탐색(Breadth-first search, BFS)`
  - 시작 정점을 방문한 후 시작 정점에 인접한 모든 정점들을 우선 방문하는 방법
  - 더 이상 방문하지 않은 정점이 없을 때까지 방문하지 않은 모든 정점들에 대해서도 너비 우선 검색을 적용한다.
  - 단순히 A에서 B로 가는 경로를 찾는 것이 아니라 최단 경로를 찾을 수 있다.
  - 큐(queue) 또는 대기열이라고 불리는 자료구조를 사용한다.

### 큐

- `큐(queue)`
  - 큐 안의 원소에 임의로 접근할 수 없다는 점에서 스택과 비슷함
  - 삽입(enqueue)과 제거(dequeue)라고 하는 두 가지 연산이 있음
  - 선입 선출(FIFO, First In First Out) 자료구조라고 함
  - 반대로 스택은 후입 선출(LIFO, Last In First Out)이라고 함

### 그래프의 구현

관계를 표시하기 위해 자료구조 중 해시 테이블을 사용한다. 해시 테이블의 키에 어떤 정점에 이웃하는 정점을 할당할 수 있다.

해시 테이블은 순서를 가지지 않기 때문에 키/값 쌍을 어떤 순서로 추가하든 상관없다. 

방향을 가지는 그래프를 방향 그래프(directed graph)라고 하고 한다. 관계에는 방향성이 있다. 무방향 그래프(undirected graph)는 화살표(방향성)을 가지지 않기 때문에 이어진 두 정점은 서로 이웃이 된다.

## 알고리즘의 구현

SNS의 친구 목록에서 이름이 m자로 끝나는 사람을 찾는다고 하자. 파이썬 코드로 다음과 같이 구현할 수 있다.

```python
from collections import deque

graph = {}
graph["you"] = ["alice", "bob", "claire"]

graph["bob"] = ["anuj", "peggy"]
graph["alice"] = ["peggy"]
graph["alice"] = ["peggy"]
graph["claire"] = ["thom", "jonny"]

graph["anuj"] = []
graph["peggy"] = []
graph["thom"] = []
graph["jonny"] = []

def person_is_target(name):
    return name[-1] == 'm'

def find_person(name):
    search_queue = deque()
    search_queue += graph[name]
    searched = []                                   # 이미 확인한 사람을 추적하기 위해 사용

    while search_queue:                             # 큐가 비어 있지 않는 한 계속 실행
        person = search_queue.popleft()             # 큐의 첫 번째 사람을 꺼냄
        if not person in searched:                  # 이전에 확인하지 않은 사람만 확인
            if person_is_target(person):            # 찾는 사람인지 확인
                print(person + " is a person who we are finding")
                return True
            else:
                search_queue += graph[person]       # 해당 사람의 모든 이웃을 탐색 목록에 추가
                searched.append(person)
    
    return False

find_person("you")
```

탐색 목록에 추가된 순서대로 사람을 확인해야 한다. 그래서 탐색 목록은 큐가 되어야 한다. 그렇지 않으면 최단 경로는 구할 수 없다.

무한 반복이 되지 않도록 누군가를 확인한 다음에는 두 번 다시 확인하지 않도록 해야 한다.

### 실행 시간

네트워크 전체를 탐색한다는 것은 모든 정점을 따라서 움직인다는 뜻이 된다. 따라서 실행 시간은 최소한 $O(간선의 개수)$가 된다.

탐색할 사람을 저장하는 큐도 있어야 한다. 큐에 사람을 추가하는 데는 상수 시간, 즉 $O(1)$이 걸린다. 모든 사람에 대해 이것을 적용하면 총 $O(사람의 수)$ 시간이 걸린다. 따서 너비 우선 탐색은 $O(사람의 수 + 간선의 수)$가 되고, 보통 $O(V+E)$라고 표기한다. (V: 정점의 수, E: 간선의 수)
