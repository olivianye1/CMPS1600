import java.util.ArrayList;

/**
  * Candidate class is a public class that provides methods for the construction of objects 
  * that each represent one candidate on a ballot, which consist of a name, a party affiliation, and a cuisine type. 
  * This class also keeps track of the number of votes placed for each candidate object constructed
  * @author Olivia Nye
  * @class CMPS 1600 
  * @date 02/27/2019
  * Project 0 - Voting Machine
  */

public class Candidate
{
	/**
	 * creates protected String attribute candidateName, which is used to hold the value of the candidate object's name
	 */
	
	protected String candidateName;
	
	/**
	 * creates protected String attribute candidateAffiliation, which is used to hold the value of the candidate object's political party affiliation
	 */
	
	protected String candidateAffiliation;
	
	/**
	 * creates protected String attribute candidateCuisineType, which is used to hold the value of the type of cuisine that the candidate specializes in 
	 */
	
	protected String candidateCuisineType;
	
	/**
	 * creates public integer attribute voteCounter, which is used to count the number of votes placed for each candidate
	 * initial value of this attribute is set to 0 to indicate that no votes exist for a candidate before they have been voted for
	 */
	
	public int voteCounter;
	
	/**
	 * Candidate constructor creates new Candidate objects and sets candidateName and candidateAffiliation attributes to the values provided as arguments to their respective paramters
	 * initializes default voteCounter to 0 for each new object 
	 * @param name String attribute name represents the first and last name of the candidate, as it should appear on the ballot and in the results
	 * @param affiliation String attribute affiliation represents the party with which the Candidate object is affiliated
	 * @param cuisine String attribute cuisine represents the type of cuisine that the candidate specializes in -- EXTRA CREDIT ATTRIBUTE
	 */
	
	public Candidate(String name, String affiliation, String cuisine)
	{
		candidateName = name;
		candidateAffiliation = affiliation;
		candidateCuisineType = cuisine;
		
		voteCounter = 0;
	}

	/**
	 * public String method getName outputs the name of the Candidate object
	 * @return String attribute candidateName; returning the full name of the candidate as it should appear on the ballot and in the results
	 */
 
	public String getName()
	{
		return candidateName;
	 
	}
	
	/**
	 * public setName method is a void method that changes the value of the candidateName attribute for a Candidate object
	 * @param name represents the name of the Candidate object. Only accepts Strings as argument
	 */
	
	public void setName(String name)
	{
		candidateName = name;
	}
	
	/**
	 * public String method getAffiliation outputs the candidateAffiliation of the Candidate object
	 * @return String attribute candidateAffiliation; returning the name of the party that the Candidate object associates with
	 */
	 
	public String getAffiliation()
	{
		 return candidateAffiliation;
	}

	/**
	 * public setAffiliation method is a void method that changes the value of the candidateAffiliation attribute for a Candidate object
	 * @param affiliation represents the party affiliation of the Candidate object. Only accepts Strings as argument
	 */
	
	public void setAffiliation(String affiliation)
	{
			candidateAffiliation = affiliation;
	}
	
	
	/**
	 * public String method getCuisine outputs the candidateCuisineType of the Candidate object
	 * @return String attribute candidateCuisineType; returning the type of cuisine that the candidate specializes in 
	 */
	 
	public String getCuisine()
	{
		 return candidateCuisineType;
	}

	/**
	 * public setCuisineType method is a void method that changes the value of the candidateCuisineType attribute for a Candidate object
	 * @param cuisine represents the cuisine specialty of the Candidate object. Only accepts Strings as argument
	 */
	
	public void setCuisine(String cuisine)
	{
			candidateCuisineType = cuisine;
	}
	
	
	/**
	 * outputs the current value of attribute voteCounter
	 * @return voteCounter, which holds the integer value of the number of votes placed for the Candidate object
	 */
	
	public int getVoteCount()
	{
		return voteCounter;
	}
 
	/**
	 * iterates voteCounter attribute by 1
	 * used to "place a vote" for a Candidate Object
	 */
	
	public void tallyVote()
	{
		voteCounter = voteCounter + 1;

	}
	
	
	
	/**
	 * compareTo method compares current Candidate object to another candidate object provided. Compares the two candidates' names, affiliations, and cuisines
	 * @param otherCandidate another Candidate object 
	 * @return true if the two Candidates have the same name, affiliation, and cuisine
	 */
	
	protected boolean compareTo(Candidate otherCandidate) {

		if (this.getName().contentEquals(otherCandidate.getName())) {
			if (this.getAffiliation().contentEquals(otherCandidate.getAffiliation())) {
				if (this.getCuisine().contentEquals(otherCandidate.getCuisine())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * creates public boolean attribute duplicateStatus and initializes its value to false, which means that a candidate is not a duplicate of another candidate already entered to the ballot
	 */
	
	protected boolean duplicateStatus = false;
	
	/**
	 * isDuplicate method iterates through ArrayList filled will candidate objects as elements and checks each of the c to see if the element is the same as the current candidate
	 * sameness is indicated by having the same candidateName, candidateAffiliation, and candidateCuisineType
	 * @param listCandidates is an ArrayList with elements of type Candidate objects
	 * @return true or false, true indicates that the Candidate is a duplicate and should not be added to the ArrayList
	 */
	
	
	protected boolean isDuplicate(ArrayList<Candidate> listCandidates) {
		for(int i = 0; i < listCandidates.size(); i = i +1) {
			
			if (this.compareTo(listCandidates.get(i)) == true) {
				duplicateStatus = true;
				return duplicateStatus;
			}
		}
		
		return duplicateStatus;
	}
	
	//ADD COMPARE METHOD SO THAT ADDCANDIDATE METHOD IN BALLOT CLASS WORKS

	@Override
	public String toString()
	{
		 return this.getName() + " - " + this.getAffiliation(); 
	}
}