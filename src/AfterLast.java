import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * AfterLast.java                 		           		       		   *
 *---------------------------------------------------------------------*
 *   Description - A command class used to insert a line of content	   *
 *   		  After the last line in the entire document.		  	   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/

public class AfterLast implements ICommand {
	
	//--------------------------------------------------------------//
	// Function Definitions					     					//
	//--------------------------------------------------------------//

	@Override
	/* Executes a file load sequence if required. */
	public boolean executeCommand(String command,
									ListIterator<String> currentData) {
		
		// Print the help command.
		if (command.equals ("e -h"))
			printCommandHelp ();
		
		// Run command.
		else
		{
			// Traverse to the end of the array.
			while(currentData.hasNext())
				currentData.next();
			
			// Insert content into the array.
			String insertedText = command.substring(1,command.length());
			currentData.add(insertedText);
		}
		
		// Return the result of the command.
		return true;
		
	}
	
	//--------------------------------------------------------------//
	
	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {
		
		System.out.println("------------------------------------------");
		System.out.println("e - Insert after Last Line");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Adds content after the last line.");
		System.out.println("Example command :");
		System.out.println("e Add this after the LAST line. ");
		System.out.println("------------------------------------------");

	}
	
	//--------------------------------------------------------------//

}
