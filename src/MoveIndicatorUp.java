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
 *---------------------------------------------------------------------*
 * ISSUES AND NOTES						      						   *
 *---------------------------------------------------------------------*
 *
 *
 *
 *---------------------------------------------------------------------*/


public class MoveIndicatorUp implements ICommand {

	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
	
		if(currentData.hasPrevious() && currentData.previousIndex() > 0){
				currentData.previous();
		}
		
		// Return that method completed.
		return true;
		
	}
	
	@Override
	public void printCommandHelp() {
		// TODO Auto-generated method stub

	}

}
