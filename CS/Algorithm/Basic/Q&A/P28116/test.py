import sys

# 입력 받기
n = int(input())
A = {int(x): i+1 for i, x in enumerate(sys.stdin.readline().split())}
A_key = [0] # 딕셔너리의 키를 따로 저장하기 위함
A_key+=list(A.keys())

# 초기화
add = [0] * (n+1) # 얼마나 이동했는지 나타내는 리스트입니다

for i in range(1, n+1):
    if(A_key[i] != i):
        idx = A[i]
        num = abs(idx - i) # 차이 구하기
        idx_k=A_key[i]
        A_key[i], A_key[A[i]] = A_key[A[i]], A_key[i] # key의 자리를 바꾸기
        add[i] += num
        add[idx_k] += num
        if(A[i]>idx_k): # 인덱스 수정 반영
            A[i] -= num
            A[idx_k] += num
        elif(A[i]<idx_k):
            A[i] += num
            A[A_key[i]] -= num

print(*add[1:])
