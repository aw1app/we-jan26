import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class BankMain {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //mainArrayListDemo();
       // setDemo();

        mapDemo();

        scanner.close();
    }

    public static void mapDemo() {
        System.out.println(" -- Map Demo -- ");
        Map<Integer, Customer> customerIdMap = new HashMap<>();

        Customer cust1 = new Customer();
        cust1.name = "Mohan";
        cust1.setPhoneNum(90000);
        cust1.customerId=122;

        // Add the mapping id,customer obj
        customerIdMap.put(cust1.customerId, cust1);

        // Add another 2 mappings
        Customer cust2 = new Customer(123, "Susan", 90005);
        Customer cust3 = new Customer(124, "Raj", 80000, "AAADWX7865");

        customerIdMap.put(cust2.customerId, cust2);
        customerIdMap.put(cust3.customerId, cust3);

        // Maps are extremely fast for retrieval/ search ops
        // Take the id input from app user. We will print complete details the customer if found.
        System.out.println("ENTER THE ID OF CUSTOMER YOU WANT THE DETAILS :");
        Integer id = scanner.nextInt();

        Customer customer = customerIdMap.get(id);
        if(customer!= null){
            System.out.println(" Found customer with id  " + id );
            System.out.println(customer); // customer.toString() will get called
        }else{
            System.out.println(" Customer with id  " + id  + " not found!");
        };
    }

    public static void setDemo() {
        System.out.println(" -- Set Demo -- ");
        Set<Customer> customers = new HashSet<>();

        Customer cust1 = new Customer();
        cust1.name = "Mohan";
        cust1.setPhoneNum(90000);
        cust1.customerId=122;

        customers.add(cust1);

        Customer cust2 = new Customer(123, "Susan", 90005);

        Customer cust3 = new Customer(124, "Raj", 80000, "AAADWX7865");

        customers.add(cust2);
        customers.add(cust3);

        // Looping through all customers and greeting them  collectively
        // Index based access is not available for Set. So code below will not work.
//        for (int i = 0; i < customers.size(); i++) {
//            customers.get(i).sendNewYearGreeting("Wish you a happy new year !!");
//        };

        // Simplified for loop
        System.out.println(" -- Looping using Simplified for loop -- ");
        for (Customer cust: customers){
            cust.sendNewYearGreeting("Wish you a happy new year !!");
        }

        // TASK-1: Try the Stream methods and loop through
        System.out.println(" -- Looping using stream's forEach -- ");
        customers.stream().forEach(
                cust ->  cust.sendNewYearGreeting("Wish you a happy new year !!")
        );

        System.out.println(" -- Looping using shortcut forEach -- ");
        customers.forEach(
                cust ->  cust.sendNewYearGreeting("Wish you a happy new year !!")
        );


        // Stream power
        // Filtering / Searching
        System.out.println(" --customers filtered by customer id >= 123 -- ");
        Set<Customer > customersHavingIdGE123= customers.stream()
                .filter( cust -> cust.customerId >= 123 )
                .collect(Collectors.toSet());

        customersHavingIdGE123.forEach( cust -> System.out.println(cust.name+ "," + cust.customerId));

        //TASK-2: Search if a customer with a particular ID exist. 123, 125

        // Task-3: Sort and print customers according to thier names.

        // Stream limits.
        System.out.println(" -- print only 2 customers using limits -- ");
        Set<Customer > customersSetOf2 = customers.stream()
                .limit(2)
                .collect(Collectors.toSet());

        customersSetOf2.forEach( cust -> System.out.println(cust.name+ "," + cust.customerId));

    }

    public static void mainArrayListDemo() {
        List<Customer> customers = new LinkedList<Customer>();

        Customer cust1 = new Customer();
        cust1.name = "Mohan";
        cust1.setPhoneNum(90000);

        customers.add(cust1);

        Customer cust2 = new Customer(123, "Susan", 90005);

        Customer cust3 = new Customer(124, "Raj", 80000, "AAADWX7865");

        customers.add(cust2);
        customers.add(cust3);

        // Looping through all customers and greeting them them collectively
        for (int i = 0; i < customers.size(); i++) {
            customers.get(i).sendNewYearGreeting("Wish you a happy new year !!");
        }

        // Unsorted customers
        System.out.println(" Customer Name, Phone ");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).name + ", " + customers.get(i).getPhoneNum());
        }

        // Sort the customers accd to thier Phone.
        System.out.println(" Customer Name, Phone after sorting ");
        customers.sort((c1, c2) -> (c1.phoneNum - c2.phoneNum));
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).name + ", " + customers.get(i).getPhoneNum());
        }

        // Simplified for loop
        for (Customer cust: customers){
            cust.sendNewYearGreeting("Wish you a happy new year !!");
        }

        // Searching for customer by ID;
        Customer cust4 = new Customer(125, "Megha", 85000, "AAADWX7555");
        boolean hasCust = customers.contains(cust4);
        System.out.println("cust4 is in the customers collection : " + hasCust);

        // Streaming Solution. Find customer by thier customer Id
        Customer custFound = customers.stream().filter(cust -> cust.getCustomerId() != 125).toList().getFirst();

        if (custFound != null)
            System.out.println("cust4 is in the customers collection with id : " + custFound.getCustomerId());

    }


    public static void mainArrayDemo(String[] args) {

        Customer cust1 = new Customer();
        cust1.name = "Mohan";

        Customer cust2 = new Customer(123, "Susan", 16001234);

        Customer cust3 = new Customer(124, "Raj", 160455234, "AAADWX7865");

        //VIPCustomer vipCust1 = new VIPCustomer(129,"Suba",1601234);


        Customer[] customers = new Customer[3];

        customers[0] = cust1;
        customers[1] = cust2;
        customers[2] = cust3;
        //customers[3] = vipCust1;

        for (int i = 0; i < customers.length; i++) {
            customers[i].sendNewYearGreeting("Wish you a happy new year !!");
        }


    }
}
