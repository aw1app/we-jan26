
function binarySearch(arr, target) {
    let n = arr.length;

    let left = 0;
    let right = n - 1;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);

        if (arr[mid] === target)
            return mid;

        if (target < arr[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}

let arr = [2, 24, 45, 66, 75, 90, 170, 802];
let target = 170;

if ((indexFound = binarySearch(arr, target)) !== -1) {
    console.log(target, " found at index ", indexFound);
} else {
    console.log(target, " not found !");
}