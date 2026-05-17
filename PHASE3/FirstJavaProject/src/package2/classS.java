package package2;

public class classS {

   public static int x=100;
   public  int y=200;

   public  void methodA(){
      System.out.println("Inside methodA() of class classS " + x +", " + y);
   }

   public static void methodB() {
      // javac error : non-static variable y cannot be referenced from a static context
      // System.out.println("Inside methodB() of class classS " + x + ", " + y);

      // This would be fine.
      System.out.println("Inside methodB() of class classS " + x);
   }

}
