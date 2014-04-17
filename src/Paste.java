import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * Paste.java                 		           		       		   	   *
 *---------------------------------------------------------------------*
 *    Description - A command class used to execute a cut and paste	   *
 *      command. This half is used to paste the contents of the clip   *
 *          			 board to the document.						   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/

public class Paste {
	
	//--------------------------------------------------------------//
	// Function Definitions					     					//
	//--------------------------------------------------------------//

	/* Executes a file load sequence if required. */
	public boolean executeCommand(String command,
			ListIterator<String> currentData, ListIterator <String>
											clipBoard) {
	
		
		// Print the help command.
		if (command.equals ("p -h"))
			printCommandHelp ();
		
		// Run command.
		else
		{
			// Traverse to start of clip board.
			while(clipBoard.previousIndex() != 0)
				clipBoard.previous();
			
			// Put at the zeroth element.
			clipBoard.previous();
			
			// Copy elements over.
			while (clipBoard.hasNext())
				currentData.add(clipBoard.next());
		}
		
		// Return the result of the command.
		return true;
		
	}
	
	//--------------------------------------------------------------//
	
	/* Prints out command help information. */
	public void printCommandHelp() {
		
		System.out.println("------------------------------------------");
		System.out.println("p - Paste from clipboard");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Pastes a block of text from the ");
		System.out.println("clipboard into the document at the current");
		System.out.println("line.");
		System.out.println("Example command");
		System.out.println("p");
		System.out.println("------------------------------------------");

	}
	
	//--------------------------------------------------------------//

}
