/**
 * imports ArrayList framework
 * imports junit framework
 */

import java.util.ArrayList;

import junit.framework.*;

/**
 * BallotTester is a public class that is extension of TestCase class from junit framework.
 * Class tests the constructor and the methods from the Ballot class 
 * @author Olivia Nye
 * @class CMPS 1600 
 * @date 02/27/2019
 * Project 0 - Voting Machine
 */


public class BallotTester extends TestCase{
	/**
	 * defines instant variables of type Ballot, b1, b2, and b3 which will be constructed and tested in this class
	 * b1 and b2 will both represent normal Candidate object cases. b3 will represent a somewhat boundary Candidate object case, being String arguments of only one character 
	 */
	
	public Ballot b1, b2, b3;
	
	
	@Override
	protected void setUp() {
	b1 = new Ballot("President");
	b2 = new Ballot("Senator");
	b3 = new Ballot("X");
	}
	
	@Override
	protected void tearDown() {
	b1 = null;
	b2 = null;
	b3 = null;
	}
	
	/**
	 * creates 3 candidate objects, c1, c2, and c3 to be used in the tests of the addCandidate method
	 */
	
	Candidate c1 = new Candidate("Barack Obama", "Democrat", "Hawaiian");
	Candidate c2 = new Candidate("John McCain", "Republican", "TexMex");
	Candidate c3 = new Candidate("X", "Y", "Z");
	
	/**
	 * verify that default constructor sets default instance variable officeName correctly
	 * also tests getOfficeName method
	 */
	
	public void testDefaultInstance() {
		assertEquals("President", b1.getOfficeName());
		assertEquals("Senator", b2.getOfficeName());
		assertEquals("X", b3.getOfficeName());
	}

	/**
	 * verify that setOfficeName method and getOfficeName method are working appropriately
	 */
	
	public void testSetOfficeName() {
		b1.setOfficeName("POTUS");
		assertEquals("POTUS", b1.getOfficeName());
		
		b2.setOfficeName("Governor");
		assertEquals("Governor", b2.getOfficeName());
		
		b3.setOfficeName("O");
		assertEquals("O", b3.getOfficeName());
	}
	

	/**
	 * verify that null input to setOfficeName method results in test failure
	 */
	
	public void testIllegalInputToSetOfficeName() {
		b1.setOfficeName(" ");
		fail();		
}
	/**
	 * verify that default ArrayList Candidates is an empty arrayList
	 * also verifies that getCanidates method accurately returns ArrayList even when empty
	 */
	
	public void testDefaultCandidates(){
		
		ArrayList<Candidate> TesterList = new ArrayList<Candidate>(0);
		
		assertEquals(TesterList, b1.getCandidates());
		assertEquals(TesterList, b2.getCandidates());
		assertEquals(TesterList, b3.getCandidates());
	}
	
	
	/**
	 * verify that addCandidate function works correctly
	 * also verifies that getCandidates accurately lists all candidates in the Candidates ArrayList
	 */
	public void testAddCandidate() {
		b1.addCandidate(c1);
		b1.addCandidate(c2);
		b1.addCandidate(c3);
		
		ArrayList<Candidate> b1TesterList = new ArrayList<Candidate>(3);
		
		b1TesterList.add(c1);
		b1TesterList.add(c2);
		b1TesterList.add(c3);
		
		assertEquals(b1TesterList, b1.getCandidates());
		
		
		
		b2.addCandidate(c2);
		b2.addCandidate(c1);
		
		ArrayList<Candidate> b2TesterList = new ArrayList<Candidate>(2);
		b2TesterList.add(c2);
		b2TesterList.add(c1);
		assertEquals(b2TesterList, b2.getCandidates());
		
		
		
		b3.addCandidate(c3);
		
		ArrayList<Candidate> b3TesterList = new ArrayList<Candidate>(1);
		b3TesterList.add(c3);
		assertEquals(b3TesterList, b3.getCandidates());
	}
	
	/**
	 * verify that addCandidates does not permit duplicate candidates to be added to Candidates 
	 */
	public void testAddDuplicates() {
		b1.addCandidate(c1);
		b1.addCandidate(c2);
		b1.addCandidate(c3);
		b1.addCandidate(c1);
		b1.addCandidate(c2);
		
		ArrayList<Candidate> b1TesterList = new ArrayList<Candidate>(3);
		
		b1TesterList.add(c1);
		b1TesterList.add(c2);
		b1TesterList.add(c3);
		
		assertTrue(b1.Candidates.size()  == b1TesterList.size());
		
		
		ArrayList<Candidate> b2TesterList = new ArrayList<Candidate>(5);
		
		b2TesterList.add(c1);
		b2TesterList.add(c2);
		b2TesterList.add(c3);
		b2TesterList.add(c1);
		b2TesterList.add(c2);
		
		assertNotSame(b1, b2TesterList);
	}


	/**
	 * main method runs junit test for BallotTester class using textui
	 * @param args
	 */
	
	public static void main(String args[]) {
		junit.textui.TestRunner.main(new String[] {"BallotTester"});
	}
}
