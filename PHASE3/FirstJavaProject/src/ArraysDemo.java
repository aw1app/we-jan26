public class ArraysDemo {

	public static void main(String[] args) {
		// Declare and initialize an integer array with 10 elements
		int[] myArray = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		// Access and print the second element of the array
		System.out.println(myArray[1]);
		System.out.println(myArray);

		// Declare now and fill values later
		// declare an array of integers with a size of 5
		int[] myArray2 = new int[5];

		System.out.println(myArray2[1]); // 0
		System.out.println(myArray2); // object reference

		myArray2[0] = 5;
		myArray2[1] = 55;

		System.out.println(myArray2[1]); // 55

		// System.out.println(myArray2[17]); //?? error
		// System.out.println(myArray2[5]); //?? error

		char[] chArray1 = { 'a', 'x' };
		System.out.println("chArray1 size is " + chArray1.length);

		for (int i = 0; i < chArray1.length; i++)
			System.out.println("chArray1 at index " + i + " has value " + chArray1[i]);

		System.out.println("\n 2d array demo");
		demo2dArray();

	}

	public static void demo2dArray() {

		int[][] numbers = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 0 } };

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + "\t");
			}
			System.out.println("");
		}
		;

		// print 4 from the numbers array. how?
		// when i=0 and j=3
		System.out.print(numbers[0][3]); // 8
	}

	public void method1() {
		System.out.println("hi");
	}
	
	public int method2() {
		System.out.println("hi 2");
		return 25;
	}
	
	public boolean method3() {
		System.out.println("hi 2");
		return false;
	}

}
