--Name: Olivia Nye
--Date: 04/16/2019
--CMPS 1600
--Lab 7 Tests - tests all of the functions created in LAB7.hs. If it returns an empty list, all tests were passed.
-- Test cases for LAB7

module LAB7Tests where

import LAB7
import Testing

-- Exercise 1 -----------------------------------------

testLastDigit :: (Integer, Integer) -> Bool
testLastDigit (n, d) = lastDigit n == d

testDropLastDigit :: (Integer, Integer) -> Bool
testDropLastDigit (n, d) = dropLastDigit n == d

ex1Tests :: [Test]
ex1Tests = [ Test "lastDigit test" testLastDigit
             [(123, 3), (1234, 4), (5, 5), (10, 0), (0, 0)]
           , Test "dropLastDigit test" testDropLastDigit
             [(123, 12), (1234, 123), (5, 0), (10, 1), (0,0)]
           ]

-- Exercise 2 -----------------------------------------
testToRevDigits :: (Integer, [Integer]) -> Bool
testToRevDigits (n, d) = toRevDigits n == d
ex2Tests :: [Test]
ex2Tests = [Test "toRevDigits test" testToRevDigits
              [(1234, [4, 3, 2, 1]), (0, []), (57890, [0, 9, 8, 7, 5]), (12, [2, 1]), (100, [0,0,1]), (-17, [])
              ]
            ]

-- Exercise 3 -----------------------------------------
testDoubleEveryOther :: ([Integer], [Integer]) -> Bool
testDoubleEveryOther (n, d) = doubleEveryOther n == d
ex3Tests :: [Test]
ex3Tests = [Test "doubleEveryOther test" testDoubleEveryOther
             [ ([4, 9, 5, 5] , [4, 18, 5, 10]), ([0,0], [0,0]), ([9, 9], [9, 18]), ([2, 2, 2, 2, 2], [2, 4, 2, 4, 2]), ([1, 1, 1], [1, 2, 1]), ([1], [1])
             ]
             ]


-- Exercise 4 -----------------------------------------
testSumDigits :: ([Integer], Integer) -> Bool
testSumDigits (n, d) = sumDigits n == d
ex4Tests :: [Test]
ex4Tests = [Test "sumDigits test" testSumDigits 
              [([10, 5, 18, 4], 19), ([5, 5, 5], 15), ([5, 10, 5] , 11), ([5, 1, 0, 5], 11), ([12, 12], 6)
              ]
            ]

-- Exercise 5 -----------------------------------------
testLuhn :: (Integer, Bool) -> Bool
testLuhn (n, d) = luhn n == d
ex5Tests :: [Test]
ex5Tests = [Test "luhn test" testLuhn 
            [(5594589764218858, True), (1234567898765432, False), (
            4716047384217509, True), (6011577841086334, True), (375008141969188, True), (818181818181818, False) 
            ]
            ]


-- All Tests ------------------------------------------

allTests :: [Test]
allTests = concat [ ex1Tests
                  , ex2Tests
                  , ex3Tests
                  , ex4Tests
                  , ex5Tests
                  ]
