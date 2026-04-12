function quickSort(arr, low, high) {

    if (low < high) {
        const pivotIndex = partition(arr, low, high);

        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
}

function partition(arr, low, high) {

    const pivot = arr[high];

    let i = low - 1;

    for (j = low; j < high; j++) {

        if (arr[j] < pivot) {
            i++;
            [arr[i], arr[j]] = [arr[j], arr[i]]; // Swap elements 
        }

    }

    [arr[i + 1], arr[high]] = [arr[high], arr[i + 1]]; // Final Swap  

    return i + 1;
}


// Example usage
const myArray = [170, 45, 75, 90, 802, 24, 2, 66];
console.log("ORIGINAL ARRAY", myArray);

quickSort(myArray,0,myArray.length-1);
console.log("SORTED ARRAY", myArray); //2, 24,  45,  66, 75, 90, 170, 802