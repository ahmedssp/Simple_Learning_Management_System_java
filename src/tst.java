import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class tst {

    public static String  jason_search_val(String path,String ID) { // Function to read file
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
       String data2= data.strip().replace("{","").replace("}","").replace(",","")
               .replace(" ","").replace(":","");
        String[]x=data2.strip().split("\"");

//        System.out.println(Arrays.toString(x));//test
         Integer q=-1;String val="",val2="";
        for (int i = 0; i < x.length; i++) {
            if (x[i].equals(ID)) {
                q=i+1;
                break;
            }
        }
        if(q==-1){System.out.println("This student hasn't enrolled in any courses");}
        val=x[q].replace("[","").replace(" ","").replace("]","");
        val2=val.strip();
//        System.out.println(val2);

//        for (int i = 0; i < val2.length(); i++) {System.out.println(val2.charAt(i));}

        return val2;
    }



}



