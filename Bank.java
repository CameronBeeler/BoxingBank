package com.cambeeler;

import java.util.ArrayList;

public class Bank
{
//  Knows all of its customer/Branch pairs
//  knows all of its transactions / Branch pairs
//  Can add Customers to Branches and transfer a customer from one branch to another.
//  but what would you do if a customer changes branches and their transaction history remains with one branch,
//  and their new transactions are for another branch?
//  Can Create Branches
//  Can Add customers to ANY branch
//  Can move customers from/to any branch
//  Customer/transactions can only be added/maintained at active branch/customer combinations

    private static int bankCount = 0;
    private int branchID = 1;
    private String branchName;
    private String bankName;
    private ArrayList<Branch> branches = new ArrayList<Branch>();


    // CONSTRUCTORS, GETTERS, SETTERS

    private Bank(String bankName)
    {
        this.branchName = branchName;
        this.bankCount ++;
        branches.add(Branch.AddAnotherBranch(1, "HeadQuarters"));

    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    // METHODS, PARTICULARLY FOR ADDING, REMOVING AND LISTING TRANSACTIONS FOR THE RESPECTIVE CUSTOMER
    public void AddANewBranch(Integer branchID, String branchName)
    {
    //  Verify that the "new branch" is not a duplicate branchID

        if(isThisBranchIDUnique(branchID))
        {
            branches.add(Branch.AddAnotherBranch( branchID,  branchName));
        }

    }

    public boolean isThisBranchIDUnique(Integer branchID)
    {
        for (int index=0; index < branches.size(); index++)
        {
            if(branchID.compareTo(branches.get(index).getBranchID())==0) //if 0 then duplicate ID
            {
                return false;
            }
        }
        return true;
    }

// FACTORY METHODS - IN PRINCIPLE

    public static Bank createNewBank(String bankName )
    {
        if(bankCount == 0)
        {
            return new Bank( bankName);
        }
        else
        {
            System.out.println("You can only create 1 BANK");
        }

        return null;
    }

}
