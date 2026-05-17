import java.util.*;

public class BankMain {

    public static void main(String[] args) {
        mainArrayListDemo();
    }

    public static void mainArrayListDemo() {
        List<Customer> customers= new ArrayList<Customer>();

        Customer cust1 = new Customer();
        cust1.name = "Mohan";
        cust1.setPhoneNum(90000);

        customers.add(cust1);

        Customer cust2 = new Customer(123,"Susan",90005);

        Customer cust3 = new Customer(124,"Raj",80000, "AAADWX7865");

        customers.add(cust2);
        customers.add(cust3);

        // Looping through all customers and greeting them them collectively
        for( int i = 0 ; i < customers.size(); i++ ){
            customers.get(i). sendNewYearGreeting("Wish you a happy new year !!");
        }

        // Unsorted customers
        System.out.println(" Customer Name, Phone " );
        for( int i = 0 ; i < customers.size(); i++ ){
            System.out.println(customers.get(i).name + ", " + customers.get(i).getPhoneNum());
        }

        // Sort the customers accd to thier Phone.
        System.out.println(" Customer Name, Phone after sorting " );
        customers.sort( (c1, c2 ) -> ( c1.phoneNum -  c2.phoneNum ) );
        for( int i = 0 ; i < customers.size(); i++ ){
            System.out.println(customers.get(i).name + ", " + customers.get(i).getPhoneNum());
        }


        // Searching for customer by ID;
        Customer cust4 = new Customer(125,"Megha",85000, "AAADWX7555");
        boolean hasCust = customers.contains(cust4);
        System.out.println("cust4 is in the customers collection : "+ hasCust );

        // Streaming Solution. Find customer by thier customer Id
        Customer custFound = customers.stream().filter( cust -> cust.getCustomerId() != 125).toList().getFirst();

        if (custFound != null )
            System.out.println("cust4 is in the customers collection with id : "+ custFound.getCustomerId() );

    }

    public static void mainArrayDemo(String[] args) {

        Customer cust1 = new Customer();
        cust1.name = "Mohan";

        Customer cust2 = new Customer(123,"Susan",16001234);

        Customer cust3 = new Customer(124,"Raj",160455234, "AAADWX7865");

        //VIPCustomer vipCust1 = new VIPCustomer(129,"Suba",1601234);


        Customer[] customers= new Customer[3];

        customers[0] = cust1;
        customers[1] = cust2;
        customers[2] = cust3;
        //customers[3] = vipCust1;

        for( int i = 0 ; i < customers.length; i++ ){
            customers[i]. sendNewYearGreeting("Wish you a happy new year !!");
        }


    }
}
