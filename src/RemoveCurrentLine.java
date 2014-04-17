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
 *---------------------------------------------------------------------*/

public class RemoveCurrentLine implements ICommand {

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
		boolean error = true;
		
		/* The text of a given line being pointed to. */
		String insertedText;
		
		// --- Main Routine -------------------------------------//
		
		// Print the help command.
		if (command.equals ("r -h"))
		{
			printCommandHelp ();
			error = false;
		}
	
		// Remove just this line.
		else if(command.length() == 1) {
			if(currentData.hasPrevious()) {
					currentData.previous(); 
					currentData.remove();
					if(currentData.hasNext())
						currentData.next();
					error = false;
			}
			else if(currentData.previousIndex() == -1)
				currentData.next();
		}
		
		// Remove a given line based off its authenticity.
		else
		{
			
			insertedText = command.substring(2,command.length());
			
			// Error Check the input.
			if(insertedText.matches("[0-9].*"))
			{
				
				try {
					movedLine = Integer.parseInt(insertedText);
					
					for(int i = 0; i < movedLine; i++)
					{
						if(currentData.hasPrevious() && 
									currentData.previousIndex() > 0) {
							currentData.previous();
							currentData.remove();
						}
					}
					
					error = false;
				}
				
				catch(NumberFormatException e)
				{
					System.out.println("!!> Oops, the command"
							+ " was not formated correctly.\n Type r"
							+ " -h to get command help.");
					error = true;
				}
			}
			
			else{
				System.out.println("!!> Oops, the command"
						+ " was not formated correctly.\n Type r"
						+ " -h to get command help.");
				error = true;
			}
			
		}
		
		// Return that method completed.
		return error;
		
	}
	
	//--------------------------------------------------------------//
	
	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {
		
		System.out.println("------------------------------------------");
		System.out.println("r - Remove Current Line");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Can either remove the current line");
		System.out.println("being edited or a specific line provided");
		System.out.println("a legitimate numeric line value.");
		System.out.println("Example commands : \n\n To Remove Current:");
		System.out.println("r \n\n To Remove Specific line :");
		System.out.println("r ");
		System.out.println("------------------------------------------");

	}

	//--------------------------------------------------------------//

}
