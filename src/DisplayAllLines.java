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
		
		if(command.equals("d -h"))
				printCommandHelp();
		
		if(command.length()>3){
			
			if(command.substring(2,4).equals("on"))
				error = false;
			else if(command.substring(2,5).equals("off"))
				error = true;
			
			else{
				
				while(command.charAt(i) != ' ' && i<command.length()){
					firstLine = firstLine + command.charAt(i);
					i++;
				}
				i++;
				while(i<command.length()){
					lastLine = lastLine + command.charAt(i);
					i++;
				}
			
				int restorecurrentData = 0;
		
				//move iterator to front of list
				while(currentData.previousIndex() != -1)
					currentData.previous();
				
				i = 0;
				
				if(firstLine.matches("[0-9].*") && lastLine.matches("[0-9].*")){
					//Move through entire list and print each string
					while(currentData.hasNext()){
						if((i+1)>=Integer.parseInt(firstLine) && (i+1) < Integer.parseInt(lastLine))
							System.out.println("" + (i+1) + "    " + currentData.next());
						else if((i+1) == Integer.parseInt(lastLine)){
							System.out.println("" + (i+1) + " => " + currentData.next());
							restorecurrentData = currentData.previousIndex();
						}
						else
							currentData.next();
						i++;
					}
					
					//restore current line back to it's previous index
					while(currentData.previousIndex() != restorecurrentData)
						currentData.previous();
					
					error = true;
				}
				else{
					error = true;
					System.out.println("Enter valid line numbers");
				}
			}
		}
		return error;
			
	}
	
	@Override
	public void printCommandHelp() {
		// TODO Auto-generated method stub

	}

}
