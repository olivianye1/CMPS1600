/*
Name: Olivia Nye 
Date: 04/05/2019
Class: CMPS 1600 Spring 2019
Lab 5: First C++ program, BankAccount with inheritence and manual checking 

CheckingAccount.cpp constructs CheckingAccount as an extension of BankAccountand defines CheckingAccount functions deductFees, deposit(overrides from BankAccount), and withdraw (overrides from BankAccount)
*/

//#include "BankAccount.h"
#include "CheckingAccount.h"
#include <iostream>
#include <string>

using namespace std;


//set value of const variable TRANSACTION_FEE to 3.0
const double CheckingAccount:: TRANSACTION_FEE = 3.0;


//CheckingAccount constructor + extension of BankAccount
CheckingAccount:: CheckingAccount(string n, double b): BankAccount(n,b){
  //initialize value of transactionCount, which keeps track of the number of withdrawals and deposits done on a CheckingAccount object, to 0
  transactionCount = 0;

}

//function subtracts the fees for all the transactions that have occurred and resets the value of transactionCount to 0
void CheckingAccount::deductFees(){
  //deducts fees from balance
  balance = balance - (TRANSACTION_FEE * transactionCount);
  //resets transaction counter
  transactionCount = 0;
}

//function overrides BankAccount deposit function. Is the same as the BankAccount function except that it also adds 1 to the transaction account to indicate that a transaction has occured
void CheckingAccount::deposit(double amount){
  //calls the deposit function from BankAccount
  BankAccount::deposit(amount);
  //counts the transaction
  transactionCount = transactionCount + 1;
}

//function overrides BankAccount withdraw function. Is the same as the BankAccount function except that it also adds 1 to the transaction account to indicate that a transaction has occured
void CheckingAccount::withdraw(double amount){
  //calls the withdraw function from BankAccount
  BankAccount::withdraw(amount);
  //counts the transaction
  transactionCount = transactionCount + 1;
}

