package demos.demoes1;

public class MethodsDemo {

	public static void main(String[] args) {
		MethodsDemo md1 = new MethodsDemo();
		
		md1.add(5,4.5f); // 10.5? 11.5? 12.5?
		System.out.println(md1.add(5,4.5f));
		
	}

	
	/// Overloaded methods
	public int add(int num1, int num2) {
		return num1 + num2 + 1;
	}

	public float add(int num1, float num2) {
		return num1 + num2 + 2;
	}

	public float add(float num1, int num2) {
		return num1 + num2 +3;
	}

}
