package com.cambeeler;

import java.util.ArrayList;
import java.util.Scanner;

public class Branch {
    private Scanner scan = new Scanner(System.in);
    private static int branchCount = 0;
    //  Is part of a Bank
// has lists of customers
// has financial transactions, that belong to customers
// Branch functions include:
//      Can list its own Customers
//      Can create new customers for itself
//      Can list transactions it is responsible for
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private Integer branchID;
    private String branchName;

// CONSTRUCTORS, GETTERS, SETTERS

    private Branch(Integer branchID, String branchName) {
        this.branchID = branchID;
        this.branchName = branchName;
        branchCount++;
    }

    private Branch(Integer branchID, String branchName, String customerName) {
        this.branchID = branchID;
        this.branchName = branchName;
        Customer customer = Customer.createNewCustomer(customerName, this.branchID);
        this.customerList.add(customer);
        branchCount++;
    }


    public Integer getBranchID() {
        return branchID;
    }

    public String getBranchName() {
        return branchName;
    }


    // METHODS, PARTICULARLY FOR ADDING Customers, REMOVING AND LISTING TRANSACTIONS FOR THE RESPECTIVE CUSTOMER
    public int AddCustomers() {
        String customerName;
        int newCustomers = 0;
        boolean stillAddingCustomers = true;


        while (stillAddingCustomers) {
            System.out.print("(exit to end) - Please add customers full name here:  ");
            customerName = scan.nextLine();

            if (customerName == "exit") {
                stillAddingCustomers = false;
                break;
            }
            customerList.add(Customer.createNewCustomer(customerName, this.branchID));
            newCustomers++;
        }

        return newCustomers;
    }

    public void listAllBranchActiveCustomers()
    {
        for(int activeIndex=0; activeIndex < customerList.size(); activeIndex++)
        {
            if(customerList.get(activeIndex).getActive()==true)
            {
                System.out.println("Customer Index#: "
                        + activeIndex + ", Customer Name: "
                        + customerList.get(activeIndex).getFullName());
            }
        }

    }

    public void listAllBranchInactiveCustomers()
    {
        for(int inActiveIndex=0; inActiveIndex < customerList.size(); inActiveIndex++)
        {
            if(customerList.get(inActiveIndex).getActive()==false)
            {
                System.out.println("Customer Index#: "
                        + inActiveIndex + ", Customer Name: "
                        + customerList.get(inActiveIndex).getFullName());
            }
        }

    }

    public void listAllBranchCustomers()
    {
        for(int allIndexes=0; allIndexes < customerList.size(); allIndexes++)
        {

            System.out.println("Customer Index#: "
                    + allIndexes + ", Customer Name: "
                    + customerList.get(allIndexes).getFullName());

        }

    }


// FACTORY METHODS - IN PRINCIPLE

    public static Branch AddAnotherBranch(Integer branchID, String branchName)
    {
        return new Branch( branchID,  branchName);
    }

    public static Branch AddABranchAndANewCustomer(Integer branchID, String branchName, String customerName)
    {
        return new Branch( branchID,  branchName, customerName);

    }
}
