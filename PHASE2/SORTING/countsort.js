function countSort(arr) {

    const sortedArr = [];

    const maxVal = Math.max(...arr);

    const count = new Array(maxVal + 1).fill(0);

    // Build the frequency array 
    for (const num of arr) {
        count[num] += 1;
    }

    // Build sorted array
    for (let i = 0; i < count.length; i++) {
        while (count[i] > 0) {
            sortedArr.push(i);
            count[i] -= 1;
        }
    }

    return sortedArr;
}

const myArray = [170, 45, 75, 90, 802, 24, 2, 66];
console.log("ORIGINAL ARRAY", myArray);

let result = countSort(myArray);
console.log("SORTED ARRAY", result);