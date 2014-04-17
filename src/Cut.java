import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * Cut.java                 		           		       		   	   *
 *---------------------------------------------------------------------*
 *    Description - A command class used to execute a cut and paste	   *
 *      command. This half is used to cut the contents to the clip     *
 *          			 board from the document.					   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/

public class Cut {
	
	//--------------------------------------------------------------//
	// Function Definitions					     					//
	//--------------------------------------------------------------//

	/* Executes a file load sequence if required. */
	public boolean executeCommand(String command,
			ListIterator<String> currentData, ListIterator <String>
											clipBoard, int listSize) {
		
	
        // --- Variable Declarations  ---------------------------//
		
		/* The array of the broken up command for reading in. */
		ArrayList <String> commandSpilt;
		
		/* Whether or not the command was successful. */
		boolean commandSuccess = false;
		
		/* The start position to copy into the linked list. */
		int fromPos = 0;
		
		/* The end position to copy into the linked list. */
		int toPos = 0;
		
		// --- Main Routine -------------------------------------//
		
		// Print the help command.
		if (command.equals ("o -h"))
		{
			printCommandHelp ();
			commandSuccess = true;
		}
		
		// Run command.
		else
		{
			try {
				// Split the command and try to open and read the file.
				commandSpilt = new ArrayList <String> ( Arrays.asList
											  ( command.split(" ") ) );
				
				// Check the input of the command is proper.
				if (commandSpilt.size() == 3 )
				{
					
					// Get the from and two positions.
					fromPos = Integer.parseInt( commandSpilt.get(1) );
					toPos = Integer.parseInt( commandSpilt.get(2) );
					
					// check and make sure its within bounds.
					if (fromPos > -1 && toPos > -1 && toPos < listSize 
													&& fromPos <= toPos)
					{
							
						// Scrub the clip board.
						while(clipBoard.hasNext())
							clipBoard.remove();
						
						while(clipBoard.previousIndex() > 0)
							clipBoard.remove();
						
						//TODO ERROR MAY BE HERE
						if( currentData.hasPrevious() ) {
							clipBoard.previous();
							clipBoard.remove();
						} 
						
						// Traverse to the start of the zone to be copied.
						while(currentData.previousIndex() != 0)
							currentData.previous();
						
						// Put at the zeroth element.
						currentData.previous();
						
						// Now traverse to the start.
						while (currentData.nextIndex() != fromPos - 1)
							currentData.next();
						
						
						// begin cutting the elements out.
						for (int a = fromPos; a < toPos; a++)
						{
							clipBoard.add(currentData.next());
							currentData.remove();
						}
						
						commandSuccess = true;

					}
					else 
						throw new Exception ("Command in improper format.");
				}
				
				else 
					throw new Exception ("Command in improper format.");
				
				
			}
			
			catch (Exception e) 
			{
				System.out.println("!!> Oops, the command"
				+ " was not formated correctly.\n Type o -h to get "
		        + "command help.");
				e.printStackTrace();
			}
		}
		
		// Return the result of the command.
		return commandSuccess;
		
	}
	
	//--------------------------------------------------------------//
	
	/* Prints out command help information. */
	public void printCommandHelp() {
		
		System.out.println("------------------------------------------");
		System.out.println("o - Cut to clipboard");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Cuts a block of text to a clipboard");
		System.out.println("which can then be pasted into another part");
		System.out.println(" 			 of the document.");
		System.out.println("== Parameters ============================");
		System.out.println("# - Line to start");
		System.out.println("$ - Line to end");
		System.out.println("Example command : (o # $)");
		System.out.println("o 12 15");
		System.out.println("------------------------------------------");

	}
	
	//--------------------------------------------------------------//

}
