
public class FlowControlDemo {

	public static void main(String[] args) {

		int x = 13;
		int y = 12;

		if (x < y) {
			System.out.println("x is less 		than y");
		}

		// Nested if-else

		int age = 25;
		int weight = 48;

		if (age >= 18) {
			if (weight > 50) {
				System.out.println("You are 	eligible for Boxing championship");

			} else {
				System.out.println("You are not 	eligible for Boxing Championship");

			}
		} else {
			System.out.println("Age must be 	greater than 18");
		}

		// switch case statements
		System.out.println("SWITCH CASE DEMO");
		int number = 200;
		switch (number) {
		// Case statements
		case 100:
			System.out.println("100");
			break;
		case 200:
			System.out.println("200");
			break;
		case 300:
			System.out.println("300");
			break;
		// Default case statement
		default:
			System.out.println("Not in 		100, 200 or 300");
		}

		// ITERATIONS
		System.out.println("ITERATIONS using FOR DEMO");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i * i);
		}

		// WHILE
		System.out.println("ITERATIONS using WHILE DEMO");
		int i = 1;
		while (i <= 10) {
			System.out.println(i * i);
			i++;
			
			if(i>5) break;
		}
		;

		// DO WHILE
		System.out.println("ITERATIONS using DO-WHILE DEMO");
		i = 1;
		do {
			System.out.println(i * i);
			i++;
		} while (i <= 10);

		System.out.println("End of program");

	}

}
