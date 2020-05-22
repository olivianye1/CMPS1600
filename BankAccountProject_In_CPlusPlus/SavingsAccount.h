/*
Name: Olivia Nye 
Date: 04/05/2019
Class: CMPS 1600 Spring 2019
Lab 5: First C++ program, BankAccount with inheritence and manual checking 

SavingsAccount.h is the header file for the cpp that constructs SavingsAccount as an extension of BankAccount and defines SavingsAccount function addInterest
*/
#ifndef SavingsAccount_H
#define SavingsAccount_H
#include "BankAccount.h"
#include <iostream>
#include <string>

//declares class SavingsAccount as an extension of parent class BankAccount
class SavingsAccount : public BankAccount{

public:
  //constructor
  SavingsAccount(string n, double b, double i);
  //function calculates the amount of interest earned for the balance of the SavingsAccount depending on the value of the interestRate specified in the constructor and adds the interest to the balance by depositing it with the inherited deposit function from super class BankAccount
  void addInterest();
private:
  //double variable represents the percent of the account balance in the SavingsAccount that will be added to the balance as interest with the the addInterest function
  double interestRate;

};
#endif