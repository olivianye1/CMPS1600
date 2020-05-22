/*
Name: Olivia Nye 
Date: 04/09/2019
Class: CMPS 1600 Spring 2019
Project 1: Financial Literacy

This project, coded in C, demonstrates the importance of financial literacy in long term wealth. This project runs 40-year wealth simulations, using core functions debt, house, rent, and savingsPlacement, as well as other functions,  for persons created in a struct. User-friendly interface in main function allows for the execution of simulations for a variety of persons(2 hard-coded, 4 from input files, and unlimited from user input). All simulations output wealth arrays to text files.
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>


//declare constant values for variables with values that will never change in functions and will be accurate regardless of person
const double debtInterestRate = 0.20;
const int mortgageTerm = 30;
const double PMI = .005;


//create person struct type
typedef struct person_struct{
        double savings;
        double checking;
        double debt;
        double loan;
        double yearsWithDebt;
        double yearsRented;
        double debtPaid;

        double savingsInterestRate;
        int debtAdditionalPay;
        bool literacy;
        int rent;
        int housePrice;
        double monthlyLoanPayment;
        bool homeOwner;
        double currentWealth;
        double yearlySalary;
        double downPayment;
        double loanInterestRate;
        double loanPaid;
        double initialLoan;
        double wealth[41];

}person;


//savingsPlacement function takes in pointer person struct and interest. Function calculates the amount of money left in the person's savings after it has grown from interest in one year
void savingsPlacement(person *person , double interestRate){
    person ->savings = person -> savings + (person -> savings * interestRate);
}

//debt function makes monthly payments (the minimum 3% payment plus an additional amount specified by the person) from savings account to pay off credit card debt while updating the values of person's debt, debtPaid, savings, and years with date. Function accounts for annually compounded interest
void debt(person *person , double interestRate, double additionalPay){
    double monthlyPayment;
    int months = 0;

      //make monthly payments for one year (12 payments)
      while (months < 12) {
          monthlyPayment = 0.0;
          //only make another payment if you still have debt to pay
          if (person->debt > 0) {
            //each month, pay 3% of the debt you have left plus the additional amount (for nfl additional amount is $1 and for fl additional amount is $15)

              monthlyPayment = ((person->debt * 0.03) + additionalPay);

              //if your debt left is less than your monthly payment
              if (person->debt - monthlyPayment < 0){
                //just pay whatever is left in debt with money from savings and set the value of debt to 0
                person->debtPaid = person->debtPaid + person->debt;
                person->savings = person->savings - person->debt;
                person->debt = 0.0;
                break;
              }

              //if your debt is greater than or equal to your monthly payment
              else{
              //subtract the payment made from the debt you have left to pay
              person->debt = person->debt - monthlyPayment;
              //keep track of how much money you have paid toward your debt
              (person -> debtPaid) = (person -> debtPaid) + monthlyPayment;

              //take the amount of money you are paying out of your savings account
              (person -> savings) = (person->savings) - monthlyPayment;
              //move to the next month
              months = months + 1;
            }
          }

          else{
            break;
          }
        }


        //add the annually compounded interest on the debt that hasn’t been paid off
        person->debt = person->debt + (person->debt * interestRate);

        //add a year to your yearsWithDebt variable value (or the proportion of the year that you made monthly payments for if you paid off your debt before the year ended)
        if (person->debt - 1 > 0){
         person->yearsWithDebt = person->yearsWithDebt + 12.0 / months;
        }
}

//rent function takes in pointer to person struct and a rent amount. Function pays rent for 12 months and removes the money used to pay rent from the person's checking account. Function also keeps track of how many years the person has rented 
void rent(person *person, double rentamt){
  int months = 0;
  while (months < 12){
    person -> checking = person -> checking - rentamt;
    months = months + 1;
  }
  person -> yearsRented = (person -> yearsRented) + 12.0 / months;
}


//function performs the power mathematical operation. The argument to the first parameter is the number you want to multiply by itself. The second argument to the parameter is the number of times you want to multiply the first parameter by itself
double powerOperation(double base, int exponent) {
    double x = 1;
    for (int i = 0; i < exponent; i = i + 1){
        x = x * base;
    }
    return x;
 }

//function determines how much the person should pay towards their loan every month in order to pay off their loan in exactly 30 years
void housingPayments(person *person){
  int numberOfPayments;
  //interest is still a rate , not a total interest value
  double interest;
  double discountFactor;
  double dfNumerator;
  double dfDenomenator;

  //nfl
  if (person-> literacy == false ){
    //loan interest rate is the PMI (.005) plus the default loanInterest rate(.045) because they paid less than 20% upfront when they made their down payment
    person->loanInterestRate = person->loanInterestRate + PMI;
    //calculate monthly interest rate by multiplying annual interest rate by 1/12 (same as dividing by 12 -- 12 being the number of months in a year)
    interest = person->loanInterestRate *  (1.0 / 12.0);
  }
  //fl
  else{
    //calculate monthly interest rate by multiplying annual interest rate by 1/12 (same as dividing by 12 -- 12 being the number of months in a year)
    interest = person->loanInterestRate * (1.0 / 12.0);
  }

  //number of payments is 360 (12 payments per year for 30 years)
  numberOfPayments = mortgageTerm * 12;

  //calculate the discount factor (which requires 2 calls to the powerOperation function I made because the equation involves exponents, which are not built-in to C) using following equation : discount factor = [((1+i)^N)-1] / (i(1+i)^N)
  dfNumerator = powerOperation(1 + interest, numberOfPayments) - 1;
  dfDenomenator = interest * powerOperation(1 + interest, numberOfPayments);
  discountFactor = dfNumerator / dfDenomenator;

  //calculate monthlyLoanPayment by dividing the initialLoan by the discountFactor
  person ->  monthlyLoanPayment = person->initialLoan / discountFactor ;
}


//makeDownPayment should be called when a person is ready to buy a house. function removes the downPayment amount from the checking account and sets the value of the person's loan
void makeDownPayment(person *person){

   //calculate down payment on house
   //if fl
   if (person -> literacy == true){
     //down payment is 20% of house price
     person->downPayment = (person->housePrice * .2);
   }

   //if nfl
   else{
     //down payment is 5% of house price
     person->downPayment = (person->housePrice * .05);
   }

  //pay downpayment from checking
   person->checking = person->checking - person->downPayment;
  //calculate loan total (house price - the down payment you just made)
   person -> loan = person->housePrice - person->downPayment;

  //initial loan has the same value of loan. Will be used later
   person->initialLoan = person->loan;

  //send person to housingPayments function to determine their monthly mortgage payments and account for interest
  housingPayments(person);

}

//contemplatePurchase function decides whether or not a person is ready to buy a house
void contemplatePurchase(person *person){
  //if person already owns a home but somehow this function was still called for them by mistake, just return
  if (person->homeOwner == true){
    return;
  }

  //for fl
  if (person->literacy == true){
    //if they have enough money in their checking account to put 20% of the house price down as a down payment
    if (person->checking - (.2 * (person->housePrice)) > 0){
      //set homeOwner variable to true
      person->homeOwner = true;
      //send person to the makeDownPayment function to make their down payment
      makeDownPayment(person);
    }
    //if they DO NOT have enough money in their checking account to put 20% of the house price down as a down payment, just return
    else{
      return;

    }
  }
  else{
    //if they have enough money in their checking account to put 5% of the house price down as a down payment
    if (person->checking - (.05 * (person->housePrice)) > 0){
      //set homeOwner variable to true
      person->homeOwner = true;
      //send person to the makeDownPayment function to make their down payment
      makeDownPayment(person);

    }
    else{
      return;
    }
  }
}

//house function pays a years worth of mortgage payments for the person (stops when loan is paid off if that happens in the middle of the year). Each month, function removes the payment amount from the person's checking, subtracts that amount from their loan total, adds that amount to their loanPaid, and adds 1/12 of the yearly added interest to their loan total
void house(person *person, double interestrate, int mortgageterm){
      //make monthly mortgage payments for 1 year
      int months = 0;
      while(months < 12){
        
        if(person->loan > 0){

          //if the amount left to pay of your loan is less than your monthly payment, just pay whatever is left in the loan (using your checking account), set loan to 0. You are done paying off your loan
          if (person->loan < person->monthlyLoanPayment){
            //int finalPayment;
           // finalPayment = person->loan;
            person ->checking = person->checking - (person->loan);

            person->loan = 0.0; //finalPayment
            //stop monthly payments. You have paid off your mortgage!!
            break;

          }
          else{
          //take the monthly payment from your checking account
          person -> checking = (person -> checking) - (person -> monthlyLoanPayment );

          person->loanPaid = person->loanPaid + person->monthlyLoanPayment;
          //subtract payment from loan total so it expresses how much of the loan has not yet been paid off
          person -> loan = (person -> loan) - (person -> monthlyLoanPayment);

          //add 1/12 of the yearly added interest on their loan (determined by their loanInterestRate and the current amount left in loan) to their loan total
          person->loan = person->loan + ((person->loanInterestRate*person->loan)/ 12.0);
          //move to the next month
          months = months + 1;
          }

        }
        else{
          break;
        }
        }
}

//setWealth function takes in a pointer to struct person and calculates their current wealth by finding the sum of their savings and checking and subtracting their debt and their loan. 
void setWealth(person *person){
  person -> currentWealth = person->savings + person->checking - person->debt - person->loan;
}

 //simulator executes the 40 year wealth simulation. Function calculates initial wealth for the person and then simulates 40 years of financial actions by calling the other functions defined in this project. The person's wealth is calculated and added to an array of wealth values at the end of each year.
int simulator(person *person, double yearlysalary){

  setWealth(person);
  person->wealth[0] = person->currentWealth;

  if (person->literacy == true){
      person->savingsInterestRate = .07;
      person->debtAdditionalPay = 15;
  }
  else{
    person->savingsInterestRate = .01;
    person->debtAdditionalPay = 1;
  }

  for (int i = 0; i < 41; i = i + 1){

    //get paid yearlySalary
    //put 30% of salary in checking account
    person -> checking = person -> checking + (yearlysalary * .3);
    //put 20% of salary in savings account
    person -> savings = person -> savings + (yearlysalary * .2);

    //pay your credit card debt
    debt(person,  debtInterestRate, person->debtAdditionalPay);


    //if already a homeOwner
    if (person -> homeOwner == true){
      //make a years worth of mortgage payments (with  interest)
      house(person, person->loanInterestRate, mortgageTerm);
    }
    //if you haven't bought a home yet
    else{
      //in comtemplatePurchase function - decide if you're ready to buy a house(if you have enough money in your checking accout). If ready, contemplatePurchase will call makeDownPayment, and you will make the down payment for your house
      contemplatePurchase(person);
      //if not ready to buy a house, pay a years worth of rent payments
      if (person -> homeOwner == false){
        rent(person, person -> rent);
      }
      else{
        //if you just bought a house this year, now pay your mortgage for this year
        house(person, person->loanInterestRate, mortgageTerm);
      }
    }

    //obtain interest for your savings account
    savingsPlacement(person, person -> savingsInterestRate);
    
    //calculate current wealth at the end of this year (savings + checking - debt - loan) in setWealth function
    setWealth(person);

    //add this year's currentWealth to the wealth array
    person->wealth[i + 1] = person->currentWealth;

    //simulation is over
  }
return 0;
}

// function takes in a pointer to struct person and an output text file and prints the wealth array (one number per line) to the text file 
void outputWealth(person *person, FILE* outputFileName){

  //write each value in the wealth array to the file, one number per line
  for (int i = 0; i < 41; i = i+1){
    fprintf(outputFileName, "%.2f\n", round(person->wealth[i]));
  }
  //close file
  fclose(outputFileName);
}

//function takes in a pointer to struct person and an input text file, reads the file to obtain 7 values and assigns those values to their respective struct variables for that person. 
void newPersonInput(person* person, FILE* inputFileName){
    //set the values that we assume all persons will start with
    person->yearsWithDebt = 0.0;
    person->debtPaid = 0.0;
    person->yearsRented = 0.0;
    person->loan = 0.0;
    person->homeOwner = false;
    person->loanInterestRate = .045;

  int literacyAsInt;
  //read file
  fscanf(inputFileName, "%lf %lf %d %lf %d %d %lf", &person->savings , &person->debt, &literacyAsInt, &person->checking, &person->rent, &person->housePrice, &person->yearlySalary);
  //close file
  fclose(inputFileName);

  //convert the literacy status input specified as an integer in the file, held in the value of local variable, literacyAsInt,to a boolean value for person->literacy
  if (literacyAsInt - 1 < 0){
    person->literacy = false;
  }
  else{
    person->literacy = true;
  }
}

//EXTRA CREDIT FUNCTIONALITY
//function is used in main to print the menu of actions for the user to choose from
void printMenu(){
printf("\n\nPlease choose the person you would like to run the 40-year financial simulation on from the following menu. Indicate your selection by typing the number of your choice followed by the enter key. Enter 0 to quit. \n\n 1. Demo financially literate (fl) person.\n 2. Demo not financially literate (nfl) person.\n 3. Financially literate person living below the US poverty line (from input file).\n 4. Not financially literate person living below the US poverty line (from input file).\n 5. Financially literate person living among the top 1 percent of US earners (from input file).\n 6. Not financially literate person living among the top 1 percent of US earners (from input file).\n 7. Yourself: enter your own information! \n\n");
}
//main function has been equipped to display a user-friendly interface that allows for the execution of simulations for a variety of persons (2 hard-coded persons, 4 persons that can be created from existing input text files, and ability to create persons from user input). 
//EXTRA CREDIT FUNCTIONALITY- USER FRIENDLY INTERFACE 
int main(){

  int menuSelection;
  //Greet user
  printf("WELCOME TO OLIVIA'S WEALTH SIMULATOR!\n");
  //print the menu
  printMenu();
  //take user input for what action to perform
  scanf("%d", &menuSelection);
  //while user has not quit
  while (menuSelection != 0 ){
    //if user selects option 1 -- hard-coded fl
    if (menuSelection - 1 == 0){
      
      //create fl person by hand
      person fl;
        fl.savings = 5000.00;
        fl.debt = 30100.0;
        fl.yearsWithDebt = 0.0;
        fl.literacy = true;
        fl.debtPaid = 0.0;
        fl.checking = 1000.0;
        fl.rent = 850;
        fl.yearsRented = 0.0;
        fl.housePrice = 175000;
        fl.loan = 0.0;
        fl.homeOwner = false;
        fl.yearlySalary = 59000.0;
        fl.loanInterestRate = .045;

        printf("\n\nNow running 40-year simulation for fl\n");
        //run simulator for fl
        simulator(&fl, fl.yearlySalary);

        //output wealth array for fl to file
        //declare and open the output file
        FILE* flOutput = NULL;
        flOutput = fopen("flOutput.txt", "w");
        //call outputWealth function
        outputWealth(&fl, flOutput);
        printf("Wealth array for fl has been exported to the file \"flOutput.txt\"\n");

        //print the menu
        printMenu();
        //take user input for next action to perform
        scanf("%d", &menuSelection);
    }
    //if user picks option 2 -- hard-coded nfl
    else if(menuSelection - 2 == 0){
      //create nfl by hand
      person nfl;
        nfl.savings = 5000.00;
        nfl.debt = 30100.0;
        nfl.yearsWithDebt = 0.0;
        nfl.literacy = false;
        nfl.debtPaid = 0.0;
        nfl.checking = 1000.0;
        nfl.rent = 850;
        nfl.yearsRented = 0.0;
        nfl.housePrice = 175000;
        nfl.loan = 0.0;
        nfl.homeOwner = false;
        nfl.yearlySalary = 59000.0;
        nfl.loanInterestRate = .045;

       printf("\n\nNow running 40-year simulation for nfl\n");
       //run simulator for nfl
      simulator(&nfl, nfl.yearlySalary);

      //output wealth array for nfl to file
      //declare and open the output file
      FILE* nflOutput = NULL;
      nflOutput = fopen("nflOutput.txt", "w");
      //call outputWealth function 
      outputWealth(&nfl, nflOutput);
      printf("Wealth array for nfl has been exported to the file \"nflOutput.txt\"\n");
      
      //print the menu
      printMenu();
      //take user input for next action to perform
      scanf("%d", &menuSelection);
    }
    
    //if user picks option 3 -- Financially literate person living below the US poverty line (from input file)
    else if(menuSelection - 3 == 0){
      //create person from person struct
      person flPoverty;

      //declare and open the existing input file for this person
      FILE* flPovertyPersonInput = NULL;
      flPovertyPersonInput = fopen("flPovertyPersonInput.txt", "r");

      //call newPersonInput function 
      newPersonInput(&flPoverty, flPovertyPersonInput);
      printf("\n\nFinancially literate poverty person (flPoverty) has been created from the existing input text file \"flPovertyPersonInput.txt\"\nNow running 40-year simulation for flPoverty\n");

       //run simulator for flPoverty
      simulator(&flPoverty, flPoverty.yearlySalary);

      //output wealth array for flPoverty to file
      //declare and open the output file
      FILE* flPovertyPersonOutput = NULL;
      flPovertyPersonOutput = fopen("flPovertyPersonOutput.txt", "w");
      outputWealth(&flPoverty, flPovertyPersonOutput);
      printf("Wealth array for flPoverty has been exported to the file \"flPovertyPersonOutput.txt\"\n");
      
      //print the menu
      printMenu();
      //take user input for next action to perform
      scanf("%d", &menuSelection);
    }

    //if user picks option 4 -- Not financially literate person living below the US poverty line (from input file)
    else if(menuSelection - 4 == 0){
      //read in, execute simulator, and output for first person
      //create person from person struct
      person nflPoverty;

      //declare and open the existing input file for this person
      FILE* nflPovertyPersonInput = NULL;
      nflPovertyPersonInput = fopen("nflPovertyPersonInput.txt", "r");

      //call newPersonInput function 
      newPersonInput(&nflPoverty, nflPovertyPersonInput);
      printf("\n\nNot financially literate poverty person (nflPoverty) has been created from the existing input text file \"nflPovertyPersonInput.txt\"\nNow running 40-year simulation for nflPoverty\n");

       //run simulator for nflPoverty
      simulator(&nflPoverty, nflPoverty.yearlySalary);

      //output wealth array for flPoverty to file
      //declare and open the output file
      FILE* nflPovertyPersonOutput = NULL;
      nflPovertyPersonOutput = fopen("nflPovertyPersonOutput.txt", "w");
      outputWealth(&nflPoverty, nflPovertyPersonOutput);
      printf("Wealth array for nflPoverty has been exported to the file \"nflPovertyPersonOutput.txt\"\n");
      
      //print the menu
      printMenu();
      //take user input for next action to perform
      scanf("%d", &menuSelection);
    }
    //if user picks option 5 -- Financially literate person living among the top 1 percent of US earners (from input file)
    else if(menuSelection - 5 == 0){
      //create person from person struct
      person flRich;

      //declare and open the existing input file for this person
      FILE* flRichPersonInput = NULL;
      flRichPersonInput = fopen("flRichPersonInput.txt", "r");

      //call newPersonInput function 
      newPersonInput(&flRich, flRichPersonInput);
      printf("\n\nFinancially literate rich person (flRich) has been created from the existing input text file \"flRichPersonInput.txt\"\nNow running 40-year simulation for flRich\n");

       //run simulator for flRich
      simulator(&flRich, flRich.yearlySalary);

      //output wealth array for flRich to file
      //declare and open the output file
      FILE* flRichPersonOutput = NULL;
      flRichPersonOutput = fopen("flRichPersonOutput.txt", "w");
      outputWealth(&flRich, flRichPersonOutput);
      printf("Wealth array for flRich has been exported to the file \"flRichPersonOutput.txt\"\n");
      
      //print the menu
      printMenu();
      //take user input for next action to perform
      scanf("%d", &menuSelection);
    }

    //if user picks option 6 -- Not financially literate person living among the top 1 percent of US earners (from input file)
    else if(menuSelection - 6 == 0){
      //create person from person struct
      person nflRich;

      //declare and open the existing input file for this person
      FILE* nflRichPersonInput = NULL;
      nflRichPersonInput = fopen("nflRichPersonInput.txt", "r");

      //call newPersonInput function 
      newPersonInput(&nflRich, nflRichPersonInput);
      printf("\n\nNot financially literate rich person (nflRich) has been created from the existing input text file \"nflRichPersonInput.txt\"\nNow running 40-year simulation for nflRich\n");

       //run simulator for nflRich
      simulator(&nflRich, nflRich.yearlySalary);

      //output wealth array for flRich to file
      //declare and open the output file
      FILE* nflRichPersonOutput = NULL;
      nflRichPersonOutput = fopen("nflRichPersonOutput.txt", "w");
      outputWealth(&nflRich, nflRichPersonOutput);
      printf("Wealth array for nflRich has been exported to the file \"nflRichPersonOutput.txt\"\n");
      
      //print the menu
      printMenu();
      //take user input for next action to perform
      scanf("%d", &menuSelection);
    }

//VERY EXTRA CREDIT - THIS OPTION TESTS THE USER TO OBTAIN THEIR FINANCIAL LITERACY, TAKES USER INPUT FOR 6 OTHER STRUCT VARIABLES, RUNS THE SIMULATOR FOR THEM, AND OUTPUTS THEIR WEALTH ARRAY IN A FILE 
    //if user picks option 7 - creating their own 
    else if(menuSelection - 7 == 0){
      //create user of person struct type
      person user;

      //set default values for the struct variables that we assume all users will begin with 
      user.yearsWithDebt = 0.0;
      user.debtPaid = 0.0;
      user.yearsRented = 0.0;
      user.loan = 0.0;
      user.homeOwner = false;
      user.loanInterestRate = .045;

      //evaluate user's financial literacy using the questions provided in the project instructions
      int answer1;
      int answer2;
      int answer3;
      printf("First, let's check if you are financially literate.\n QUESTION 1: Suppose you had $100 in a savings account and the interest rate was 2 percent per year. After 5 years, how much do you think you would have in the account if you left the money to grow?\n1) More than $102\n2) Exactly $102\n3) Less than $102\n4) Don’t know\n5) Refuse to answer\n");
      scanf("%d", &answer1);
      
      printf("\nImagine that the interest rate on your savings account was 1 percent per year and inflation was 2 percent per year. After 1 year, with the money in this account, would you be able to buy…\n1) More than today\n2) Exactly the same as today\n3) Less than today\n4) Don`t know\n5) Refuse to answer\n");
      scanf("%d", &answer2);

      printf("\nDo you think the following statement is true or false? Buying a single company stock usually provides a safer return than a stock mutual fund.\n1) True\n2) False\n3) Don`t know\n4) Refuse to answer\n");
      scanf("%d", &answer3);

      //if user answered all 3 questions correctly
      if ((answer1 - 1 == 0) && (answer2 - 3 == 0) && (answer3 - 2 == 0)){
        //person is financially literate
        user.literacy = true;
      }
      else{
        user.literacy = false;
      }

    //get user savings
    printf("Now let's collect your financial information.\n Please enter the initial amount of money in your savings account with decimals (if value is a whole number add .00): \n");
    scanf("%lf", &user.savings);

    //get user checking
    printf("Please enter the initial amount of money in your checking account with decimals (if value is a whole number add .00): \n");
    scanf("%lf", &user.checking);

    //get user debt
    printf("Please enter the total value of your initial debt on your credit cards and in student loans, with decimals (if value is a whole number add .00): \n");
    scanf("%lf", &user.debt);

    //get user checking
    printf("Please enter the price of one month of rent that you would realistically pay (Do not include decimals. Round if necessary.): \n");
    scanf("%d", &user.rent);

    //get user housePrice
    printf("Please enter the price of the home that you would like to buy when/if you buy a home in the next 40 years (Do not include decimals. Round if necessary.): \n");
    scanf("%d", &user.housePrice);

    //get user yearlySalary
    printf("Please enter your annual salary, with decimals (if value is a whole number add .00): \n");
    scanf("%lf", &user.yearlySalary);


    printf("Thank you for your information! For your confidentiality, the information you entered will not be saved. Only your wealth array will be outputted.\n Now running your 40-year wealth simulation.");

    //run simulator for user
    simulator(&user, user.yearlySalary);

    //output wealth array for user to file
    //declare and open the output file
    FILE* userOutput = NULL;
    userOutput = fopen("userOutput.txt", "w");
    //call outputWealth function
    outputWealth(&user, userOutput);
    printf("Your wealth array has been exported to the file \"userOutput.txt\"\n");
    
    //print the menu
    printMenu();
    //take user input for next action to perform
    scanf("%d", &menuSelection);
    }
    //if they give improper input for menuSelection
    else{
      printf("Please enter a valid option 0-7");
    }

    }
  //say goodbye and thank user
  printf("THANK YOU FOR USING OLIVIA'S WEALTH SIMULATOR!\nHAVE A NICE DAY!!");

  return 0;
  }
  