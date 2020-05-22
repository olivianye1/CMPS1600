/*
Name: Olivia Nye 
Date: 04/05/2019
Class: CMPS 1600 Spring 2019
Lab 5: First C++ program, BankAccount with inheritence and manual checking 

BankAccount.h is the header file for the cpp that constructs BankAccount and defines BankAccount functions getBalance, getName, deposit, withdraw, and toString
*/

#ifndef BankAccount_H
#define BankAccount_H
#include <iostream>
#include <string>

using namespace std;

//BankAccount class declaration
class BankAccount{
public:
  //declare BankAccount constructor variables
  string name;
  double balance;

public: 
  //constructor
  BankAccount(string n, double b);
  //function returns the string value of the name variable of BankAccount object
  string getName();
  //function returns the double value of the balance variable of BankAccount object
  double getBalance();
  //function adds the amount specified as an argument to the balance of BankAccount 
  void deposit(double amount);
  //function subtracts the amount specified as an argument to the balance of BankAccount 
  void withdraw(double amount);
  //function prints bank account name and balance in a nice string format
  void toString();
};
#endif