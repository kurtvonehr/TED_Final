import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * AfterLast.java                 		           		       		   *
 *---------------------------------------------------------------------*
 *   Description - Exits program								  	   *
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

public class Exit implements ICommand {

	@Override
	public boolean executeCommand(String command,
										ListIterator<String> currentData) {
		// TODO Auto-generated method stub
		
		// Return that method completed.
		return true;
	}
	
	
	@Override
	public void printCommandHelp() {
		// TODO Auto-generated method stub

	}

}
