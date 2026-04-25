

function maxSubArraySum(arr) {

    //Base case
    if (arr.length === 0) return 0; // If the array is empty, return 0 

    let maxCurrent = arr[0];
    let maxGlobal = arr[0];

    for (let i = 1; i < arr.length - 1; i++) {
        maxCurrent = Math.max(maxCurrent + arr[i], arr[i]);

        if (maxCurrent > maxGlobal)
            maxGlobal = maxCurrent;
    }

    return maxGlobal;

}


//Test out

myArr = [-2, 1, -3, 4, -1, 2, 1, -5, 4];

console.log (" Max sub array sum is ",maxSubArraySum(myArr)  )

