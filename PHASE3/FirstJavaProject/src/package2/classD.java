package package2;

import package1.classA;

public class classD {

	String name;
	int age;

	public void methodD1() {

		classA ca1 = new classA();

		System.out.println(ca1.x1);

		// try accessing x2 which had default access specifier.
		//System.out.println(ca1.x2);
		
		// System.out.println(ca1.x3); // protected stuff is not available in other packages
		
		//System.out.println(ca1.x4);

	}

}
