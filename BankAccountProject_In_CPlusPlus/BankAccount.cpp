/*
Name: Olivia Nye 
Date: 04/05/2019
Class: CMPS 1600 Spring 2019
Lab 5: First C++ program, BankAccount with inheritence and manual checking 

BankAccount.cpp constructs BankAccount and defines BankAccount functions getBalance, getName, deposit, withdraw, and toString
*/

#include <iostream>
#include <string>
#include "BankAccount.h"

using namespace std;

//bank account constructor
BankAccount::BankAccount(string n, double b){
    name = n;
    balance = b;
  }

  //function returns the string value of the name variable of BankAccount object
  string BankAccount::getName(){
    return name;
  }

  //function returns the double value of the balance variable of BankAccount object
  double BankAccount::getBalance(){
    return balance;
  }
 //function adds the amount specified as an argument to the balance of BankAccount 
  void BankAccount::deposit(double amount){
    balance = balance + amount;
  }
  //function subtracts the amount specified as an argument to the balance of BankAccount 
  void BankAccount::withdraw(double amount){
    balance = balance - amount;
  }
 
  //function prints bank account name and balance in a nice string format
  void BankAccount::toString(){
    cout<< "The name on the account is: " << getName() << ".\nThe balance of this account is: $"  << getBalance() << ".\n";
  }
    


