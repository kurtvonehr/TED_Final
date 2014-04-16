import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
*---------------------------------------------------------------------*/

public class LoadFile implements ICommand {
	
	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------//

	@Override
	/* Executes a file load sequence if required. */
	public boolean executeCommand (String command, 
								ListIterator<String> currentData) {
		
        // --- Variable Declarations  ---------------------------//
		
		/* The array of the broken up command for reading in. */
		String commandSpilt;
		
		/* The file stream reader that scans the file in. */
		Scanner fileRead;
		
		/* Whether or not the command was successful. */
		boolean commandSuccess = false;
		
		// --- Main Routine -------------------------------------//
		
		// Split the command and try to open and read the file.	
		commandSpilt = command.substring(1, command.length());
		
		
		// Print the help command.
		if (command.equals ("l -h"))
		{
			printCommandHelp ();
			commandSuccess = true;
		}
		
		// Process the file in.
		else
		{
			try(BufferedReader bufferFile = new BufferedReader
								( new FileReader(commandSpilt) ) ) {
				
				String textLine = bufferFile.readLine();
				// Add contents to linked list.
				while (textLine != null){
					currentData.add(textLine);
					textLine = bufferFile.readLine();
				}
				
				//move iterator to front of list
				while(currentData.previousIndex() != -1)
					currentData.previous();
				
				currentData.next();
				
				// Close the file stream.
				bufferFile.close();
				
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

	//--------------------------------------------------------------//
	
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

	//--------------------------------------------------------------//

}
