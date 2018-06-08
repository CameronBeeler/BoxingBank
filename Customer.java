package com.cambeeler;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer
{
    private ArrayList<Double> transactions = new ArrayList<Double>();
    private String fullName;
    private Integer branchID;
    private boolean active;
    private Scanner scan = new Scanner(System.in);

// CONSTRUCTORS, GETTERS, SETTERS
    private Customer(String fullName, Integer branchID)
    {
        this.fullName = fullName;
        this.branchID = branchID;
        this.active = true;
    }

    public String getFullName()
    {
        return this.fullName;
    }

    public ArrayList<Double> getTransactions()
    {
        return this.transactions;
    }

    public boolean getActive()
    {
        return this.active;
    }

    public void setInactive()
    {
        this.active = false;
    }


// METHODS, PARTICULARLY FOR ADDING, REMOVING AND LISTING TRANSACTIONS FOR THE RESPECTIVE CUSTOMER
    public boolean AddTransactionToAccount(Double transaction)
    {

        if(this.transactions.add(transaction)){
            System.out.println("Failed to add transaction: " + transaction);
            return false;
        }
        System.out.println("Successfully added Transaction: " + transaction);
        return true;
    }

    public Double deleteTransactionsFromAccount(int transactionID)
    {
// Transaction ID is the transaction index in the ArrayList
        Double dbl = 0.0;
        String answer = "None of the Above";
        if(transactionID < 0 || transactionID >= transactions.size())
        {
            System.out.println("The transaction is not in this collection - IOOBE");
            return dbl;
        }

        System.out.println("TransactionID: "+ transactionID + " is for transaction (" + transactions.get(transactionID));
        System.out.print("Is this the correct transaction to delete (Y or N)?:  ");

        while(answer != "Y" && answer !="N")
        {
            answer = scan.nextLine();
            if (answer != "Y" && answer !="N")
            {
                System.out.println("Your answer needs to be ONLY Y or N.  Please try again:  ");
            }
        }
        try
        {
            System.out.println("Customer::deleteTransactionsFromAccount - Need to finish this coding");
            return(transactions.remove(transactionID));
        }
            catch (IndexOutOfBoundsException IOOBE)
        {
            System.out.println("Transaction " + transactionID + " must be in the range 0 - "+ (transactions.size()-1));
        }
        return dbl;
    }

    public void displayAllTransactionsInTheAccount()
    {
        System.out.println("List of all" + getFullName() +"'s Transactions");
        System.out.println("Tran ID     Amount");
        for(int tranID=0; tranID < transactions.size(); tranID++)
        {
            System.out.println("# " + tranID + "     " + transactions.get(tranID));
        }
    }


// FACTORY METHODS - IN PRINCIPLE
    public static Customer createNewCustomer(String fullName, Integer branchID )
    {
        return new Customer(fullName, branchID);
    }
}
