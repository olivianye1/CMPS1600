--Name: Olivia Nye
--Date: 04/16/2019
--CMPS 1600
--Lab 7 -- Implements Luhn's algorithm to determine if a number is a valid credit card number or not 

module LAB7 where
--Exercise 1  - break a number into its last digit and the rest of the number 

--lastDigit function returns only the last digit of the number provided
lastDigit :: Integer -> Integer 
lastDigit number =  number `mod` 10  --last digit obtained my mod-ing the number by 10

--dropLastDigit function returns the number provided without its last digit
dropLastDigit :: Integer -> Integer
dropLastDigit number = (number - (number `mod` 10)) `div` 10 --new number obtained by mod-ing the number by 10, subtracting that from the original number, and dividing the remaining number by 10


--Exercise 2
--toRevDigits converts the digits of a number (if the number is not negative or 0) to a list of each integers in reverse order
toRevDigits :: Integer -> [Integer]
toRevDigits number
  --base case
	| number < 0 = [ ]
  --recursive step
	| number > 0 = lastDigit (number) : toRevDigits (dropLastDigit(number)) 
	| otherwise = [ ]
		
--Exercise 3
--doubleEveryOther takes in a list of Integers and doubles every second number 
doubleEveryOther :: [Integer] -> [Integer]
--base case
doubleEveryOther [] = [ ]
--recursive step
doubleEveryOther (x: y: xs) = x : 2 * y : doubleEveryOther xs
--catch all
doubleEveryOther z = z

--Exercise 4
--sumDigits adds the digits of all of the integers in the integer list argument and returns the integer sum
sumDigits :: [Integer] -> Integer
--base case
sumDigits [] = 0
sumDigits (x:xs)
--recursive step options
  --if the integer is more than one digit
  | x >= 10 = lastDigit(x) + dropLastDigit(x) + sumDigits xs
  --if the integer is only one digit
  | otherwise = x + sumDigits xs

--Exercise 5 
--luhn function takes in a credit card number and calls toRevDigits on that number, calls doubleEveryOther on the list returned by toRevDigits, calls sumDigits on the list returned by doubleEveryOther, and calculates the remainder when the sum is divided by 10 by "`mod`-ing" the value returned by sumDigits. returns true if that remainder is 0 and false otherwise
luhn:: Integer -> Bool
luhn number 
	| n == 0 = True
	| otherwise = False
  where n = (sumDigits(doubleEveryOther (toRevDigits (number)))) `mod` 10
