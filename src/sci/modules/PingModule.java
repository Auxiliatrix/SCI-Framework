package sci.modules;

import java.util.ArrayList;

public class PingModule implements Module {
	
	@Override
	public String getInvoker() {
		return "ping";
	}

	@Override
	public String getName() {
		return "Ping Module";
	}

	@Override
	public String getHelpDoc() {
		String response = "";
		response += "___[Ping] Usage___";
		response += "\nThe 'ping' command returns \"pong\" when executed.";
		response += "\n------------------";
		return response;
	}
	
	@Override
	public String process(String line, ArrayList<String> tokens) {
		return "pong";
	}

}
