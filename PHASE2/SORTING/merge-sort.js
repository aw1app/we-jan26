function mergeSort(arr) {

    // Base case:
    if (arr.length <= 1) return arr;

    // Find the middle index of the array 
    const middleIndex = Math.floor(arr.length / 2);

    // Divide the array into two halves 
    const leftHalf = arr.slice(0, middleIndex);
    const rightHalf = arr.slice(middleIndex);

    // Recursively sort the left and right halves 
    const sortedLeft = mergeSort(leftHalf);
    const sortedRight = mergeSort(rightHalf);

    return merge(sortedLeft, sortedRight);
}


function merge(leftArray, rightArray) {

    const mergedArray = [];
    let leftIndex = 0;
    let rightIndex = 0;

    // Merge the two sorted arrays 
    if (leftIndex < leftArray.length && rightIndex < rightArray.length) {

        if (leftArray[leftIndex] <= rightArray[rightIndex]) {
            mergedArray.push(leftArray[leftIndex]);
            leftIndex++;
        }
        else {
            mergedArray.push(rightArray[rightIndex]);
            rightIndex++;
        }

    }

    // if there are any remaining elements in either of the array
    return mergedArray.concat(leftArray.slice(leftIndex)).concat(rightArray.slice(rightIndex));

}



// Example usage
const myArray = [170, 45, 75, 90, 802, 24, 2, 66];
console.log("ORIGINAL ARRAY", myArray);

let sortedArr = mergeSort(myArray);
console.log("SORTED ARRAY", sortedArr); //2, 24,  45,  66, 75, 90, 170, 802