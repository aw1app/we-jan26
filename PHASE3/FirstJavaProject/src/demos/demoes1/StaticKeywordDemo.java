package demos.demoes1;

import package2.classS;

public class StaticKeywordDemo {

    public static void main(String[] args) {
        // Normally to access any data member, we create an object first.
//        classS s1 = new classS();
//        System.out.println(" value of x od s1 object : "+ s1.x );

        // static variables can be accessed using class name. No need to create object first.
        System.out.println(" value of x  : " + classS.x);
        //System.out.println(" value of x  : " + classS.y);

        // static methods  can be invoked using class name. No need to create object first.
        classS.methodB();

//        classS s1 = new classS();
//        s1.methodA();

    }
}
