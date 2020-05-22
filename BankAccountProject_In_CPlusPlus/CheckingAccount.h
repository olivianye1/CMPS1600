/*
Name: Olivia Nye 
Date: 04/05/2019
Class: CMPS 1600 Spring 2019
Lab 5: First C++ program, BankAccount with inheritence and manual checking 

CheckingAccount.h is the header file for the cpp that constructs CheckingAccount as an extension of BankAccountand defines CheckingAccount functions deductFees, deposit(overrides from BankAccount), and withdraw (overrides from BankAccount)
*/

#ifndef CheckingAccount_H
#define CheckingAccount_H
#include "BankAccount.h"
#include <iostream>
#include <string>

//creates CheckingAccount class as an extension of BankAccount
class CheckingAccount : public BankAccount{

public:
  //constructor
  CheckingAccount(string n, double b);
  
  //function subtracts the fees for all the transactions that have occurred and resets the value of transactionCount to 0
  void deductFees();
  //function overrides BankAccount deposit function. Is the same as the BankAccount function except that it also adds 1 to the transaction account to indicate that a transaction has occured
  void deposit(double amount);
  //function overrides BankAccount withdraw function. Is the same as the BankAccount function except that it also adds 1 to the transaction account to indicate that a transaction has occured
  void withdraw(double amount);
public:
  //TRANSACTION FEE is a static and final(const in c++ terminology) variable
  static const double TRANSACTION_FEE;
  //int variable keeps count of the number of CheckingAccount transactions
   int transactionCount;

};
#endif