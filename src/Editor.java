import java.util.LinkedList;
import java.util.ListIterator;

/*--------------------------------------------------------------------*
* Editor.java                            		    	         	  *
*---------------------------------------------------------------------*
*  Description - The core runtime class that coordinates and executes  *
*   the commands and tasks assigned by the user through the command   *
*   	line. All commands are called and are executed through 		  *
*   						  this class.							  *
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

public class Editor implements IEditor {
	
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	/* The length in textual lines the document has. */
	int documentLineCount;
	
	/* linked list containing each line of the document. */
	LinkedList <String> textData;	
	
	/* Current line that the commands are operating on. */
    ListIterator<String> CurrentLine;
    
    /* Generic command */
    ICommand command;
    
    boolean error = false;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//
	
	
	/*****************************************************************
	 * @Description - The default constructor for the command line 
	 * text editor. This configures and sets up the linked list for 
	 * the editor.
	 *
	 * @Returns - (N/A)
	 *
	 ****************************************************************/
	public Editor () {
		
		// Build the linked list.
		textData = new LinkedList<String> ();
		CurrentLine = textData.listIterator();

		// Configure the file editor.
		documentLineCount = 0;
		
	}
	
	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------// 
	
	/*****************************************************************
	 * @Description - A method used to execute input commands entered
	 * by the user. It also will display command input errors if
	 * needed.
	 *
	 * @param The text command entered in by the user through the 
	 * command line.
	 *
	 * @Returns - (N/A)
	 *
	 ****************************************************************/
	@Override
	public void processCommand(String input) {
		
        	 // --- Variable Declarations  ---------------------------//

			
		/* The identifier received for the command to be executed. */
		char commandID;
		
		/* Keeps track of document modifications for saving. */
		boolean docChange = false;
		
		// --- Main Routine -------------------------------------//

		// Error check that the command is valid.
		if((input.length() > 1 && input.charAt(1) == ' ') || 
												input.length() == 1) {
			
			error = false;
			// Extract the first character from the command.
			commandID = input.charAt(0);
			commandID = Character.toLowerCase(commandID);
			
			// Go through and match a command to run.
			switch( commandID ){
			
				// Insert before current line.
				case 'b':
				command = new BeforeLine();
				command.executeCommand(input, CurrentLine);
				break;
				
				// Insert after current line.
				case 'i':
					command = new AfterLine();
					command.executeCommand(input, CurrentLine);
				break;
				
				// Move current line down a position.
				case 'm':
					command = new MoveIndicatorDown ();
					command.executeCommand(input, CurrentLine);
				break;
			
				// Move current line up 1 position.
				case 'u':
					command = new MoveIndicatorUp ();
					command.executeCommand(input, CurrentLine);
				break;
			
				// Remove the current line.
				case 'r':
					command = new RemoveCurrentLine ();
					command.executeCommand(input, CurrentLine);
				break;
			
				// Display the project buffer.
				case 'd':
					command = new DisplayAllLines ();
					command.executeCommand(input, CurrentLine);
				break;
				
				// Clear and remove all lines in buffer.
				case 'c':
					command = new ClearLines ();
					command.executeCommand(input, CurrentLine);
				break;
				
				// Save file contents to a file directory.
				case 's':
					command = new SaveFile ();
					docChange = command.executeCommand(input, 
									CurrentLine) ? false : true;
				break;
			
				// Load a files contents from a directory.
				case 'l':
					command = new LoadFile ();
					command.executeCommand(input, CurrentLine);
				break;
				
				// Display list of commands.
				case 'h':
					error = true;
					command = new Help ();
					command.executeCommand(input, CurrentLine);
				break;
			
				// Exit the editor.
				case 'x':
					
					// Check and see if the document has yet to be saved.
					if (docChange)
					{
						System.out.println ("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						System.out.println ("  The document has yet to be saved."
								+ "\n Would you like to save it before you exit?");
						System.out.println ("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						
						//TODO ADD USER PROMPT FOR RESULT
						
					}
					
					else
					{
						System.out.println("Good bye!");
						System.exit(0);
					}
					
				break;
				
				// Insert after last line. 
				case 'e':
					command = new AfterLast ();
					command.executeCommand(input, CurrentLine);
				break;
				
				// Invalid command entered.
				default:
					 error = true;
					 System.out.println("Incorrect Input Format. "
					 		+ "\nShould be of form: [command] [data_entry]");
					 System.out.print("\n: ");
					 break;
			}
			
			// Update document flag data.
			documentLineCount = textData.size();
			
			// Update the edit flag.
			docChange = commandID == 's' ? true : docChange;

		}
		
		// Nothing was entered into the buffer.
		else{
			error = true;
 			System.out.println("Command does not match an existing command, enter 'h' for help. ");
 			System.out.print("\n: ");
		}
		
	}

	/*****************************************************************
	 * @Description - A method utilized to return the total number of 
	 * lines in the document being edited.
	 *
	 * @param (N/A)
	 *
	 * @Returns - The total number of lines in the document (Int).
	 *
	 ****************************************************************/
	@Override
	public int getDocumentLineCount() {
		
		// Update the list size.
		return documentLineCount;
		
	}
	
	/*****************************************************************
	 * @Description - A method called to draw the linked list of text
	 * object lines of the document.
	 *
	 * @Returns - (N/A)
	 *
	 ****************************************************************/
	public void drawDocument() {

		clearConsole();
		
		int restoreCurrentLine = CurrentLine.previousIndex();

		//move iterator to front of list
		while(CurrentLine.previousIndex() != -1)
			CurrentLine.previous();
		
		//Program Title
		System.out.print("TED - A Text Editor \n\n");
		
		//Move through entire list and print each string
		for(int i = 0; i<documentLineCount;i++){
			if(restoreCurrentLine == i)
				System.out.println("" + (i+1) + " => " + CurrentLine.next());
			else
				System.out.println("" + (i+1) + "    " + CurrentLine.next());
		}
		
		//restore current line back to it's previous index
		while(CurrentLine.previousIndex() != restoreCurrentLine)
			CurrentLine.previous();
		

	}
	
	
	/*****************************************************************
	 * @Description - A method utilized to clear the console of all 
	 * visible content on the screen.
	 *
	 * @Returns - (N/A)
	 *
	 ****************************************************************/
	public final void clearConsole()
	{
	    //Push old editor out of visible site on terminal.
	    for(int i=0;i<30;i++){
	    	System.out.println();
	    }
	}
	

	public boolean isError() {
		return error;
	}
	
	//--------------------------------------------------------------// 

}
