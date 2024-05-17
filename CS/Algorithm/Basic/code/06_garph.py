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
