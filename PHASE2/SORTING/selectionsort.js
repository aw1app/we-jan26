function selectionSort(arr) {

    let n = arr.length;

    for (i = 0; i < n; i++) {

        let currMinIndex = i;

        for (j = i + 1; j < n; j++) {

            if (arr[j] < arr[currMinIndex])
                currMinIndex = j;
        }

        [ arr[i], arr[currMinIndex] ] = [ arr[currMinIndex], arr[i] ]; // swapping

    }

}


// Example usage
const myArray = [170, 45, 75, 90, 802, 24, 2, 66];
console.log("ORIGINAL ARRAY", myArray);

selectionSort(myArray);
console.log("SORTED ARRAY", myArray); //2, 24,  45,  66, 75, 90, 170, 802