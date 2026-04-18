function radixSort(arr) {

    const result = [...arr];
    const radixArray = Array.from({ length: 10 }, () => []); // 10 arrays 

    const maxVal = Math.max(...result);
    let exp = 1; // exp is exponent - 1 , 10, 100


    while (Math.floor(maxVal / exp) > 0) {

        // Distribute numbers to buckets
        for (let i = result.length - 1; i >= 0; i--) {
            const val = result[i];
            const radixIndex = Math.floor((val / exp) % 10); // 4
            // console.log(val, radixIndex );
            radixArray[radixIndex].push(val);
        }

        // Collection back into an array
        result.length = 0; // clear the array to avoid creating extra space

        // Collect numbers from buckets
        for (const bucket of radixArray) {
            while (bucket.length > 0) {
                result.push(bucket.pop());
            }
        }

        //console.log("----");

        exp *= 10;
    }

    return result;

}

//
const myArray = [170, 45, 75, 90, 802, 24, 2, 66];
console.log("ORIGINAL ARRAY", myArray);

let result = radixSort(myArray);
console.log("SORTED ARRAY", result);
