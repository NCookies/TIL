import random


def write_sequence_to_file(N, filename):
    # 1부터 N까지의 정수 리스트 생성
    sequence = list(range(1, N + 1))
    # 리스트를 랜덤으로 섞음
    random.shuffle(sequence)
    
    data = ""
    # 파일에 랜덤으로 섞인 수열을 씀
    with open(filename, 'w') as file:
        for num in sequence:
            data += str(num) + ' '
        file.write(data)

N = 500000  # 원하는 범위의 최대 값
filename = 'sequence.txt'  # 파일 이름
write_sequence_to_file(N, filename)
