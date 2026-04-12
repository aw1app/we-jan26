function bubbleSort(arr) {
    let n = arr.length;

    for (i = 0; i < n ; i++) {

        for (j = 0; j < n - i; j++) {

            if (arr[j] > arr[j + 1])
               [ arr[j], arr[j + 1] ] = [ arr[j + 1], arr[j] ]; // swapping
        }

    }
}


// Example usage
const myArray = [170, 45, 75, 90, 802, 24, 2, 66];
console.log("ORIGINAL ARRAY" , myArray);

bubbleSort(myArray);
console.log("SORTED ARRAY" , myArray); //2, 24,  45,  66, 75, 90, 170, 802