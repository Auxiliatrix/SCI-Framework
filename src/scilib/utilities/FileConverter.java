package scilib.utilities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileConverter {
	
	public FileConverter() {
		
	}
	@SuppressWarnings("resource")
	public ArrayList<String> convert(String fileName) {
		ArrayList<String> lines = new ArrayList<String>();
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                lines.add(line);
            }
        }
        catch (Exception E)
        {
        	return null;
        }
        return lines;
	}
	
	public String compress(String input) {
		return input.replace(" ", "").replace("%", "").toLowerCase();
	}
}
