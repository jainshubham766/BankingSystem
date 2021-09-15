package com.banking.application;

import java.io.Serializable;
import java.time.LocalDate;

public class Account implements Serializable {


    public static final long IFSCcode= 1234567890L;


    public long accountHolderContactNumber;
    public String accountHolderName;
    public double accountBalance;
    public final LocalDate dateOfJoining;
    public String address;
    public final LocalDate dateOfBirth;



    public Account(String accountHolderName, long accountHolderContactNumber,double accountBalance, String address,short dobMonth,byte dobDay, short dobYear) {           //Constructor 1
        this.accountHolderName = accountHolderName;
        this.accountHolderContactNumber= accountHolderContactNumber;
        this.accountBalance = accountBalance;
        this.address = address;
        this.dateOfJoining = LocalDate.now();
        this.dateOfBirth= LocalDate.of(dobYear,dobMonth,dobDay);

    }
    public String toString()
    {
       return ("Applicant Name: "+accountHolderName+"\nApplicant Address: "+address+"\nApplicant Contact Number: "+accountHolderContactNumber+"\nApplicant Date Of Birth Details"+dateOfBirth+"\nBank IFSC Code: "+Account.IFSCcode);
    }
}

