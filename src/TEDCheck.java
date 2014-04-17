import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.Test;

/*--------------------------------------------------------------------*
* TEDCheck.java                            		    	         	  *
*---------------------------------------------------------------------*
*  Description - A junit test validating the functionality of the     *
*     particular functions that will be apart of the TED editor.	  *
*---------------------------------------------------------------------*
* Project: Project 4 : TED	 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt						          *
* Date Of Creation: 4 - 6 - 2014                                      *                             
*---------------------------------------------------------------------*/

public class TEDCheck {
	
	
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
    /* Generic command object to be called. */
    ICommand command;
	
	/* linked list containing each line of the document. */
	LinkedList <String> textData;	
    
	/* Current line that the commands are operating on. */
    ListIterator<String> CurrentLine;
    
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//

	@Test
	public void test() {
	    
		// ----- Configure the test ----- //
	    
		// Build the linked list.
		textData = new LinkedList<String> ();
		CurrentLine = textData.listIterator();
	    
		// ----- Before Insertion Command ----- //
		
		command = new BeforeLine();
		
		// Test generic case.
        command.executeCommand("b the words", CurrentLine);
        assertEquals(CurrentLine.previous(), " the words");
        
        // Test with nothing at end.
        command.executeCommand("b ", CurrentLine);
        assertEquals(CurrentLine.previous(), " ");
        
        // Test with mixed characters.
        command.executeCommand("b abc9870#%$(", CurrentLine);
        assertEquals(CurrentLine.previous(), " abc9870#%$(");

		
		// ----- After Insertion Command ------ //
        
        // Testing response of command.
		command = new AfterLine();
		
		// Test generic case.
        assertEquals( command.executeCommand 
        		( "a the words", CurrentLine), true);
        
        // Test with nothing at end.
        assertEquals( command.executeCommand 
        		( "a ", CurrentLine), true);
        
        // Test with mixed characters.
        assertEquals( command.executeCommand 
        		( "a abc9870#%$(", CurrentLine), true);
        		
		// -------- Move Down/Up Command --------- //
    
        // Clears the lines.
        textData = new LinkedList<String> ();
  		CurrentLine = textData.listIterator();
        
        command = new AfterLine();
        command.executeCommand("a 1", CurrentLine);
        command.executeCommand("a 2", CurrentLine);
        command.executeCommand("a 3", CurrentLine);
        command.executeCommand("a 4", CurrentLine);
               
        // shift up one line.
        command = new MoveIndicatorUp();
        command.executeCommand("u", CurrentLine);
        assertEquals(CurrentLine.previousIndex(), 2);
        assertEquals(CurrentLine.nextIndex(), 3);
        
        // shift up two lines.
        command.executeCommand("u 2", CurrentLine);
        assertEquals(CurrentLine.previousIndex(), 0);
        assertEquals(CurrentLine.nextIndex(), 1);	
        
        // shift down one line.
        command = new MoveIndicatorDown();
        command.executeCommand("m", CurrentLine);
        assertEquals(CurrentLine.previousIndex(), 1);
        assertEquals(CurrentLine.nextIndex(), 2);
        
        command.executeCommand("m 2", CurrentLine);
        assertEquals(CurrentLine.previousIndex(), 3);
        assertEquals(CurrentLine.nextIndex(), 4);
		
		// --------- Remove Command ----------- //	
        
        // Remove just one element.
        command = new RemoveCurrentLine();
        command.executeCommand("r", CurrentLine);
        assertEquals(CurrentLine.previousIndex(), 2);
        assertEquals(CurrentLine.nextIndex(), 3);
        
        // Remove the last three elements.
        command.executeCommand("r 3", CurrentLine);
        assertEquals(CurrentLine.previousIndex(), 0);
        assertEquals(CurrentLine.nextIndex(), 1);
		
		// ---------- Load/Save Command -------- //	
		
        // Test invalid load sequences.
        command = new LoadFile();
        assertEquals (command.executeCommand("l",
        						CurrentLine), false);
       
        // Test file doesn't exist.
        assertEquals (command.executeCommand("l text.dat",
				CurrentLine), false);
        
        // Test improper save.
        command = new SaveFile();
        assertEquals (command.executeCommand("s",
				CurrentLine), true);

        
		// --------- Display Command ---------- //	
        
        command = new DisplayAllLines();
        
        // Check and see that the command executed.
        assertEquals(command.executeCommand("d", CurrentLine), false);
		
		// ---------- Clear Command ----------- //
		
        command = new ClearLines();
      
        // Check and see that the command executed.
        assertEquals(command.executeCommand("c", CurrentLine), true);
        
		// ------- Cut & Paste Commands ------ //
        
        /* the cut command. */
        Cut cut = new Cut();
        
        /* the paste command. */
        Paste paste = new Paste ();
        
        // Check and see that the command executed.
        assertEquals(cut.executeCommand("o -h", CurrentLine, 
        								CurrentLine, 12), true);
        
        // Check and see that the command executed.
        assertEquals(paste.executeCommand("p -h", CurrentLine,
        									CurrentLine), true);

	}
	
	//---------------------------------------------------------------//


}
