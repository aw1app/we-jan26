function bubbleSort(arr) {

    for (i = 0; i <= arr.length - 1; i++) {

        for (j = 0; j <= arr.length - 1 - i; j++) {

            if (arr[j] > arr[j + 1])
               [ arr[j], arr[j + 1] ] = [ arr[j + 1], arr[j] ]; // swapping
        }

    }
}


// Example usage
const myArray = [170, 45, 75, 90, 802, 24, 2, 66];
console.log("ORIGINAL ARRAY" , myArray);

bubbleSort(myArray);
console.log("SORTED ARRAY" , myArray);