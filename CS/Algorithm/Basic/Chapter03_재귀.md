# 재귀

- `재귀(recursion)`
- 함수가 자기 자신을 호출하는 것
- 재귀를 쓴다고 성능이 더 나아지지는 않지만 풀이를 더 명확하게 만들어준다.
  - 반복문이 성능이 더 좋은 경우가 많다.
  - 상황에 따라 적절한 방법을 골라 사용할 것
- 대부분의 중요한 알고리즘들이 재귀를 사용한다.

# 재귀의 단계

- `기본 단계(base case)` : 함수가 자기 자신을 다시 호출하지 않는 경우, 즉 무한 반복으로 빠져들지 않게 하는 부분
- `재귀 단계(recursion case)` : 함수가 자기 자신을 호출하는 부분

```python
def countdown(i):
    print(i)
    if i <= i:      # 기본 단계
        return
    else:           # 재귀 단계
        countdown(i-1)
```

# 스택

- `호출 스택(call stack)`
  - 프로그램에서 중요하지만 재귀에서는 더더욱 중요한 개념
  - push / pop 연산
  - 모든 함수 호출은 호출 스택을 사용함
  - 호출 스택은 너무 커져서 메모리를 엄청나게 소비할 수 있음

[recursion_factorial.py](./code/03_recursion_factorial.py)
```python
def fact(x):
    if (x == 1) :
        return 1
    else:
        return x * fact(x - 1)

print(fact(3))
print(fact(5))

# 6
# 120
```
