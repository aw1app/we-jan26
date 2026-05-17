package demos;

import package2.Customer;
import package2.VIPCustomer;

public class BankMain {

    public static void main(String[] args) {
        Customer cust1 = new Customer();
        cust1.name = "Mohan";

        System.out.println(" name of cust 1 : "+ cust1.name );

       // cust1.phoneNum = 900000234; // compilation error "phoneNum is not public in package2.Customer; cannot be accessed from outside package"

        Customer cust2 = new Customer(123,"Susan",16001234);
        System.out.println(" name of cust 2 : "+ cust2.name );
       // System.out.println(" ID of cust 2 : "+ cust2.customerId );
       // System.out.println(" phone of cust 2 : "+ cust2.phoneNum );

        System.out.println(" ID of cust 2 : "+ cust2.getCustomerId() );

        System.out.println(" Phone of cust 2 : "+ cust2.getPhoneNum() );
        cust2.setPhoneNum(555);
        System.out.println(" Phone of cust 2 : "+ cust2.getPhoneNum() );

        // Cust 3
        System.out.println("\n ----- : ");
        Customer cust3 = new Customer(124,"Raj",160455234, "AAADWX7865");
        System.out.println(" ID of cust3 : "+ cust3.getCustomerId() );


        // VIP customer 1
        System.out.println("\n ----- : ");
        VIPCustomer vipCust1 = new VIPCustomer(129,"Suba",1601234);
        System.out.println(" ID of vip cust 1 : "+ vipCust1.getCustomerId() );


        // Book a FD for 1 or some other amount
        int fDAmt = 1;
        System.out.println(" Trying to book FD for  "+ fDAmt);
        try {
            cust3.bookFD(fDAmt);
        }catch(exceptions.FDNotBookableException ex){
            System.out.println(" Hey some thing went wrong! contact customer care " + ex.getMessage());
        }

    }

}
