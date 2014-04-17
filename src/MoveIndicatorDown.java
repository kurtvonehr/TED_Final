import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * MoveIndicatorDown.java                            		       	   *
 *---------------------------------------------------------------------*
 *  Description - A command class used to shift the current line down  *
 *  				one to the next line in the file.				   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/


public class MoveIndicatorDown implements ICommand {
	
	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------//

	@Override
	/* Executes a file load sequence if required. */
	public boolean executeCommand(String command, 
									ListIterator<String> currentData) {
		
        // --- Variable Declarations  ---------------------------//
		
		/* The numerical line pointer for the remove operation. */
		int movedLine;
		
		/* The boolean flag status for the success of the command. */
		boolean commandSuccess = false;
		
		/* The text of a given line being pointed to. */
		String insertedText;
		
		// --- Main Routine -------------------------------------//
		
		// Print the help command.
		if (command.equals ("m -h"))
		{
			printCommandHelp ();
			commandSuccess = true;
		}
	
		// Shift down just one line.
		else if(command.length() == 1){
			if(currentData.hasNext() && currentData.nextIndex() > 0) 
					currentData.next();
			
		}
		
		// Shift down a number of lines while error checking.
		else
		{
			insertedText = command.substring(2,command.length());
			
			if(insertedText.matches("[0-9].*")) {
				
				try {
					movedLine = Integer.parseInt(insertedText);
					
					for(int i = 0; i < movedLine; i++)
						if(currentData.hasNext() && 
										   currentData.nextIndex() > 0)
							currentData.next();
					
					commandSuccess = true;
				}
				
				catch(NumberFormatException e)
				{
					System.out.println("!!> Oops, the command"
							+ " was not formated correctly.\n Type m"
							+ " -h to get command help.");			
				}
			}
			
			else
				System.out.println("!!> Oops, the command"
						+ " was not formated correctly.\n Type m"
						+ " -h to get command help.");
			
		}
		// Return that method completed.
		return commandSuccess;
		
	}

	//--------------------------------------------------------------//
	
	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {

		System.out.println("------------------------------------------");
		System.out.println("m - Move Indicator Down");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Shifts down the current line being ");
		System.out.println("edited or to a specific number of");
		System.out.println("positions up.");
		System.out.println("Example commands : \n\n To go down one:");
		System.out.println("m \n\n To go down a number of lines:");
		System.out.println("m 12 ");
		System.out.println("------------------------------------------");
		
	}
	
	//--------------------------------------------------------------//

}
