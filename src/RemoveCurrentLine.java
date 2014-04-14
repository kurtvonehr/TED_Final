import java.util.LinkedList;
import java.util.ListIterator;


public class RemoveCurrentLine implements ICommand {


	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		if(currentData.hasNext()){
			currentData.previous();
			currentData.remove();
			currentData.next();
		}
		else if(currentData.hasPrevious()){
			currentData.previous();
			currentData.remove();
		}
		
		
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
