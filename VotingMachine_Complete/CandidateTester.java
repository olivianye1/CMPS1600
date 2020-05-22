/**
	 * imports junit framework with TestCase
	 */


	import java.util.ArrayList;

import junit.framework.*;

	/**
	 * CandidateTester is a public class that is extension of TestCase class from junit framework.
	 * Class tests the constructor and the methods from the Candidate class 
	 * @author Olivia Nye
	 * CMPS 1600 
	 * Project 0 - Voting Machine
	 */

	public class CandidateTester extends TestCase {

		/**
		 * defines instant variables of type Candidate, c1, c2, and c3 which will be constructed and tested in this class
		 * c1 and c2 will both represent normal Candidate object cases. c3 will represent a somewhat boundary Candidate object case, being String arguments of only one character 
		 */
		
		public Candidate c1, c2, c3, c4, c5;
		
		
		@Override
		protected void setUp() {
		c1 = new Candidate("Barack Obama", "Democrat", "Hawaiian");
		c2 = new Candidate("John McCain", "Republican", "TexMex");
		c3 = new Candidate("X", "Y", "Z");
		c4 = new Candidate("Barack Obama", "Democrat", "Hawaiian");
		c5 = new Candidate("Michelle Obama", "Democrat", "Hawaiian");
		}
		
		@Override
		protected void tearDown() {
		c1 = null;
		c2 = null;
		c3 = null;
		c4 = null;
		c5 = null;
		}
		
		
		
		/**
		 * verify that default constructor sets default instance variable CandidateName correctly
		 * also tests getName method
		 */
		
		public void testDefaultInstanceName() {
			assertEquals("Barack Obama", c1.getName());
			assertEquals("John McCain", c2.getName());
			assertEquals("X", c3.getName());
		}

		/**
		 * verify that default constructor sets default instance variable CandidateAffiliation correctly
		 * also tests getAffiliation method
		 */
		
		public void testDefaultInstanceAffiliation() {
			assertEquals("Democrat", c1.getAffiliation());
			assertEquals("Republican", c2.getAffiliation());
			assertEquals("Y", c3.getAffiliation());
		}
		

		/**
		 * verify that default constructor sets default instance variable CandidateCuisineType correctly
		 * also tests getCuisine method
		 */
		
		public void testDefaultInstanceCuisine() {
			assertEquals("Hawaiian", c1.getCuisine());
			assertEquals("TexMex", c2.getCuisine());
			assertEquals("Z", c3.getCuisine());
		}
		
		
		/**
		 * verify that setName method and getName method are working appropriately
		 */
		
		public void testSetName() {
			c1.setName("Obama");
			assertEquals("Obama", c1.getName());
			
			c2.setName("John");
			assertEquals("John", c2.getName());
			
			c3.setName("Olivia");
			assertEquals("Olivia", c3.getName());
		}
		
		/**
		 * verify that setAffiliation method and getAffiliation method are working appropriately
		 */
		
		public void testSetAffiliation() {
			c1.setAffiliation("party1");
			assertEquals("party1", c1.getAffiliation());
			
			c2.setAffiliation("party2");
			assertEquals("party2", c2.getAffiliation());
			
			c3.setAffiliation("party3");
			assertEquals("party3", c3.getAffiliation());
		}
		
		/**
		 * verify that setCuisine method and getCuisine method are working appropriately
		 */
		
		public void testSetCuisine() {
			c1.setCuisine("chinese");
			assertEquals("chinese", c1.getCuisine());
			
			c2.setCuisine("Comfort food");
			assertEquals("Comfort food", c2.getCuisine());
			
			c3.setCuisine("3");
			assertEquals("3", c3.getCuisine());
		}
		
		/**
		 * verify that null input to setName method results in test failure
		 */
		
		public void testIllegalInputToSetName() {
			c1.setName(" ");
			fail();		
		}

		/**
		 * verify that null input to setAffiliation method results in test failure
		 */
		
		public void testIllegalInputToSetAffiliation() {
			c1.setAffiliation(" ");
			fail();		
		}
		
		/**
		 * verify that null input to setAffiliation method results in test failure
		 */
		
		public void testIllegalInputToSetCuisine() {
			c1.setCuisine(" ");
			fail();		
		}
		
		
		
		/**
		 * verify that default voteCounter value is 0; verify functioning of getVoteCount method
		 */
		
		public void testVoteCounterDefault() {
			assertEquals(0, c1.getVoteCount());
			assertEquals(0, c2.getVoteCount());
			assertEquals(0, c3.getVoteCount());
		}
		
		/**
		 * verify that tallyVote method works; verify that tallying votes changes value of voteCounter as it is returned by the getVoteCount method
		 */
		
		public void testTallyVote() {
			c1.tallyVote();
			c1.tallyVote();
			c1.tallyVote();
			
			c2.tallyVote();
			
			
			assertEquals(3, c1.getVoteCount());
			assertEquals(1, c2.getVoteCount());
			assertEquals(0, c3.getVoteCount());
		}
		
		/**
		 * verify that toString method returns accurate content in correct format
		 */
		
		public void testToString() {
			assertEquals(c1.getName() + " - " + c1.getAffiliation(), c1.toString());
			assertEquals(c2.getName() + " - " + c2.getAffiliation(), c2.toString());
			assertEquals(c3.getName() + " - " + c3.getAffiliation(), c3.toString());
		}
		
		/**
		 * verify that compareTo method returns true if two candidates are the same and returns false if not
		 */
		
		public void testCompareTo() {
			//normal true
			assertTrue(c1.compareTo(c4));
			//boundary
			assertFalse(c1.compareTo(c5));
			//normal false
			assertFalse(c2.compareTo(c3));
		}
		
		/**
		 * verify that program accurately compares candidates by toStrings 
		 */
		
		public void compareToStrings() {
			assertEquals(c1.toString(), c4.toString());
			
			assertEquals(c1.toString(), c2.toString());
				fail();
		}
			
		/**
		 * verify that program accurately compares objects 
		 */
		
		public void compareCandidates(){
			assertSame(c1, c4);
			assertNotSame(c1, c2);
			assertNotSame(c4, c5);
		}
		

		/**
		 * verify that isDuplicate method accurately returns true is current object is already in the area and returns false otherwise
		 */
		public void testIsDuplicate() {

			ArrayList<Candidate> b1TesterList = new ArrayList<Candidate>(3);
			
			b1TesterList.add(c1);
			b1TesterList.add(c2);
			b1TesterList.add(c3);
			
			assertTrue(c1.isDuplicate(b1TesterList));
			assertTrue(c2.isDuplicate(b1TesterList));
			assertTrue(c3.isDuplicate(b1TesterList));
			assertTrue(c4.isDuplicate(b1TesterList));
			assertFalse(c5.isDuplicate(b1TesterList));
		}
			
		


		/**
		 * main method runs junit test for CandidateTester class using textui
		 * @param args
		 */
		
		public static void main(String args[]) {
			junit.textui.TestRunner.main(new String[] {"CandidateTester"});
		}
		
	}


		

