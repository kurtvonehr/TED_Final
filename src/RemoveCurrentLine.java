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
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		int movedLine;
		boolean error = false;
		String insertedText;
	
		if(command.length() == 1){
			if(currentData.hasPrevious() && currentData.previousIndex() > 0){
					currentData.previous();
					currentData.remove();
			}
		}
		else{
			insertedText = command.substring(2,command.length());
			if(insertedText.matches("[0-9].*")){
				try{
					movedLine = Integer.parseInt(insertedText);
					for(int i = 0; i < movedLine; i++)
						if(currentData.hasPrevious() && currentData.previousIndex() > 0){
							currentData.previous();
							currentData.remove();
						}
				}
				catch(NumberFormatException e){
					System.out.println("Please enter a valid number");
					error = true;
				}
			}
			else{
				System.out.println("Please enter a valid number");
				error = true;
			}
		}
		// Return that method completed.
		return error;
		
	}
	
	
	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {
		// TODO PRINT COMMAND HELP

	}

	//--------------------------------------------------------------//

}
