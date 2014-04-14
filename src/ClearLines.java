import java.util.LinkedList;
import java.util.ListIterator;


public class ClearLines implements ICommand {


	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		while(currentData.hasNext())
			currentData.remove();
		while(currentData.previousIndex() > 0)
			currentData.remove();
		currentData.previous();
		currentData.remove();
		
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
