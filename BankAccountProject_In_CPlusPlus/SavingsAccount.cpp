/*
Name: Olivia Nye 
Date: 04/05/2019
Class: CMPS 1600 Spring 2019
Lab 5: First C++ program, BankAccount with inheritence and manual checking 

SavingsAccount.cpp  constructs SavingsAccount as an extension of BankAccount and defines SavingsAccount function addInterest
*/

#include "SavingsAccount.h"
#include <iostream>
#include <string>

using namespace std;

//SavingsAccount constructor + extension of BankAccount
SavingsAccount:: SavingsAccount(string n, double b, double i) : BankAccount(n, b){
  interestRate = i;

}

//function calculates the amount of interest earned for the balance of the SavingsAccount depending on the value of the interestRate specified in the constructor and adds the interest to the balance by depositing it with the inherited deposit function from super class BankAccount
void SavingsAccount::addInterest(){
  double interest;
  interest = getBalance() * interestRate;
  deposit(interest);
}