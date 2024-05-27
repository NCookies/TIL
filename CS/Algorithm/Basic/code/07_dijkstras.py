### 그래프 해시 테이블
graph= {}

graph["start"] = {} # 시작점의 이웃 정점과 그 가격
graph["start"]["a"] = 6
graph["start"]["b"] = 2

graph["a"] = {} ## 정점 a의 이웃 정점과 그 가격
graph["a"]["fin"] = 1

graph["b"] = {} ## 정점 b의 이웃 정점과 그 가격
graph["b"]["a"] = 3
graph["b"]["fin"] = 5

graph["fin"] = {} ## 도착점 (이웃이 없음)

### 가격 해시 테이블
infinity = float("inf")
costs = {}
costs["a"] = 6
costs["b"] = 2
costs["fin"] = infinity

### 부모 해시 테이블
parents = {}
parents["a"] = "start"
parents["b"] = "start"
parents["fin"] = None

### 정점 추적 배열
processed = []

def find_lowest_cost_node(costs): ## 가장 가격이 싼 정점을 찾는 메서드
    lowest_cost = float("inf")
    lowest_cost_node = None
    for node in costs: ## 가격 테이블의 모든 정점 확인
        cost = costs[node] ## 아직 처리하지 않은 정점 중 더 싼 것이 있으면
        if cost < lowest_cost and node not in processed:
            lowest_cost = cost ## 그 정점을 새로운 최저 정점으로 설정
            lowest_cost_node = node
    return lowest_cost_node
       
node = find_lowest_cost_node(costs) ## 아직 처리하지 않은 가장 싼 정점 찾기
while node is not None: ## 모든 정점 처리 시 반복문 종료
    cost = costs[node] ## 노드의 가격
    neighbors = graph[node] ## 이웃(해시 테이블 객체)
    for n in neighbors.keys(): ## 노드의 이웃 정점들 탐색
        new_cost = cost + neighbors[n]
        if costs[n] > new_cost: ## 만약 이 정점을 지나는 것이 가격이 더 싸다면 (더 빠르다면)
            costs[n] = new_cost ## 해당 정점의 가격 갱신
            parents[n] = node ## 부모 정점 갱신
    processed.append(node) ## 정점을 처리한 것을 기록
    node = find_lowest_cost_node(costs) ## 다음으로 처리할 정점을 찾아 반복

print(costs["fin"])
