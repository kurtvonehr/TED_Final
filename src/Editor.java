import java.util.LinkedList;

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
	
	//Line count for the document
	int editLineCount;
	
	//Current line that the command applies to
	int currentLineNumber;
	
	//Contains the current line content
	String currentLineContent;
	
	/* Determines if were actively displaying a document. */
	boolean activeEditMode = false;
	
	/* Determines if were currently entering a command. */
	boolean activeCommandMode = true;
	
	//linked list for each line of the document
	LinkedList <String> textData = new LinkedList ();	
	
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//
	
	
	public Editor () {

		setCurrentLine(0);
		setEditLineCount(0);
		
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
	public boolean processCommand(String input) {

		boolean validCommand = true;
		//create a editor command instance
		Command editorCommand = new Command();

		// Determine the
			if((input.length()>1 && input.charAt(1) == ' ') || input.length() == 1){
			switch(command){
				case 'b':
					valid = true;
					break;
				case 'i':
					valid = true;
					break;
				case 'm':
					valid = true;
					break;
				case 'u':
					valid = true;
					break;
				case 'r':
					valid = true;
					break;
				case 'd':
					valid = true;
					break;
				case 'c':
					valid = true;
					break;
				case 's':
					valid = true;
					break;
				case 'l':
					valid = true;
					break;
				case 'h':
					valid = true;
					break;
				case 'x':
					valid = true;
					break;
				//no valid command char entered	
				default:
					System.out.println( "Oops, An invalid command was entered." );

					break;
			}
		}
		else
			System.out.println("INPUT ERROR");
		
		return validCommand;
	}
	

	
	/*****************************************************************
	 * @Description - A method utilized to return the current text 
	 * line that the user is currently editing.
	 *
	 * @Returns - The text of the line the user is currently editing 
	 * as a String.
	 *
	 ****************************************************************/
	@Override
	public String getCurrentLine() {
		// TODO Auto-generated method stub
		return null;
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
		
		for(int i = 0; i<editLineCount;i++){
			System.out.println();
		}
		
	}
	
	/*****************************************************************
	 * @Description - A method utilized to return a given line 
	 * number's textual information.
	 *
	 * @param The line number to pull the text value from.
	 *
	 * @Returns - The text of the line the user is currently editing 
	 * as a String.
	 *
	 ****************************************************************/
	
	@Override
	public String getLine(int lineNbr) {
		// TODO Auto-generated method stub
		return currentLineContent;
	}
	
	public int getEditLineCount() {
		return editLineCount;
	}

	public void setEditLineCount(int editLineCount) {
		this.editLineCount = editLineCount;
	}

	public void setCurrentLine(int currentLine) {
		this.currentLineNumber = currentLine;
	}
	//--------------------------------------------------------------// 

	@Override
	public int getDocumentLineCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public final static void clearConsole()
	{
	    //Push old editor out of visible site on terminal
	    for(int i=0;i<30;i++){
	    	System.out.println();
	    }
	}

}
