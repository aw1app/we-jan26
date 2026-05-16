package package2;

public class Customer {

    public String name = "Mohan";
    //properties
    int customerId;
    int phoneNum;

    String PANCardNo;

    private double AADHARCardNo;

    private double creditCardNo;


    // constructor
    public Customer(int cId, String name, int phoneNum) {
        this.customerId = cId;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    // methods
    public int getCustomerId() {
        return this.customerId;
    }

    public int getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(int newPhoneNum) {
        // some logic here
        if (newPhoneNum < 1000)
            System.out.println(" Invalid Phone Number  : "+ newPhoneNum);
        else
        this.phoneNum = newPhoneNum;
    }

    void applyLoan(int amount) {
    }



    void bookFD(int amount) {
    }

}
