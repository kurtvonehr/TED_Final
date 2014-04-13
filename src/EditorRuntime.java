/*--------------------------------------------------------------------*
* EditorRuntime.java                            		         	  *
*---------------------------------------------------------------------*
* Description - This is the runtime object that is used at the start  *
*   to run process and execute editor commands to enable the user to  *
*    to have the complete ability to create, modify and maintain 	  *
*    			their documents from the application.				  *
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

import java.io.*;


public class EditorRuntime {
	 //---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	/* The tool used to read the input buffer from user.  */
    // Open the buffer reader.
	
	// Filename of text file
	static String filename = null;
	
    protected static BufferedReader inputReader = new BufferedReader (
    		new InputStreamReader (System.in) );
    
	/* The editor object used for processing commands. 	  */
	static Editor edit;
    
	// --- Main Routine -----------------------------------//

	
	//---------------------------------------------------------------//	
	// Core Runtime Method		                                     //
	//---------------------------------------------------------------//
	
	public static void main ( String[] args ) {
		
		// --- Variable Declarations  -------------------------//
		
		/* Controls whether the application continues to run. */
		boolean stayAlive = true;
		
		//determines if there is an error message, and holds
		//refreshing the display
		boolean errorMessage = false;
	    
		// Create the editor.
		edit = new Editor();
		
		// Print the application title block for the user at start.
		printApplicationHeader ();
		
		// Begin continuous loop until forced exit.
		while ( stayAlive )
		{
			if(!errorMessage){
				// Draw the document.
				System.out.print("\n=> ");
			}
			
			// Scan for a command. 
			try 
			{
				String input =  inputReader.readLine();
				edit.processCommand(input);
			}
			
			catch (IOException e) {
				
				//TODO TELL THERE WAS AN INPUT ERROR.
				System.out.println ("!!!> ");
				e.printStackTrace();
			}
		}
		
	}
	
	//---------------------------------------------------------------//	
	// Runtime Assistant Methods                                     //
	//---------------------------------------------------------------//
	
	public static void printApplicationHeader () {
		// TODO BUILD THIS.
		System.out.print("TED - A Text Editor \n\n");
		System.out.print("Enter File Name: ");
		try {
			filename = inputReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		edit.clearConsole();
		
		System.out.println("TED - A Text Editor \n\n" + filename + ".txt");
		
	}
	
	//---------------------------------------------------------------//
	
}
