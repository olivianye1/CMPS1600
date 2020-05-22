/**
 * imports IOException from java io , which, among other method functions, allows for an failure and an error notification to be thrown when the filename called does not exist or is not compatible
 */

import java.io.IOException;

/**
 * imports File from java io, which provides methods for the opening of files as well as other related methods
 */

import java.io.File;

/**
 * imports Scanner, which allows for the reading of input from a specified location
 */

import java.util.Scanner;

/**
 * creates public class BallotReader that contains one static method that reads the input from a text file representing the ballot information in a specified text format, extracts the information of interest, and uses that information to construct a new Ballot object  
 * @author Olivia Nye
 * @class CMPS 1600 
 * @date 02/27/2019
 * Project 0 - Voting Machine
 */

public class BallotReader
{
	/**
	 * readBallot method reads the file indicated as an argument to the method, scans the file for officeName, number of candidates (n), candidate's name (cName), and candidate's party affiliation (cAffiliation), then uses this information to construct and add candidates to a new Ballot object 
	 * @param filename string containing the filename that contains the ballot information. filename string is in the format of "insertFileNameHere.txt"
	 * @return Ballot object, ballot, an instance of type Ballot Object, whose constructor is in the Ballot class of this project
	 * @throws IOException throws when the filename provided as an argument does not exist or is not compatible (i.e. is not a .txt file)
	 */
	public static Ballot readBallot(String filename)
	throws IOException 
	{
		
		// creates new instance of File object from File cl, called ballotFile, to reference filename text file 
		File ballotFile = new File(filename);
		
		
		// creates new instance of Scanner object, called scnr, that reads input from the ballotFile File object 
		Scanner scnr = new Scanner(ballotFile);
		
		
		/*
		 * creates String attribute officeName that represents the name of the office voted upon on the ballot being created from the file provided
		 * sets the String value of officeName to the first line of text in the file, as read by the scnr Scanner object
		 */
		
		String officeName;
		officeName = scnr.nextLine();
		
		
		 //creates a new instance of Ballot object, called ballot, that takes officeName as an argument to the Ballot constructor's String parameter officeName
		Ballot ballot = new Ballot (officeName);
		
		/*
		 * creates integer attribute n that represents the number of candidates that are present on the ballot
		 * reads the next line of the text file filename and converts the String value present there (which should be a number) to an integer using the parseInt method from the public Integer class. Sets the value of attribute n to the integer resulting from this conversion
		 */
		
		int n;
		n = Integer.parseInt(scnr.nextLine());
		
		/*
		 * iterates through and reads the rest of the non-blank lines in the file- of which there should be n and that which should be filled with candidate information in the format of "candidate's name;candidate's affiliation". 
		 * For each line of text, identifies position of the semi-colon. Sets the value of String cName, which represent's the candidate's name, to the concatenation of all characters in the line prior to the semi-colon. 
		 * For each line of text, sets the value of String attribute cAffiliation, which represents the candidate's party affiliation, to the concatenation of all characters following the semi-colon until reaching the colon
		 * For each line of text, sets the value of String attribute cuisineType, which represents type of cuisine that the candidate specializes in, to the concatenation of all characters following the colon until reaching the end of the text in the line.
		 * For each line of text, creates new instance of Candidate Object, calling the instance newCandidate, constructed with the current value of cName as the argument to the String name parameter and the current value of cAffiliation as the argument to the String affiliation parameter
		 * Adds each newCandidate Candidate object to the ballot Ballot object's ArrayList of Candidate objects, called Candidates, using the addCandidate public method created in the Ballot class of this project
		 */
		for (int i = 0; i < n; i = i + 1) {
			int semiColonPosition = 0;
			int colonPosition = 0;
			String candidateInfo = null;
			candidateInfo = scnr.nextLine();
			
			
			semiColonPosition = candidateInfo.indexOf(';');
			colonPosition = candidateInfo.indexOf(':');
			
			
			String cName = "";
			int j = 0;
			while(j < semiColonPosition - 1) {
				cName = cName + candidateInfo.charAt(j);
				
				j = j + 1;
			}
		
	
			String cAffiliation = "";
			
			int x = semiColonPosition + 1;
			while (x < colonPosition) {
				cAffiliation = cAffiliation + candidateInfo.charAt(x);
				x = x + 1;
			}
			

			int y = colonPosition + 1;
			String cuisineType = "";
			while (y < candidateInfo.length()) {
				cuisineType = cuisineType + candidateInfo.charAt(y);
				y = y + 1;
			}
				
			Candidate newCandidate = new Candidate(cName, cAffiliation, cuisineType);
			ballot.addCandidate(newCandidate);
			
			
			
			
			
			
		}

		// closes the Scanner object scnr so that it cannot take new input from the file
		scnr.close();

		//returns ballot, an instance of type Ballot
		return ballot;
    }
}

 