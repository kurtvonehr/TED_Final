import java.util.LinkedList;
import java.util.ListIterator;


public class MoveIndicatorDown implements ICommand {

	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		if(currentData.hasNext()){
			currentData.next();
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
