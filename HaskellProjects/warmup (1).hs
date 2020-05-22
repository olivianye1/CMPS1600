--Name: Olivia Nye
--Date: 04/16/2019
--CMPS 1600
--Lab 7 Warmup 



--WARM UP 1- LIST COMPREHENSIONS: PARTS A AND B
--outfits list comprehension (before scarves were included and before any additional purchases)
--before scarves were included:
myOutfits =  [(p, t, s) | p<-["jeans", "khaki"], t<-["white shirt", "grey turtleneck", "pink polo", "green hoodie"], s<-["brogues", "converse", "sandals"]]


--gives 4 possible outfits
myFourOutfits = take 4 myOutfits


--original wardrobe (2 pants, 4 shirts, and 3 shoes yields 24 outfit options

--If you only have budget for two more articles, it make sense to buy more items of the same type or different type? 
  -- It depends. It is always better to buy at least one pair of pants than any option that does not include pants (buying 2 pants or 1 pants and 1 shoes are the 2 optimal choices). It is never optimal to buy 2 shirts. The number of outfits created by all possible 2 additional item combinations are as follows (listed from highest to lowest outfit possibility yield):
    --2 pants: 48 (tie)
      --myOutfits =  [(p, t, s) | p<-["jeans", "khaki", "shorts", "leggings"], t<-["white shirt", "grey turtleneck", "pink polo", "green hoodie"], s<-["brogues", "converse", "sandals"]]
    --pants + shoes: 48 (tie)
      --myOutfits =  [(p, t, s) | p<-["jeans", "khaki", "shorts"], t<-["white shirt", "grey turtleneck", "pink polo", "green hoodie"], s<-["brogues", "converse", "sandals", "boots"]]
    --pants + shirt: 45
      --myOutfits =  [(p, t, s) | p<-["jeans", "khaki", "shorts"], t<-["white shirt", "grey turtleneck", "pink polo", "green hoodie", "blue tank"], s<-["brogues", "converse", "sandals"]]
    --shirt + shoes: 40 (tie)
      --myOutfits =  [(p, t, s) | p<-["jeans", "khaki"], t<-["white shirt", "grey turtleneck", "pink polo", "green hoodie", "blue tank"], s<-["brogues", "converse", "sandals", "boots"]]
    --2 shoes: 40 (tie)
      --myOutfits =  [(p, t, s) | p<-["jeans", "khaki"], t<-["white shirt", "grey turtleneck", "pink polo", "green hoodie"], s<-["brogues", "converse", "sandals", "boots", "sneakers"]]
    --2 shirts: 36
      --myOutfits =  [(p, t, s) | p<-["jeans", "khaki"], t<-["white shirt", "grey turtleneck", "pink polo", "green hoodie", "blue tank", "red halter"], s<-["brogues", "converse", "sandals"]]

--Which two articles will yield the maximum increase in the number of outfits? 
     --Two sets of two additional articles exist that maximize the increase in the number of outfits. Either buy 2 new pairs of pants OR 1 new pair of pants and 1 new pair of shoes. Both of these two options increase the number of possible outfit options to 48. 
-- Adding a new category of clothes (scarves) with 2 additional items yields 48 outfit possibilities, which ties with 2 pants and 1 pants/1 shoes for the maximum outfit number increase.
    --myOutfits =  [(p, t, s, sc) | p<-["jeans", "khaki"], t<-["white shirt", "grey turtleneck", "pink polo", "green hoodie"], s<-["brogues", "converse", "sandals"], sc<-["paisley scarf", "knit loop"]]

--WARM UP 1- LIST COMPREHENSIONS: PART C - HONORIFICS
--honorifics list comprehension
l = ["Mr.", "Ms.", "Mrs.", "Dr.", "Prof.", "Rev."]
singleHonorifics = [x | x  <- l ]
honorificPairs =  [x  ++ " and " ++  y | x  <- l, y<- l]
allHonorifics = singleHonorifics ++ honorificPairs

--WARM UP 1 - LIST COMPREHENSIONS: PART D - NATO
--Nato translation list comprehension -- FUNCTION IMPLEMENTED HERE

k = [('A', "Alfa"), ('B', "Bravo"), ('C', "Charlie"), ('D' , "Delta"), ('E', "Echo"), ('F', "Foxtrot"), ('G', "Golf"), ('H', "Hotel"), ('I', "India"), ('J', "Juliett"), ('K', "Kilo"), ('L', "Lima"), ('M', "Mike"), ('N', "November"), ('O', "Oscar"), ('P', "Papa"), ('Q', "Quebec"), ('R', "Romeo"), ('S', "Sierra"), ('T', "Tango"), ('U', "Uniform"), ('V', "Victor"), ('W', "Whiskey"), ('X', "X-ray"), ('Y', "Yankee"), ('Z', "Zulu")]

nato :: String -> [String]
nato  wrd = [snd element| t <- wrd, element <- k, t == fst element]
 

--WARM UP 2 - FUNCTIONS: PART A - REMAINDER
remainder (x, y) = x `mod` y

--WARM UP 2 - FUNCTIONS: PART B -ISEVEN
isEven x 
  -- if x mod 2 (done in remainder) is 0, then true
	|remainder (x, 2) == 0 = True
	|otherwise = False



--WARM UP 2 - FUNCTIONS: PART C - MERGE IMPLEMENTATION (I CALLED IT myMerge)
--3 base cases
myMerge [] [] = []
myMerge [] x = x
myMerge  x [] = x
--recursive step
myMerge x y
  --if first element of x is smaller than first element of y, add first element of x to new list and make recursive call on x with the current head dropped and y. If x and y are equal, this step will be executed
  | head x <= head y = head x : myMerge (drop 1 x) y
  --if first element of y is smaller than first element of x, add first element of y to new list and make recursive call on y with the current head dropped and x
  | head x >= head y = head y : myMerge x (drop 1 y)

--WARM UP 2 - FUNCTIONS: PART D - REMOVE MULTIPLE
removeMultiple myList a = [x | x <- myList , remainder(x, a)  /= 0]



--WARM UP 3 - lIST FUNCTIONS


--outfits function
outfits pants tops shoes scarves = take 4 [(p, t, s, c) | p<- pants, t<-tops, s<-shoes, c<-scarves]


--honorifics lst function (calls helper functions oneHonorifics lst and twoHonorifics lst)
oneHonorifics lst = [x | x  <- lst ]
twoHonorifics lst =  [x  ++ " and " ++  y | x  <- lst, y<- lst]
honorifics lst = (oneHonorifics lst ) ++ (twoHonorifics lst)

--NATO function - I already did this when I did the NATO expression (see above)
