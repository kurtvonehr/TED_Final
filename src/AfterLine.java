import java.util.LinkedList;
import java.util.ListIterator;


public class AfterLine implements ICommand {


	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		String insertedText = command.substring(1,command.length());
		if(currentData.hasNext()){
			currentData.add(insertedText);
		}
		else
			currentData.add(insertedText);
		
		return false;
	
	}

	@Override
	public void printError() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printCommandHelp() {
		// TODO Auto-generated method stub

	}

}
