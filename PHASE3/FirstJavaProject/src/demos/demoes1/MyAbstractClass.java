package demos.demoes1;

abstract public class MyAbstractClass {

    //javac error: missing method body, or declare abstract
    //public void methodA();

    // correct way
    abstract public void methodA();

    public void methodB(){
        System.out.println(" inside methodB() ");
    };

}
