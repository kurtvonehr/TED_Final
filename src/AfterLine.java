import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * AfterLine.java                 		           		       		   *
 *---------------------------------------------------------------------*
 *   Description - A command class used to insert a line of content	   *
 *   				After the current editing line.				  	   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/

public class AfterLine implements ICommand {

	//--------------------------------------------------------------//
	// Function Definitions					     					//
	//--------------------------------------------------------------//

	@Override
	/* Executes a file load sequence if required. */
	public boolean executeCommand(String command, 
								ListIterator<String> currentData) {
		
		// --- Variable Declarations  ---------------------------//
		
		/* The text to insert into the document. */
		String insertedText;
		
		// --- Main Routine -------------------------------------//
		
		// Print the help command.
		if (command.equals ("i -h"))
			printCommandHelp ();

		// Execute the command.
		else
		{
			// Extract the content to be added.
			insertedText = command.substring(1,command.length());
			
			// Insert the content in.
			if(currentData.hasNext())
				currentData.add(insertedText);
			
			else
				currentData.add(insertedText);
		}
		
		// Return that method completed.
		return true;
		
	}

	//--------------------------------------------------------------//
	
	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {
		
		System.out.println("------------------------------------------");
		System.out.println("i - Insert after Line");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Adds content after the current");
		System.out.println("line. ");
		System.out.println("Example command :");
		System.out.println("i Add this after the current line. ");
		System.out.println("------------------------------------------");
        
	}
	
	//--------------------------------------------------------------//

}
