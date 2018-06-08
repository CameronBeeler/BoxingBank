package com.cambeeler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Bank bank = Bank.createNewBank("First Federal Bank");

    public static void main(String[] args) {
        //Add branches
        //find branches
        //find customers
        //find branches from customers
        //find customers in branches
        //Add customers and inserrt into branches

        //Add customers
        //Add transactions
        //Add a display of options


        BankOpenForBusiness();


    }

    public static void BankOpenForBusiness() {
        boolean OpenForBusiness = true;
        int option = 0;

        while (OpenForBusiness) {
            displayBankOptions();
            try {
                option = scan.nextInt();
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                OpenForBusiness = false;
                break;
            }

            switch (option) {
                case 1:
                    addANewBranchToTheBank();
                    break;

                case 2:
                    displayAllBranchList();
                    break;

                case 3:
                    MakeSomeBranchChanges();
                    break;

                case 4:
                    break;

                case 5:
                    displayCustomerOptions();
                    break;

                case 6:
                    displayBankOptions();
                    break;

                default:
                    OpenForBusiness = false;
                    break;

            }
            System.out.println("\n");
        }
    }

    public static void displayBankOptions() {

        System.out.println("Option #1 - Add a Branch");
        System.out.println("Option #2 - List Branches");
        System.out.println("Option #3 - List Branch Options");
        System.out.println("Option #4 - List Customers");
        System.out.println("Option #5 - List Customer Options");
        System.out.println("Option #6 - re-display Bank options");
        System.out.println("All other entries exit the Bank Options");
    }

    public static void addANewBranchToTheBank()

    {
        ArrayList<Branch> branches = bank.getBranches();
        System.out.print("What is the Name of this Branch?: ");
        String branchName = scan.nextLine();
        bank.AddANewBranch((branches.size()+1), branchName);
        System.out.println("Now there are " + branches.size() + " Branches");
    }

    public static void MakeSomeBranchChanges()
    {
        int option = 0;
        boolean stillMakingBranchChanges = true;

        while(stillMakingBranchChanges)
        {
            displayBranchOptions();
            try
            {
                option = scan.nextInt();
                scan.nextLine();

            }
            catch (IllegalArgumentException e)
            {
                stillMakingBranchChanges = false;
                break;
            }

            switch (option)
            {
                case 1:
                    displayAllBranchCustomers();

                    break;

                case 2:
                    //SearchTheListForACustomer();
                    break;

                case 3:
                  //  ListACustomersTransactions();
                    break;

                case 4:
                    addACustomerToThisBranch(1);
                    break;

                case 5:
                    displayBranchOptions();
                    break;


                default:
                    stillMakingBranchChanges = false;
                    break;

            }

        }
    }

    public static void displayBranchOptions()
    {
        System.out.println("Option #1 - List Customers");
        System.out.println("Option #2 - Find A Customer");
        System.out.println("Option #3 - List A Customers' Transactions");
        System.out.println("Option #4 - Add a Branch Customer");
        System.out.println("Option #5 - re-display Branch options");
        System.out.println("All other entries exit the Branch Options");

    }

    public static void addACustomerToThisBranch(Integer BranchID)
    {

    }

    public static void displayAllBranchCustomers()
    {
        boolean stillListingCustomers = true;

        while(stillListingCustomers)
        {
            // print a list of all branches
            // choose a branch
            // print out all customers of that branch

            displayAllBranchList();

            stillListingCustomers = false;
        }
    }

    public static void displayAllBranchList()
    {
        ArrayList<Branch> branches = bank.getBranches();
        for(int id=0;id< branches.size();id++)
        {
            System.out.println("Branch ID: "
                    + branches.get(id).getBranchID()
                    + " - Branch Name: " + branches.get(id).getBranchName());
        }
    }

    public static void displayCustomerOptions()
    {

    }


}
