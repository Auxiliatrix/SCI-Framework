package sci.modules;

import java.util.ArrayList;

/**
 * Default module which safely exits the program.
 * @author rlee287
 *
 */
public class ExitModule implements Module {

	/*
	 * Creates a QuitModule
	 */
	public ExitModule() {}
	
	@Override
	public String[] getInvokers() {return new String[]{"exit","quit","close"};}

	@Override
	public String getName() {
		return "Quit Module";
	}

	@Override
	public String getHelpDoc() {
		String response = "";
		response += "___[Quit] Usage___";
		response += "\nThe 'quit' command exits the program.";
		response += "\n------------------";
		return response;
	}

	@Override
	public String process(String line, ArrayList<String> tokens) {
		return null;
	}

}
