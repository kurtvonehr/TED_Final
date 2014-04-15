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
 *---------------------------------------------------------------------*
 * ISSUES AND NOTES						      						   *
 *---------------------------------------------------------------------*
 *
 *
 *
 *---------------------------------------------------------------------*/


public class MoveIndicatorDown implements ICommand {

	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		int movedLine;
		boolean error = false;
		String insertedText;
	
		if(command.length() == 1){
			if(currentData.hasNext() && currentData.nextIndex() > 0){
					currentData.next();
			}
		}
		else{
			insertedText = command.substring(2,command.length());
			if(insertedText.matches("[0-9].*")){
				try{
					movedLine = Integer.parseInt(insertedText);
					for(int i = 0; i < movedLine; i++)
						if(currentData.hasNext() && currentData.nextIndex() > 0)
							currentData.next();
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
	public void printCommandHelp() {
		// TODO Auto-generated method stub

	}

}
