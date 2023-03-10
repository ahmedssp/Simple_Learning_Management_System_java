import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class t {
    public static ArrayList<String> Add_COURCE_Array(String path, String S_ID, String C_ID) { // Function to read file
        String line = "";
        String data = "";
        ArrayList<String> R = null;
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
        System.out.println("data:"+data);

        String data2= data.strip().replace("{","").replace("}","")
                .replace(" ","");
        System.out.println("data2:"+data2);

        String[]x=data2.strip().split(":");

        System.out.println("3-"+Arrays.toString(x));
        System.out.println("4-"+x[3]);


        ArrayList<String> u=null;
        ;return u;
    }

}
