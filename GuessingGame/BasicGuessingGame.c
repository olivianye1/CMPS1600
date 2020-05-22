/*
Name: Olivia Nye
Lab: 4 - Basic Guessing Game - plays a basic guessing game with the user by requesting guesses within a given array of numbers. Keeps asking for guesses until the user guesses correctly.
CMPS 1600
03/22/2019
*/

#include <stdio.h>

//declare global variable to keep track of number of guesses made
int guessCounter = 0;

//function takes range min and max as arguments, and keeps asking for guessedNum input until user inputs a number within the range. Returns guessedNum
int ask_in_range(int min, int max){
  int myMin = min;
  int myMax = max;
  int guessedNum;
  
  //request user input
  printf("Please enter a number: ");
  //takes in user input, assigns it to value of guessedNum
  scanf("%d", &guessedNum);
  //records with guessCounter that another guess has been made
  guessCounter = guessCounter + 1;

  //while loop entered whenever user enters input that is outside the range
  while (guessedNum < myMin || guessedNum > myMax){
    //ensures that no errors arise in the case of a negative minimum range value
    if (myMin < 0){
      if ((guessedNum * -1) == (myMin * -1)){
        return guessedNum;
      }
    }
    //informs user that their guess was out of range
     printf("\nYour number is outside of [%d, %d] range.", myMin, myMax);
     //requests user input
     printf("Please enter a number: ");
     //records with guessCounter that another guess is about to be made
     guessCounter = guessCounter + 1;
     //takes in user input, assigns it to value of guessedNum
     scanf("%d", &guessedNum);
     
  }
  //returns the in-range guessedNum value 
  return guessedNum;
  }

//function takes target number and range min and max as arguments. Function plays a guessing game with the user
int guessing_game(int num, int rangemin, int rangemax) {

  int guessedNum;

  //greet user
  printf("Hello and welcome to the game.\nYou need to guess a number between %d and %d.\n", rangemin, rangemax); 
  
  //call ask_in_range function, with arguments rangemin and rangemax, to get a guess that is in the range
  guessedNum = ask_in_range(rangemin, rangemax);

  //enter loop if user did not guess correctly; stay within loop until the correct number is guessed 
  while (guessedNum != num){
    //if guessedNum is less than num, loop until guessedNum is no longer less than num
    while(guessedNum < num){
      //inform user that their guess was too low
      printf("\nToo low!\n");
       //call ask_in_range function, with arguments rangemin and rangemax, to get another guess that is in the range
      guessedNum = ask_in_range(rangemin, rangemax);
      }
    //if guessedNum is greater than num, loop until guessedNum is no longer greater than num
    while(guessedNum > num){
      //inform user that their guess was too high
      printf("\nToo high!\n");
      //call ask_in_range function, with arguments rangemin and rangemax, to get another guess that is in the range
      guessedNum = ask_in_range(rangemin, rangemax);
    }
  }
  //Once the user guesses correctly, congratulate them and report the number of guesses it took for them to guess correctly
  printf("Good job! You took %d guesses.", guessCounter);

  return 0;
  
}


//main function executes guessing game
int main(){
  return guessing_game(12, -500, 500);
}

