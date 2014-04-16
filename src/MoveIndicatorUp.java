import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * MoveIndicatorUp.java                            		       		   *
 *---------------------------------------------------------------------*
 *   Description - A command class used to shift the current line up   *
 *  				one to the next line in the file.				   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/

public class MoveIndicatorUp implements ICommand {
	
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
		if (command.equals ("u -h"))
		{
			printCommandHelp ();
			commandSuccess = true;
		}
		
		// Shift up the indicator just one line.
		if(command.length() == 1){
			if(currentData.hasPrevious() && 
								currentData.previousIndex() > 0) {
					currentData.previous();
			}
		}
		
		// Shift indicator up x number of lines.
		else
		{
			insertedText = command.substring(2,command.length());
			
			// Error check the input and execute the command.
			if(insertedText.matches("[0-9].*")) {
				try{
					movedLine = Integer.parseInt(insertedText);
					for(int i = 0; i < movedLine; i++)
						if(currentData.hasPrevious() && 
									currentData.previousIndex() > 0)
							currentData.previous();
					
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
			{
				System.out.println("!!> Oops, the command"
						+ " was not formated correctly.\n Type m"
						+ " -h to get command help.");
			}
		}
		
		// Return that method completed.
		return commandSuccess;
		
	}
	
	//--------------------------------------------------------------//
	
	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {

		System.out.println("------------------------------------------");
		System.out.println("u - Move Indicator Up");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Shifts up the current line being ");
		System.out.println("edited or to a specific number of");
		System.out.println("positions up.");
		System.out.println("Example commands : \n\n To go up one:");
		System.out.println("u \n\n To go up to a number of lines:");
		System.out.println("u 12 ");
		System.out.println("------------------------------------------");
		
	}
	
	//--------------------------------------------------------------//

}
