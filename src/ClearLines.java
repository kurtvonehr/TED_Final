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
 *---------------------------------------------------------------------*
 * ISSUES AND NOTES						      						   *
 *---------------------------------------------------------------------*
 *
 *
 *
 *---------------------------------------------------------------------*/

public class ClearLines implements ICommand {


	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		while(currentData.hasNext())
			currentData.remove();
		while(currentData.previousIndex() > 0)
			currentData.remove();
		currentData.previous();
		currentData.remove();
		
		// Return that method completed.
		return true;
	}


	@Override
	public void printCommandHelp() {
		// TODO Auto-generated method stub

	}

}
