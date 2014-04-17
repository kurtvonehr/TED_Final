import java.util.ListIterator;

/*---------------------------------------------------------------------*
 * DisplayAllLines.java                            		       		   *
 *---------------------------------------------------------------------*
 *   Description - A command class used to print off all the lines	   *
 *   			that are in the file were reading in.				   *
 *---------------------------------------------------------------------*
 * Project: Project 4 : TED	 	                                       *
 * Author : McKim A. Jacob, Vonehr Kurt						           *
 * Date Of Creation: 4 - 6 - 2014                                      *
 *---------------------------------------------------------------------*/

public class DisplayAllLines implements ICommand {

	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		boolean error = false;
		
		String firstLine = "";
		String lastLine = ""; 
		int i = 2;
		
		if(command.substring(1,2).equals("on"))
			error = false;
		else if(command.substring(1,3).equals("off"))
			error = true;
		
		else{
			
			while(command.charAt(i) != ' '){
				firstLine = firstLine + command.charAt(i);
				i++;
			}
			i++;
			while(command.charAt(i) != ' '){
				lastLine = lastLine + command.charAt(i);
				i++;
			}
		
			int restorecurrentData = currentData.previousIndex();
	
			//move iterator to front of list
			while(currentData.previousIndex() != -1)
				currentData.previous();
			
			i = 0;
			
			//Move through entire list and print each string
			while(currentData.hasNext()){
				if(i>=Integer.parseInt(firstLine) || i < Integer.parseInt(lastLine))
					System.out.println("" + (i+1) + "    " + currentData.next());				
				i++;
			}
			
			if(!currentData.hasNext()){
				currentData.previous();
				System.out.println("" + (i+1) + " => " + currentData.next());
			}
			
			
			return error;
		}
		return error;
			
	}
	
	@Override
	public void printCommandHelp() {
		// TODO Auto-generated method stub

	}

}
