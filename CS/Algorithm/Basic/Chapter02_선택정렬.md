# 메모리가 동작하는 방법

1. 메모리에 무언가 저장해야 할 때마다 컴퓨터에게 공간을 요청
2. 컴퓨터는 무언가를 저장할 수 있는 **주소**를 알려준다.

# 배열과 연결 리스트

## 연결 리스트

- `linked list`
- 각 원소에는 목록의 다음 원소에 대한 주소가 저장되어 있음
- 여러 가지 임의의 메모리 주소들이 하나의 목록으로 연결되어 있음

## 배열

- `array`
- 메모리에 연속적으로 나열된 데이터들
- 배열 안의 어떤 원소든 인덱스를 알고 있다면 바로 찾을 수 있다.

## 읽기와 삽입, 삭제

### 자료의 접근 방식

- `임의 접근(random access)`
  - 배열은 임의 접근이 가능하기 때문에 읽기 속도가 빠르다.
- `순차 접근(sequential access)`
  - 원소를 첫 번째부터 하나씩 읽는다.
  - 연결 리스트는 순차 접근할 수 밖에 없다.


### 성능

|       | 배열  | 리스트 |
|-------|-------|---------|
| 읽기  | O(1)  | O(n)     |
| 삽입  | O(n)  | O(1)     |
| 삭제  | O(n)  | O(1)     |

삽입/삭제 동작 이후 배열은 삽입/삭제한 원소의 뒤에 위치한 데이터들을 모두 옮겨야 하는 반면(**O(n)**), 연결 리스트는 명시된 주소만 수정하면 된다. (**O(1)**)

그러나 이는 연결 리스트가 삽입/삭제하고자 하는 원소에 바로 접근할 수 있을 때에만 **O(1)**이 성립된다. 따라서 *임의 접근이 가능한 배열을 더 많이 사용한다.*

# 선택 정렬

- `selection sort`

## 구현 방법

1. 주어진 리스트 중에 최소값을 찾는다.
2. 그 값을 맨 앞에 위치한 값과 교체한다(패스(pass)).
3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.

비교하는 것이 상수 시간에 이루어진다는 가정 아래, n개의 주어진 리스트를 이와 같은 방법으로 정렬하는 데에는 Θ(n2) 만큼의 시간이 걸린다.

선택 정렬은 알고리즘이 단순하며 사용할 수 있는 메모리가 제한적인 경우에 사용시 성능 상의 이점이 있다.

## 코드

[selection_sort.py](./code/02_selection_sort.py)
```python
def find_smallest(arr):
    smallest = arr[0]
    smallest_index = 0

    for i in range(1, len(arr)):
        if arr[i] < smallest:
            smallest = arr[i]
            smallest_index = i
    return smallest_index
    
def selection_sort(arr):
    new_arr = []
    for i in range(len(arr)):
        smallest = find_smallest(arr)
        new_arr.append(arr.pop(smallest))
    return new_arr

print(selection_sort([5, 3, 6, 2, 10]))

# [2, 3, 5, 6, 10]
```
