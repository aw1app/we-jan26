
public class DataTypeDemo {

	public static void main(String[] args) {
		byte b1 = 45;
		
		short sh1 = 15677;
		
		char ch1 = 'h';
		char ch2 = 'i';
		
		int i1= 45454687;
		
		long l1 = 34364653462364364L;
		
		float f1 = 567.12f;
		
		// error because float cannot store this big number
		//float f2 = 56545454555555666666655555555999999999999999999999995557.12f; 
		// we can by using double data type
		double f2 = 56545454555555666666655555555999999999999999999999995557.12d;
		
		
		System.out.println("f1 = " + f1);
		System.out.println("f2 = " + f2);
		System.out.println("End of program");

	}

}
