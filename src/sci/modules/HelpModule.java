package sci.modules;

import java.util.ArrayList;

import sci.SCI;

public class HelpModule implements Module {
	// A pre-included module that you're best off not removing.
	
	public HelpModule() {}
	
	@Override
	public String getInvoker() {return "help";}
	
	@Override
	public String getName() {return "Help Module";}

	@Override
	public String process(String line, ArrayList<String> tokens) {
		String response = "";
		if( tokens.size() == 0 ) {
			response += "Here is a list of commands.";
			for( String s : SCI.modules.keySet() ) {
				response += "\n\t" + s;
			}
			response += "\nFor more information on a command, type \"help <command>\".";
		} else {
			String command = tokens.get(0);
			for( String s : SCI.modules.keySet() ) {
				if( command.equalsIgnoreCase(s) ) {
					response = SCI.modules.get(s).getHelpDoc();
				}
			}
			if( response.equals("") ) {
				response += "Command \"" + command + "\" does not exist.";
				response += "\nType \"help\" to see a list of commands.";
			}
		}
		return response;
	}

	@Override
	public String getHelpDoc() {
		String response = "";
		response += "___[Help] Usage___";
		response += "\nThe 'help' command gives details on how to use the ScoutingComputerInterface.";
		response += "\n\thelp\t\tReturns a list of valid commands.";
		response += "\n\thelp [command]\tGives detailed information about a command.";
		response += "\n------------------";
		return response;
	}
}
