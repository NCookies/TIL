const fs = require('fs')
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(Number).slice(1)

function shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
        // 0부터 i 사이의 임의의 정수를 선택
        const j = Math.floor(Math.random() * (i + 1));

        // 배열의 요소를 서로 교환
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
}

function quickSort(array) {
    // 배열의 길이가 1 이하이면 이미 정렬된 상태이므로 그대로 반환
    if (array.length <= 1) {
        return array;
    }

    // 배열의 가운데 요소를 피벗으로 선택
    const pivot = array[Math.floor(array.length / 2)];

    // 피벗보다 작은 요소들로 구성된 배열
    const less = [];
    // 피벗과 같은 요소들로 구성된 배열
    const equal = [];
    // 피벗보다 큰 요소들로 구성된 배열
    const greater = [];

    // 배열의 각 요소를 순회하면서 피벗과 비교하여 적절한 배열에 넣음
    for (let element of array) {
        if (element < pivot) {
            less.push(element);
        } else if (element > pivot) {
            greater.push(element);
        } else {
            equal.push(element);
        }
    }

    // 재귀적으로 정렬하고 결과를 병합하여 반환
    return [...quickSort(less), ...equal, ...quickSort(greater)];
}

const solution = arr => {
    return arr.sort((a,b) => a-b).join("\n")
}

arr = shuffleArray(input);


console.log(solution(arr))
