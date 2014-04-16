import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * Help.java          				                  		       	   *
 *---------------------------------------------------------------------*
 *  Description - A command class used display the list of commands    *
 *  						for the ted editor.						   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/

public class Help implements ICommand {

	//--------------------------------------------------------------//
	// Function Definitions					     					//
	//--------------------------------------------------------------//
	
	@Override
	/* Executes a file load sequence if required. */
	public boolean executeCommand(String command, 
										ListIterator<String> currentData) {
		
		// Print title block for commands.
		System.out.println("**********************************************************");
		System.out.println("Help Menu");
		System.out.println("**********************************************************");
		System.out.println("Available Commands: \n\n");
		System.out.println("	b <Sentence> - Insert sentence before the current line\n");
		System.out.println("	i <Sentence> - Insert sentence after the current line\n");
		System.out.println("	e <Sentence> - Insert sentence after the last line\n");
		System.out.println("	m [#] - Move current line down one line or optional "
				+ "\n	number of lines\n");
		System.out.println("	u [#] - Move current line up one line or optional number "
				+ "\n	of lines\n");
		System.out.println("	d#* - Display from line # to * (inclusive)\n");
		System.out.println("	r - Remove the current line\n");
		System.out.println("	c - Clear all lines from file (only if saved)\n");
		System.out.println("	s <filename> - Save the contents to the specified "
				+ "\n	text file\n");
		System.out.println("	l <filename> - Load the contents from the specified text"
				+ "\n	file (only if saved)\n");
		System.out.println("	h - Display Help Menu\n");
		System.out.println("	x - Exit the editor (only if saved)\n\n");
		System.out.println("**********************************************************\n");
		System.out.println(":");
		
		// Return that method completed.
		return true;
	}
	
	//--------------------------------------------------------------//

	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {

	}
	
	//--------------------------------------------------------------//


}
