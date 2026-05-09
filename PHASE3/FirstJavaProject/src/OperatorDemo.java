
public class OperatorDemo {

	/*
	 * This is a multi-line comment that can be used to provide detailed
	 * explanations for a block of code
	 */

	public static void main(String[] args) {
		// declaring two variables to demo XOR
		int x1 = 5;
		int x2 = 7;

		System.out.println("x1 = " + x1);
		System.out.println("x2 = " + x2);
		System.out.println("x1 exclusive OR x2 = " + (x1 ^ x2));

		System.out.println("End of program");

	}

	/**
	 * This method adds two numbers and returns the result.
	 * 
	 * @param a the first number to be added
	 * @param b the second number to be added
	 * @return the sum of a and b
	 */
	public int add(int a, int b) {
		return a + b;
	}

}
