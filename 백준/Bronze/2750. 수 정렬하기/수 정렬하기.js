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
    if (array.length <= 1) {
        return array;
    }

    const pivot = array[array.length - 1]; // 배열의 마지막 요소를 피벗으로 선택
    const left = []; // 피벗보다 작은 요소들
    const right = []; // 피벗보다 큰 요소들

    for (let i = 0; i < array.length - 1; i++) {
        if (array[i] < pivot) {
            left.push(array[i]);
        } else {
            right.push(array[i]);
        }
    }

    return [...quickSort(left), pivot, ...quickSort(right)];
}

const solution = arr => {
    return arr.sort((a,b) => a-b).join("\n")
}

arr = shuffleArray(input);


console.log(quickSort(arr).join("\n"));
