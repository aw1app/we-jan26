package package2;

/* Inheritance demo */
public class VIPCustomer extends Customer{

    // all non private data members of super class Customer are inherited in this class.

    public VIPCustomer() {
        super();
    }

    public VIPCustomer(int cId, String name, int phoneNum) {
        super(cId,name,phoneNum);
    }

// all non private methods of super class Customer are also inherited in this class.

// method overriding
@Override
public int getCustomerId() {
    return 100000+this.customerId;
}

    // method overriding
    // error : "methodA() in package2.VIPCustomer cannot override methodA() in package2.Customer
    //  overridden method is final"
//    public void methodA() {
//        System.out.println("Inside methodA of VIPCustomer class");
//    }

}
