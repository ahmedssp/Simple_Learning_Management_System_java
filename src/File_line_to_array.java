import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File_line_to_array {
    //FOR STUDENT
    public static String[] fun_E(String file_path, Integer X){
        String line = "";
        String data = "";
        String[] AA;
        List<String> recordlist = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            while (line != null) {
                if (line == null) break;
                recordlist.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        recordlist.remove(0);

        AA = recordlist.get(X).split(",");
       return AA;
    }
    // convert cource to list  to access row
    public static List<String> fun_Line_COURCE(String file_path){
        String line = "";
        String data = "";String[] AA;
        List<String> recordlist = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            while (line != null) {
                if (line == null) break;
                recordlist.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        recordlist.remove(0);


        return recordlist;
    }
}
