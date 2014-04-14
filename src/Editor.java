import java.util.Iterator;
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
			
		// Error check that the command is valid format.
		if((input.length()>1 && input.charAt(1) == ' ') || 
												input.length() == 1) {
			
			// Go through and match a command to run.
			switch( input.charAt(0) ){
			
				// Insert before current line.
				case 'b':
				command = new BeforeLine();
				command.executeCommand(input, CurrentLine);
				break;
				
				// Insert after current line.
				case 'i':
			
				break;
				
				// Move current line down a position.
				case 'm':
					
				break;
			
				// Move current line up 1 position.
				case 'u':
			
				break;
			
				// Remove the current line.
				case 'r':
					
				break;
			
				// Display the project buffer.
				case 'd':
					
				break;
				
				// Clear and remove all lines in buffer.
				case 'c':
					
				break;
				
				// Save file contents to a file directory.
				case 's':
					
				break;
			
				// Load a files contents from a directory.
				case 'l':
					
				break;
				
				// Display list of commands.
				case 'h':
					
				break;
			
				// Exit the editor.
				case 'x':
					
				break;
				
				// Invalid command entered.
				default:
					System.out.println("Incorrect Input Format. \nShould be of form: [command] [data_entry]");
					System.out.print("\n=> ");
					break;
			}
			
			// Update the list size.
			documentLineCount = textData.size();
			
		}
		
		// Nothing was entered into the buffer.
		else{
			System.out.println("Command does not match an existing command, enter 'h' for help. ");
			System.out.print("\n=> ");
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

		for(int i = 0; i<documentLineCount;i++){
			
			System.out.println();
		}

	}
	
	
	/*****************************************************************
	 * @Description - A method utilized to clear the console of all 
	 * visible content on the screen.
	 *
	 * @Returns - (N/A)
	 *
	 ****************************************************************/
	public final static void clearConsole()
	{
	    //Push old editor out of visible site on terminal.
	    for(int i=0;i<30;i++){
	    	System.out.println();
	    }
	}
	
	//--------------------------------------------------------------// 

}
