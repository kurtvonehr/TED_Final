import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/*--------------------------------------------------------------------*
* LoadFile.java                            		    	         	  *
*---------------------------------------------------------------------*
*  Description - A command class used to read in files to the TED	  *
*  	  editor for reading/writing. The contents read in will be 		  *
*  				put into a linked list for editing.				 	  *
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

public class LoadFile implements ICommand {
	
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//

	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//
	
	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------//

	@Override
	/* Executes a file load sequence if required. */
	public boolean executeCommand (String command, 
								ListIterator<String> currentData) {
		
        // --- Variable Declarations  ---------------------------//
		
		/* The array of the broken up command for reading in. */
		String commandSpilt [];
		
		/* The file object to be read in. */
		File bufferFile;
		
		/* The file stream reader that scans the file in. */
		Scanner fileRead;
		
		/* Whether or not the command was successful. */
		boolean commandSuccess = false;
		
		// --- Main Routine -------------------------------------//
		
		
		// Print the help command.
		if (command.equals ("l -h"))
		{
			printCommandHelp ();
			commandSuccess = true;
		}
		
		// Process the file in.
		else
		{
			try {
				
				// Split the command and try to open and read the file.	
				commandSpilt = command.split("\"");
				
				bufferFile = new File (commandSpilt[1]);
				
				// open the file stream for reading.
				fileRead = new Scanner (bufferFile);
				
				// Add contents to linked list.
				while (fileRead.hasNextLine())
					currentData.add( fileRead.nextLine() );
				
				// Close the file stream.
				fileRead.close();
				
			} 
			
			// Incorrectly formated command error.
			catch (PatternSyntaxException e) {
				System.out.println("!!> Oops, the command"
				+ " was not formated correctly.\n Type l -h to get command"
				+ " help.");
				e.printStackTrace();
			}
			
			// File not found error.
			catch (FileNotFoundException e) {
				System.out.println("!!> Oops, The file you entered "
						+ "was not found.\n Please make sure the file "
						+ "exists. ");
				e.printStackTrace();
			}
			
			// Corrupt file stream error.
			catch (IOException e) {
				System.out.println("!!> Oops, There was an error "
						+ "trying to open the file you entered.");
				e.printStackTrace();
			}
		}
		
		// Return the result of the file operation.
		return commandSuccess;
		
	}

	@Override
	/* Prints out command help information. */
	public void printCommandHelp() {
		
		System.out.println("------------------------------------------");
		System.out.println("l - Load File");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Loads a file in for editing.\n");
		System.out.println("Example command : (Quotes Required)");
		System.out.println("l \"dir1\\myfile.txt\" ");
		System.out.println("------------------------------------------");

	}

	@Override
	public void printError() {
		// TODO Auto-generated method stub
		
	}

}
