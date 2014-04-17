import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * ClearLines.java                            		       			   *
 *---------------------------------------------------------------------*
 *   Description - A command class used to clear the file of all of	   *
 *   	its contents. Basically starting the buffer from scratch.	   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/

public class ClearLines implements ICommand {

	//--------------------------------------------------------------//
	// Function Definitions					     					//
	//--------------------------------------------------------------//

	@Override
	public boolean executeCommand(String command, 
								ListIterator<String> currentData) {
		
		// Print the help command.
		if (command.equals ("c -h"))
			printCommandHelp ();
		
		else
		{
			// Loop through and remove lines.
			while(currentData.hasNext())
				 currentData.remove();
			while(currentData.previousIndex() > 0){
				currentData.previous();
				if(currentData.next() != null)
					currentData.remove();
			}
				 currentData.previous();
				 currentData.remove();
		}
		
		
		// Return that method completed.
		return true;
	}

	//--------------------------------------------------------------//
	
	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {
		
		System.out.println("------------------------------------------");
		System.out.println("c - Clear All Lines");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Clears all the lines in the buffer");
		System.out.println("if saved and shifts the Indicator");
		System.out.println("accordingly.");
		System.out.println("Example command :");
		System.out.println("c ");
		System.out.println("------------------------------------------");
        
	}
	
	//--------------------------------------------------------------//
	

}
