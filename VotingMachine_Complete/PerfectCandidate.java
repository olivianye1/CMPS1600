/**
 * The VotingMachine project is intended to create an interface that allows for the in-take of ballot 
 * information from a text file, the creation of an election ballot based off of information from 
 * the input file, the creation of candidates from the information taken from the input file, the facilitation
 * of voting, the calculation of election results, and the outputting of the election results to a specified
 * output file. This project will use a GUI to obtain the paths to the input and output files. This GUI will 
 * also be used to display candidate information to the voters and to accept and tally votes. Vote counts will 
 * not be displayed to voters. The results will only be visible on the front-end by viewing the output file. 
 * @author Olivia Nye
 * @class CMPS 1600 
 * @date 02/27/2019
 */
 

// YOU ARE NOT REQUIRED TO FULLY UNDERSTAND THIS CODE; READ IT BUT YOU MAY NOT
// MODIFY IT.

import java.io.IOException;
import javax.swing.JOptionPane;


public class PerfectCandidate
{
	public static void main(String[] args)
	{
		Ballot ballot = null;

		do
		{
			FileSelector inputSelector = new FileSelector(
				null, "Select Input File", "Path to input file", true);
			
			inputSelector.setVisible(true);
	
			String inputFilename = inputSelector.getSelectedFile();
	
			if (inputFilename == null)
			{
				return;
			}
	
			try
			{
				ballot = BallotReader.readBallot(inputFilename);
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null,
					"Could not open and read input file",
					"Input Error",
					JOptionPane.ERROR_MESSAGE);
			}
		}
		while (ballot == null);

		BallotDialog bf = new BallotDialog(null, ballot);
		bf.setVisible(true);

		FileSelector outputSelector = new FileSelector(
			null, "Select Output File", "Path to output file", false);
			
		outputSelector.setVisible(true);
	
		String outputFilename = outputSelector.getSelectedFile();

		if (outputFilename == null)
		{
			return;
		}

		try
		{
			ResultWriter.writeResults(outputFilename, ballot);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null,
				"Could not write results to output file",
				"Output Error",
				JOptionPane.ERROR_MESSAGE);
		}
	}
}