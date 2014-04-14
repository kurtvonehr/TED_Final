import java.util.LinkedList;
import java.util.ListIterator;

/*--------------------------------------------------------------------*
* Command.java                            		    	         	  *
*---------------------------------------------------------------------*
* Description - The core abstract class that all commands inherate    *
*   from. This file implements some basic command attributes and 	  *
* parameters. However it is up the the derived class to fill in the   *
* 								rest.								  *
*---------------------------------------------------------------------*
* Project: Project 4 : TED	 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt						          *
* Date Of Creation: 4 - 6 - 2014                                      *
*---------------------------------------------------------------------*
* ISSUES AND NOTES						      						  *	                                      
*---------------------------------------------------------------------*
* 
*                                 
*                                 
*---------------------------------------------------------------------*/

public class Command implements ICommand {


     //---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	//error code #
	int error;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	

	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------// 
	
	@Override
	
	
	public boolean executeCommand(String input, ListIterator<String> currentData) {
		
		char command = input.charAt(0);
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printCommandHelp() {
		// TODO Auto-generated method stub
		
	}
	
	
	//Originally had thought there would be more errors,
	//file handling exceptions can be dealt with within
	//the IO util for the 's' and 'l' commands
	public void printError(){
	
		switch(error){
		
		case 0:
			System.out.println("Incorrect Input Format. \nShould be of form: [command] [data_entry]");
			System.out.print("\n=> ");
			break;
		case 1:
			System.out.println("Command does not match an existing command, enter 'h' for help. ");
			System.out.print("\n=> ");
			break;
		}
	}
	//--------------------------------------------------------------// 

	
}
