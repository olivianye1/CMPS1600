/*
Name: Olivia Nye
Lab: 4 - Advanced Guessing Game with randomness and memory - Plays a more advanced guessing game with the user by requesting guesses within a given array of numbers. The correct number is generated randomly. Keeps asking for guesses until the user guesses correctly. Records player's name and score in a text file. Informs player of the most recent other player's name and score by reading this info from a text file.
CMPS 1600
03/25/2019
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


//declare global variable to keep track of number of guesses made
int guessCounter = 0;


int get_random(rangemin, rangemax){
 //int temp;
 int randomNum = 0;
  //randomNum = (rand() % (rangemax - rangemin + 1)) + rangemin;

  //temp = rand() / rangemax;
  srand(time(NULL));
  randomNum = rand() % rangemax;
  if (randomNum < rangemin){
    randomNum += rangemin;
    return randomNum;
  }
  else{
    return randomNum;
  }
}



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


//declare player struct containing pointer to char array that holds the user's name, and the user's score (number of guesses it took them to guess correctly). Used when writing current player's name and score to the history.txt file
struct player{
 char *Name;
 int Score;
};



//function takes target number and range min and max as arguments. Function plays a guessing game with the user and writes player's name and score to history.txt file. After user finishes the game, they are given the player before them's name and score, to motivate them to play more.
int guessing_game(int num, int rangemin, int rangemax) {


 //initialize myNum int variable, set it to whatever the num argument was. The value of num will never be used
 int myNum = num;
 //replace the value of num in myNum with a randomly generated integer obtained by calling the get_random function with arguments rangemin and rangemax
 myNum =  get_random(rangemin, rangemax);

 //initialize guessedNum, which will hold the value guessed by the user
 int guessedNum;

 //set value of NAME_LENGTH, an integer variable that holds the max number of characters in a string name, represented as an array of characters
 int NAME_LENGTH = 50;

 //declare struct player object currentPlayer
 struct player currentPlayer;

 //dynamically allocate memory to hold the characters in the Name string for currentPlayer
 currentPlayer.Name = (char*)malloc(NAME_LENGTH* sizeof("char"));

 //greet user and ask for user's name
 printf("Hello and welcome to the game.\nPlease enter your name: ");

 //takes user string input and sets the characters in the string inputted as the currentPlayer's Name array of characters
 fgets(currentPlayer.Name, NAME_LENGTH, stdin);
  //start playing the guessing game
 printf("\nYou need to guess a number between %d and %d.\n", rangemin, rangemax);

 //call ask_in_range function, with arguments rangemin and rangemax, to get a guess that is in the range
 guessedNum = ask_in_range(rangemin, rangemax);

 //enter loop if user did not guess correctly; stay within loop until the correct number is guessed
 while (guessedNum != myNum){
   //if guessedNum is less than num, loop until guessedNum is no longer less than num
   while(guessedNum < myNum){
     //inform user that their guess was too low
     printf("\nToo low!\n");
      //call ask_in_range function, with arguments rangemin and rangemax, to get another guess that is in the range
     guessedNum = ask_in_range(rangemin, rangemax);
     }
   //if guessedNum is greater than num, loop until guessedNum is no longer greater than num
   while(guessedNum > myNum){
     //inform user that their guess was too high
     printf("\nToo high!\n");
     //call ask_in_range function, with arguments rangemin and rangemax, to get another guess that is in the range
     guessedNum = ask_in_range(rangemin, rangemax);
   }
 }


 //when game ends
 //Once the user guesses correctly, congratulate them and report the number of guesses it took for them to guess correctly
 printf("\n\nGood job! You took %d guesses.\n", guessCounter);
 //saves value of guessCounter variable to struct player currentPlayer's int Score component
 currentPlayer.Score = guessCounter;
  //initialize lastPlayerName character array that holds a maximum of 30 characters
 char lastPlayerName[30];
 //initialize lastPlayerScore integer variable
 int lastPlayerScore;
  //create pointer to FILE called inFile, open/read "history.txt"; assign to inFile
 FILE* inFile = NULL;
 inFile = fopen("history.txt", "r");

 //read the file, assigning the value of the string in the file to lastPlayerName char array and assigning the value of the integer in the file to lastPlayerScore
 fscanf(inFile, "%s %d", lastPlayerName, &lastPlayerScore);

 //close the file being read
 fclose(inFile);
  //tell current player the name and score of the last player that played this game
 printf("\nLast player's score: %s, %d", lastPlayerName, lastPlayerScore);



//save current player's name and score to "history.txt" file
 //create/open/write file that will be written to, called outFile. Clears this file if it was not empty.
 FILE* outFile = NULL;
 outFile = fopen("history.txt", "w");
 //writes the current player's name and score to the outFile
 fprintf(outFile, "%s %d", currentPlayer.Name, currentPlayer.Score);
 //closes outFile. "history.txt" file has now been updated to hold the most recent player's name and score
 fclose(outFile);



 return 0;

}


//main function executes guessing game
int main(){
 return guessing_game(3, 1, 10);
}




//Assuming, that one would not ever repeatedly guess the same number, the maximum number of guesses one will need to guess a number for the range [-500,500] is 1001.



