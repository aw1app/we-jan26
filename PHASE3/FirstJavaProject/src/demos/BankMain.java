package demos;

import package2.Customer;

public class BankMain {

    public static void main(String[] args) {
//        Customer cust1 = new Customer();
//        cust1.name = "Mohan";
//
//        System.out.println(" name of cust 1 : "+ cust1.name );

       // cust1.phoneNum = 900000234; // compilation error "phoneNum is not public in package2.Customer; cannot be accessed from outside package"

        Customer cust2 = new Customer(123,"Susan",16001234);
        System.out.println(" name of cust 2 : "+ cust2.name );
       // System.out.println(" ID of cust 2 : "+ cust2.customerId );
       // System.out.println(" phone of cust 2 : "+ cust2.phoneNum );

        System.out.println(" ID of cust 2 : "+ cust2.getCustomerId() );

        System.out.println(" Phone of cust 2 : "+ cust2.getPhoneNum() );
        cust2.setPhoneNum(555);
        System.out.println(" Phone of cust 2 : "+ cust2.getPhoneNum() );

    }

}
