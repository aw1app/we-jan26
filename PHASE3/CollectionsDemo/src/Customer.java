public class Customer {

    public String name = "Mohan";
    //properties
    int customerId;
    int phoneNum;

    String PANCardNo;

    private double AADHARCardNo;

    private double creditCardNo;

    public final int x=100;

    public int balance;

    // constructor
    // deafult contructor
    public Customer() {
    }

    public Customer(int cId, String name, int phoneNum) {
        this.customerId = cId;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public Customer(int cId, String name, int phoneNum,String PANCardNo ) {
        this(cId, name, phoneNum);
        this.PANCardNo = PANCardNo;
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
            System.out.println(" Invalid Phone Number  : " + newPhoneNum);
        else
            this.phoneNum = newPhoneNum;
    }

    void applyLoan(int amount) {
    }


    public void bookFD(int amount, int noOfYears)  {

            System.out.println(" FD booked ");

    }

    public final void methodA() {
        System.out.println("Inside methodA of Customer class");
    }

    public void sendNewYearGreeting(String message){
        System.out.println(this.name + ", " + message );
    };

    public String toString() {
        return "Customer Details ID: " + this.customerId + ", NAME:" + name + ", PHONE:" + phoneNum ;
    }
}
