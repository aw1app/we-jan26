package package1;

public class classB {
	
	String name;
	int age;
	
	
	public void methodB1() {
		
		classA ca1 = new classA();
		
		System.out.println(ca1.x1);
		
		
		// try accessing x2 which had default access specifier.
		System.out.println(ca1.x2);
		
		
		System.out.println(ca1.x3);
	}
	

}
