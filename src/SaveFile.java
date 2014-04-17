import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ListIterator;
import java.util.regex.PatternSyntaxException;

/*---------------------------------------------------------------------*
 * SaveFile.java                            		    	       	   *
 *---------------------------------------------------------------------*
 *  Description - A command class used to write files created in the   *
 *  		TED editor. The linked list will be iterated through and   *
 *  					all lines will be published to a file.		   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/

public class SaveFile implements ICommand {
	
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
		
		/* The file object to be read in. */
		File bufferFile;
		
		/* The file stream editor that prints to the file. */
		PrintWriter fileWrite;
		
		/* Whether or not the command was successful. */
		boolean commandSuccess = true;
		
		// --- Main Routine -------------------------------------//
		
		// Print the help command.
		if (command.equals ("s -h"))
		{
			printCommandHelp ();
			commandSuccess = true;
		}
		
		// Process the file in.
		else
		{
			try {
				// Split the command and try to open and read the file.
				commandSpilt = command.substring(1, command.length());
				
				if (commandSpilt.length() >= 1)
					throw new Exception();
				
				bufferFile = new File (commandSpilt);
				
				// open the file stream for reading.
				fileWrite = new PrintWriter (bufferFile);
				
				//move iterator to front of list
				while(currentData.previousIndex() != -1)
					currentData.previous();
				
				// Add contents to linked list.
				while (currentData.hasNext())
					fileWrite.println (currentData.next());
				
				// Close the file stream.
				fileWrite.close();
				
				commandSuccess = true;
			}
			
			// Corrupt file stream error.
			catch (IOException e) {
				System.out.println("!!> Oops, There was an error "
	                      + "trying to write to the file you entered.");
			}
			
			// Incorrectly formated command error.
			catch (Exception e) {
				System.out.println("!!> Oops, the command"
                   + " was not formated correctly.\n Type s -h to get "
                   + "command help.");
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
		System.out.println("s - Save File");
		System.out.println("------------------------------------------");
		System.out.println("Desc - Saves working contents that have");
		System.out.println("being edited to a file of your choice.");
		System.out.println("Example command : (Quotes Required)");
		System.out.println("s \"dir1\\myfile.txt\" ");
		System.out.println("------------------------------------------");
        
	}
	
	//--------------------------------------------------------------//
	
}
