import java.util.LinkedList;
import java.util.ListIterator;


public class BeforeLine implements ICommand {


	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		String insertedText = command.substring(1,command.length());
		if(currentData.hasPrevious()){
			currentData.previous();
			currentData.add(insertedText);
			currentData.next();
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
