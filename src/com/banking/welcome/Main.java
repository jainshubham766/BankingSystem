package com.banking.welcome;

import com.banking.application.Account;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main (String [] args) throws Exception
    {
        boolean flag=true;
        HashMap<Long,Account> ht = new HashMap<Long, Account>();
        long accountNumberGenerator = 1232456465761000L;
        try {
            FileInputStream fin =
                    new FileInputStream("AccountData.txt");
            ObjectInputStream oin = new ObjectInputStream(fin);
            int fileSize= oin.readInt();
            for (int i=0;i<fileSize;i++)
            {
                ht.put(accountNumberGenerator,(Account)oin.readObject());
                 accountNumberGenerator++;
            }
            fin.close();
            oin.close();
        }
        catch (Exception e) {

        }

        Scanner sc = new Scanner (System.in);
        while (flag) {
            System.out.println("Welcome To Most Truth-able Bank\n" +
                    "\nPlease select the Appropriate option below: " +
                    "\n1. New User+ " +
                    "\n2. Sign In " +
                    "\n3. Delete Account" +
                    "\n4. Admin Login" +
                    "\n5. Exit");

            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("-------Account Opening Form-------");
                        System.out.print("Applicant Name: ");
                        String name = sc.next();
                        System.out.print("Applicant Address: ");
                        String address = sc.next();
                        System.out.print("Applicant Contact Number: ");
                        long contact = sc.nextLong();
                        System.out.println("Applicant Date Of Birth Details");
                        System.out.print("Day : ");                                     // Add constraits for correct dates
                        byte day = sc.nextByte();
                        System.out.print("Month : ");
                        short month = sc.nextShort();
                        System.out.print("Year : ");
                        short year = sc.nextShort();
                        System.out.print("Depositing Amount = $");                           // Add constraits for correct values
                        double amount = sc.nextInt();
                        long accountNumber = accountNumberGenerator++;
                        Account account = new Account(name, contact, amount, address, month, day, year);
                        System.out.println("Your Account has successfully opened.\nPlease Note Your ACCOUNT NUMBER: " + accountNumber + "\nBank IFSC Code: " + Account.IFSCcode);

                        ht.put(accountNumber, account);

                        break;
                    case 2:
                        System.out.print("Please enter ACCOUNT NUMBER: ");
                        long accNoToVerify = sc.nextLong();
                        Account acc = (Account) ht.get(accNoToVerify);
                        if (acc != null) {
                            System.out.println("\"Fetched Account Details For Account NUMBER: " + accNoToVerify + " \"");
                            System.out.println(acc);
                        } else {
                            System.out.println("Invalid Account Number Entered. \nTRY AGAIN");
                        }

                        break;

                    case 3:
                        System.out.println("Acccount Closing Form \nPlease Enter Account Number to Close Account:");
                        long accNoToClose = sc.nextLong();
                        Account acc1 = (Account) ht.get(accNoToClose);
                        if (acc1 != null) {
                            ht.remove(accNoToClose);
                            System.out.println("\"Account Deleted : " + accNoToClose + " \"");
                        } else {
                            System.out.println("Invalid Account Number Entered. \nTRY AGAIN");
                        }
                        break;

                    case 4:
                        System.out.println(ht);
                        break;

                    case 5:
                        FileOutputStream fout = new FileOutputStream("AccountData.txt");
                        ObjectOutputStream oout = new ObjectOutputStream(fout);
                        for (Account a : ht.values()) {
                            oout.writeObject(a);
                        }
                        fout.close();
                        oout.close();
                        flag = false;
                        break;

                }

            } else {
                System.out.println("Please Enter the Correct Option Number. Try Again! ");

            }
        }

    }
}
