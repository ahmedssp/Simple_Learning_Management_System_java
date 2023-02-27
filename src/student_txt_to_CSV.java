import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class student_txt_to_CSV {
    public static String ReadFile(String path) { // Function to read file
        String line = "";
        String data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (line != null) {
                if (line == null) break;
                data += line;
                line = br.readLine();
            }
            br.close();}
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return data;
    }
    public static String formate(String out) {  // Function to convert file to propare format
        return out.replace("#", ",").replace("$", "\n");
    }
}
