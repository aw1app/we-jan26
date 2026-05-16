package demos.demoes1;

import package2.classS;

public class StaticKeywordDemo {

    public static void main(String[] args) {
//        classS s1 = new classS();
//        System.out.println(" value of y od s1 object : "+ s1.y );

        // static variables can be accessed using class name. No need to create object first.
        System.out.println(" value of y  : "+ classS.y );

        // static methods  can be invoked using class name. No need to create object first.
        classS.methodX();

    }
}
