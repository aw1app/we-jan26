package demos.demoes1;

import package2.Customer;
import package2.VIPCustomer;

public class FinalKeywordDemo {

    public static void main(String[] args) {

        Customer cust2 = new Customer(123,"Susan",16001234);
        System.out.println(" name of cust 2 : "+ cust2.name );

        System.out.println(" x value of cust 2 : "+ cust2.x );

        // cust2.x=200; // compilation error "cannot assign a value to final variable x"
        //System.out.println("after changing:  x value of cust 2 : "+ cust2.x );

// invoke methodA (overridden in VIPCustomer object)
        System.out.println("\n ----- : ");
        VIPCustomer vipCust1 = new VIPCustomer(129,"Suba",1601234);
        vipCust1.methodA();

    }

}
