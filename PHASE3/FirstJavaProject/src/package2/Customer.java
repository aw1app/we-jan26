package package2;

import exceptions.FDNotBookableException;

public class Customer {

    public String name = "Mohan";
    //properties
    int customerId;
    int phoneNum;

    String PANCardNo;

    private double AADHARCardNo;

    private double creditCardNo;

    public final int x=100;

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


    public void bookFD(int amount, int noOfYears) throws FDNotBookableException {
        if(amount<10) {
            System.out.println(" Got an FD booking amt of 10 ");
            throw new FDNotBookableException(" Cannot book FD for less than amount of USD/INR 10");
        }
        else if( noOfYears > 10) {
            System.out.println(" Got an FD booking for more than 10 years  ");
            throw new FDNotBookableException(" Cannot book FD for more than 10 years ");
        }else{
            System.out.println(" FD booked ");
        }
    }

    public final void methodA() {
        System.out.println("Inside methodA of Customer class");
    }


}
