/*--------------------------------------------------------------------*
* IEditor.java                             		    	         	  *
*---------------------------------------------------------------------*
* Description - An interface used to lay the foundation for the 	  *
* Physical text editor object. Core functions required to make the 	  *
* text editor work are declared in this file.    					  *
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

public interface IEditor { 
	
	//--------------------------------------------------------------//	
	// Core Function Decelerations			     					//
	//--------------------------------------------------------------//  
 
	/* Processes the given editor command. */ 
	boolean processCommand(String command); 
	
	/* Returns the number of lines in document. */ 
	int getDocumentLineCount(); 
	
	//--------------------------------------------------------------//  

} 

