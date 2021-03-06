import java.util.LinkedList;
import java.util.ListIterator;

/*--------------------------------------------------------------------*
* ICommand.java                            		    	         	  *
*---------------------------------------------------------------------*
* Description - An interface used to lay the foundation for the 	  *
* all the commands available in the text editor. All Commands must 	  *
* model themselves after this interface to be usable in the TED.      *
*---------------------------------------------------------------------*
* Project: Project 4 : TED	 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt						          *
* Date Of Creation: 4 - 6 - 2014                                      *                              
*---------------------------------------------------------------------*/

public interface ICommand {
	
	//--------------------------------------------------------------//	
	// Core Function Decelerations			     					//
	//--------------------------------------------------------------// 
	
	/* Called to execute the command*/
	public boolean executeCommand (String command, 
									ListIterator<String> currentData);
	
	/* This is called when the user asks for a command help list. */
	public void printCommandHelp ();
	
	//--------------------------------------------------------------// 

}
