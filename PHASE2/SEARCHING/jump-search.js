function jumpSearch(arr, x) {

    let m = Math.floor(Math.sqrt(arr.length)); // // Calculate the optimal block size 

    // Start the search from the beginning of the array 
    let left = 0;
    let right = m;

    // Check if the element is within the current block 
    while (arr[right] <= x && right < arr.length) {

        left = right;
        right += m;

        if (right >= arr.length) {
            right = arr.length - 1;
        }
    }

    // Once here, we have the range left, right where the target x possibly could be found. 
    // we do a linear search to find it.

    for( i=left; i <= right; i++){
        if (arr[i]=== x) return i;
    }

    return -1;
}


// Usage
console.log("--JUMP SEARCH--");

let arr = [2, 24, 45, 66, 75, 90, 170, 802];
let target = 75;

if ((indexFound = jumpSearch(arr, target)) !== -1) {
    console.log(target, " found at index ", indexFound);
} else {
    console.log(target, " not found !");
}