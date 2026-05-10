package package1;

import package2.Customer;

public class classB {
	
	String name;
	int age;
	
	
	public void methodB1() {
		
		classA ca1 = new classA();
		
		System.out.println(ca1.x1);
		
		
		// try accessing x2 which had default access specifier.
		System.out.println(ca1.x2);
		
		
		System.out.println(ca1.x3);
		
		//System.out.println(ca1.x4); // private syuff is not accessible outside of the class it was declared.
		
		
		Customer customer1 = new Customer();
		
		customer1.name ="sdse3er3er32";
		
	}
	

}
