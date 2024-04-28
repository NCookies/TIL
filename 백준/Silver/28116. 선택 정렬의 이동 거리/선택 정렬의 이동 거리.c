#include<stdio.h>
#include<string.h>

int main()
{
	int n;
	scanf("%d",&n);

	int idx_arr[n + 1];
	int num_arr[n + 1];
	int answer[n + 1];

	memset(answer, 0, sizeof(int) * (n + 1));

	for (int i = 1; i <= n; i++) {
		int num;
		scanf("%d", &num);
		
		idx_arr[num] = i;
		num_arr[i] = num;
	}

	// 수열 A는 1부터 N까지 있으므로 1부터 시작
	for (int i = 1; i <= n; i++) {
		// 현재 최소값이 와야하는 위치의 값이 최소값이 아닌 경우
		if (num_arr[i] != i) {
			// 정렬되지 않은 부분의 최소값이 저장된 위치
			int min_index = idx_arr[i];

			// 최소값이 저장된 위치와 현재 정렬하려는 위치 간의 거리
			int distance = min_index - i;

			// 이동한 값들의 숫자에 거리 추가
			answer[num_arr[i]] += distance;
			answer[num_arr[min_index]] += distance;

			// 선택 정렬에서 정렬된 부분까지는(배열의 인덱스 i까지) 더 이상 사용하지 않기 때문에
			// 값을 스왑하지 않고 인덱스 값을 대입해주기만 함
			idx_arr[num_arr[i]] = idx_arr[i];
			num_arr[min_index] = num_arr[i];
		}

		printf("%d ", answer[i]);
	}
}
