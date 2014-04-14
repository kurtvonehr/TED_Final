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
		
		if(currentData.hasNext()){
			currentData.next();
		}
		
		// Return that method completed.
		return true;
		
	}

	@Override
	public void printCommandHelp() {
		// TODO Auto-generated method stub

	}

}
