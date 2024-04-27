#include<stdio.h>

int main()
{
	int n;
	scanf("%d",&n);

	int arr[n];
	int answer[n];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
		answer[i] = 0;
	}

	for (int i = 0; i < n; i++) {
		int min_index = i;

		for (int j = i; j < n; j++) {
			if (arr[j] < arr[min_index]) {
				min_index = j;
			}
		}

		if (min_index != i) {
			int distance = min_index - i;
			answer[arr[i] - 1] += distance;
			answer[arr[min_index] - 1] += distance;

			// swap
			int tmp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = tmp;
		}

		printf("%d ", answer[i]);
	}
}
