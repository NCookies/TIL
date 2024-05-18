from collections import Counter

def modulo_remainders_distribution(n, m):
    remainders_distribution = Counter()  # 나머지 값의 분포를 저장할 Counter 객체

    # 가능한 배열의 조합을 생성하고 나머지 연산 후 분포를 기록
    for i in range(m ** n):
        array = [(i // (m ** j)) % m for j in range(n)]  # 배열 생성
        remainder = sum(array) % m  # 배열의 합을 m으로 나머지 연산
        remainders_distribution[remainder] += 1  # 나머지 값의 출현 횟수 기록

    return remainders_distribution

n = int(input("배열의 길이를 입력하세요: "))
m = int(input("배열 안의 숫자 범위를 입력하세요: "))

distribution = modulo_remainders_distribution(n, m)

print("나머지 값과 해당 값의 출현 횟수:")
for remainder, count in distribution.items():
    print(f"나머지: {remainder}, 출현 횟수: {count}")
