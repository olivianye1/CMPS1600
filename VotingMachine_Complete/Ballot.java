/**
 * import ArrayList Java package that allows for the implemention and modification of ArrayLists
 */

import java.util.ArrayList;

/**
 * public class Ballot provides methods and attributes that allow for the construction of new Ballot objects 
 * each Ballot object represents a ballot that consists of the name of the office that is to be voted on and an ArrayList of Candidates for that office
 * @author Olivia Nye
 * @class CMPS 1600 
 * @date 02/27/2019
 * Project 0 - Voting Machine
 */

public class Ballot
{
	/**
	 * creates protected String attribute office, which is used to hold the value of the name of the office that is up for a vote on this Ballot object
	 */
	
	String office;
	
	/**
	 * creates new ArrayList, Candidates, composed of elements of type Candidate object
	 */
	
	ArrayList<Candidate> Candidates = new ArrayList<Candidate>();
	
	/**
	 * Ballot constuctor creates new object of type Ballot, consisting of name of office up for a vote and an ArrayList of candidates for that office
	 * @param officeName  holds the value of the name of the office that is up for a vote on this Ballot object
	 */
	
	public Ballot(String officeName)
	{
		office = officeName;
		
		
	}
	
	/**
	 * public String method getOfficeName outputs the value of the office attribute
	 * @return String attribute office; returning the name of the  office that is up for a vote on this Ballot object
	 */

	public String getOfficeName()
	{
		return office;
	}
	
	/**
	 * public setOfficeName method is a void method that changes the value of the officeName attribute for a Ballot object
	 * @param officeName represents the name of the office to be voted upon with the Ballot object. Only accepts Strings as argument
	 */
	
	public void setOfficeName(String officeName)
	{
			office = officeName;
	}
	
	
	/**
	 * addCandidate method adds elements of type Candidate object to the Candidates ArrayList. Method only adds this object if the object has not already been added to Candidates
	 * @param c represents a Candidate object that is a candidate for the office up for a vote on this ballot
	 */
	
	public void addCandidate(Candidate c)
	{
		if (c.isDuplicate(Candidates) == false) {
			Candidates.add(c);
			}
	}

	/**
	 * getCandidates method returns the ArrayList that contains the Candidate Objects that can be voted for with this ballot
	 * @return Candidates, which is an ArrayList composed of Candidate Objects that can be voted for with this ballot
	 */
	public ArrayList<Candidate> getCandidates()
	{
		return Candidates;
	}
	
	@Override
	public String toString() {
		
		String formattedBallot = "Vote for " + this.getOfficeName() + "\n\nChoices:\n";
		for (int i = 0; i < Candidates.size(); i = i + 1) {
			formattedBallot = formattedBallot + "\n" + Candidates.get(i).toString();
		}
		return formattedBallot;
	}
	
}
