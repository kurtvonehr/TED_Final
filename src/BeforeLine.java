import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * BeforeLine.java                 		           		       		   *
 *---------------------------------------------------------------------*
 *   Description - A command class used to insert a line of content	   *
 *   				before the current editing line.			  	   *
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


public class BeforeLine implements ICommand {


	@Override
	public boolean executeCommand(String command, 
										ListIterator<String> currentData) {
		
		String insertedText = command.substring(1,command.length());
		if(currentData.hasPrevious()){
			currentData.previous();
			currentData.add(insertedText);
		}
		else
			currentData.add(insertedText);
		
		// Return that method completed.
		return true;
		
	}

	@Override
	public void printCommandHelp() {
		// TODO Auto-generated method stub

	}

}
