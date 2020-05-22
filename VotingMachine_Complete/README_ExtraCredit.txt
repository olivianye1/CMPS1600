/**
 * Describes the Extra Credit extension element, candidateCuisineType, implemented in this project.
 * @author Olivia Nye
 * @class CMPS 1600 
 * @date 02/27/2019
 * Project 0 - Voting Machine
 */


I added an additional attribute that provides more information about the candidate, candidateCuisineType. 
This is an attribute of type String, that is an additional parameter to the Candidate object constructor. 
The value of this attribute represents the type of cuisine that the Candidate object specializes in. If this 
VotingMachine were to be used for a different kind of election where cuisine type is not applicable, this
attribute could easily be used to hold some other type of information, like a politician's stance on a key 
issue that might influence the way some voters choose which candidate to vote for. Because I added this new
element, this project will only work as intended if the input file is formatted such that the candidate's 
affiliation is followed by a colon (':'), which is then followed by the type of cuisine that the candidate 
in that line specializes in. A sample input file, called votingMachine_sampleInput.txt, that conforms to this 
formatting requirement has been included in the submission zip file. 


The BallotReader class has been modified to read and save cuisine type information from the input file, 
just like how it reads and saves information about the candidate's name and affiliation. All other methods
that have been impacted by this change have been modified accordingly in order to ensure proper reading
of the ballot. 

In the Candidate class, this attribute has its own getter method, getCuisine, and its own setter method, 
setCuisine. Both of these methods are tested in the candidateTester jUnit testclass. 

The information held in this attribute is not displayed in the results output document. Thus, it is not 
referenced in the resultsWriter class. 

The cuisine type information is displayed to the voter during their interaction with the GUI. The castVote 
method of the BallotDialog class was modified to display this information to the voter when checking to 
confirm that the voter wants to vote for the candidate they selected. 