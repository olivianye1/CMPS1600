/**
 * imports IOException from java io , which, among other method functions, allows for an error notification to be thrown and re-prompt for another filename when the filename called does not exist or is not compatible
 */

import java.io.IOException;

/**
 * imports io , which, among other method functions, allows for printing to files
 */

import java.io.*;

/**
 * import ArrayList Java package that allows for the implemention and modification of ArrayLists
 */

import java.util.ArrayList;

/**
 * import Collections Java package that, among other method functions not utlilized in this class, allows for simple computatation of the maximum integer value from an ArrayList
 */


import java.util.Collections;





/**
 * creates public class ResultWriter contains one method that formats the results of the election conducted using the voting machine GUI and prints these formatted results to a .txt file 
 * @author Olivia Nye
 * @class CMPS 1600 
 * @date 02/27/2019
 * Project 0 - Voting Machine
 */

public class ResultWriter
{
	/**
	 * method writeResults takes in the values of attributes from the ballot instance of a Ballot object to calculate the winner of the vote, formats said results as well as ballot information, candidate information, and number of votes per candidate, and prints this information to a .txt file
	 * @param filename name of the file to which the results will be printed
	 * @param ballot Ballot object whose results we are printing
	 * @throws IOException throws when the filename provided as an argument does not exist or is not compatible (i.e. is not a .txt file)
	 */
	public static void writeResults(String filename, Ballot ballot)
	throws IOException{
		
		//creates new instance of FileWriter object from io called resultWriter, with the filename provided as an argument to the method 
		FileWriter resultWriter = new FileWriter(filename);
		
		PrintWriter printResultWriter = new PrintWriter(resultWriter);
		
		
		String resultLine;
		
		resultLine = String.format("RESULTS - %s", ballot.getOfficeName());
		int numDashes;
		numDashes = resultLine.length();
		
		String dashLine = "";
		int dashesPrinted = 0;
		while(dashesPrinted < numDashes) {
			dashLine = dashLine + '-';
			dashesPrinted = dashesPrinted + 1;
		}
		
		int maxTagLength = 0;
		String currentTag;
		int currentTagLength;
		ArrayList <Integer> tagLengths = new ArrayList<Integer>();
		ArrayList <String> tagStrings = new ArrayList<String>();
		
		for (int i = 0; i < ballot.Candidates.size(); i = i + 1) {
			currentTag = ballot.Candidates.get(i).getName() + " - " + ballot.Candidates.get(i).getAffiliation();
			currentTagLength = currentTag.length();
			
			tagStrings.add(currentTag);
			tagLengths.add(currentTagLength);
			
			if (currentTagLength > maxTagLength) {
				maxTagLength = currentTagLength;
			}
		}
		
		ArrayList <String> tagLinesWithSpaces = new ArrayList<String>();
		
		
		for (int i = 0; i < ballot.Candidates.size(); i = i + 1) {
			String spaceString = "            ";
			int extraSpacesNeeded;
			
			
			if (tagLengths.get(i) < maxTagLength) {
				extraSpacesNeeded = (maxTagLength - tagLengths.get(i));
				
				int numExtraSpaces = 0;
				while (numExtraSpaces < extraSpacesNeeded) {
					spaceString = spaceString + " ";
					numExtraSpaces = numExtraSpaces + 1;
				}
			}
			
			currentTag = String.format("%s%s%s", tagStrings.get(i), spaceString,ballot.Candidates.get(i).getVoteCount());
			tagLinesWithSpaces.add(currentTag);
		}
		
		String winnerLine = "";
		int winnerPosition;
		int highestNumVotes = 0;
		ArrayList <Integer> voteCounts = new ArrayList<Integer>();
		
		for (int i = 0; i < ballot.Candidates.size(); i = i + 1) {
			voteCounts.add(ballot.Candidates.get(i).getVoteCount());
		}
		
		highestNumVotes = Collections.max(voteCounts);
		
		int maxCounter = 0;
		for (int i = 0; i < voteCounts.size(); i = i + 1) {
			if (voteCounts.get(i) == highestNumVotes) {
				maxCounter = maxCounter + 1;
			}
		}
		

		winnerPosition = voteCounts.indexOf(highestNumVotes);
		winnerLine = "Winner: " + tagStrings.get(winnerPosition);
		
		if (maxCounter < 1 || maxCounter > 1) {
			winnerLine = "NO WINNER";
		}
		
			
		
		printResultWriter.println(resultLine);
		
		printResultWriter.println(dashLine);
		
		for(int i = 0; i < tagLinesWithSpaces.size(); i = i + 1) {
			printResultWriter.println(tagLinesWithSpaces.get(i));
		}
		
		printResultWriter.println("\n");
		
		printResultWriter.println(winnerLine);
		
		printResultWriter.close();
		}
	
	
	{

	}
}