import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * RemoveCurrentLine.java                            		       	   *
 *---------------------------------------------------------------------*
 *  Description - A command class used to remove a full text line of   *
 *   		code at the current line that is being edited.			   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*
 * ISSUES AND NOTES						      						   *
 *---------------------------------------------------------------------*
 *
 *
 *
 *---------------------------------------------------------------------*/

public class RemoveCurrentLine implements ICommand {

	//--------------------------------------------------------------//
	// Function Definitions					     					//
	//--------------------------------------------------------------//

	@Override
	/* Executes a file load sequence if required. */
	public boolean executeCommand(String command, 
										ListIterator<String> currentData) {
		
		if(currentData.hasNext()){
			currentData.previous();
			currentData.remove();
			currentData.next();
		}
		else if(currentData.hasPrevious()){
			currentData.previous();
			currentData.remove();
		}
		
		// Return that method completed.
		return true;
		
	}
	
	
	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {
		// TODO PRINT COMMAND HELP

	}

	//--------------------------------------------------------------//

}
