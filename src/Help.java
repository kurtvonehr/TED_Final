import java.util.LinkedList;
import java.util.ListIterator;


public class Help implements ICommand {


	@Override
	public boolean executeCommand(String command, ListIterator<String> currentData) {
		
		
		System.out.println("**********************************************************");
		System.out.println("Help Menu");
		System.out.println("**********************************************************");
		System.out.println("Available Commands: \n\n");
		System.out.println("	b <Sentence> - Insert sentence before the current line\n");
		System.out.println("	i <Sentence> - Insert sentence after the current line\n");
		System.out.println("	e <Sentence> - Insert sentence after the last line\n");
		System.out.println("	m [#] - Move current line down one line or optional number of lines\n");
		System.out.println("	u [#] - Move current line up one line or optional number of lines\n");
		System.out.println("	d#* - Display from line # to * (inclusive)\n");
		System.out.println("	r - Remove the current line\n");
		System.out.println("	c - Clear all lines from file (only if saved)\n");
		System.out.println("	s <filename> - Save the contents to the specified text file\n");
		System.out.println("	l <filename> - Load the contents from the specified text file (only if saved)\n");
		System.out.println("	h - Display Help Menu\n");
		System.out.println("	x - Exit the editor (only if saved)\n\n");
		System.out.println(":");
		
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
