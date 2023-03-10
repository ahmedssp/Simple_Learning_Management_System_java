import com.sun.jdi.Value;

import java.io.*;
import java.util.*;

class My_Dictionary {
    public static ArrayList<Integer> courcl1(Integer number_of_cources) {

        ArrayList<Integer> cource = new ArrayList<>();
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        for (int a = 0; a < number_of_cources; a++) {
            System.out.println("Enter cource_id" + a + "\n");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            cource.add(Integer.valueOf(myObj.nextLine()));
        }
        return cource;
    }

    public static HashMap<String, ArrayList<Integer>> Cource_array_user_input() {

        HashMap<String, ArrayList<Integer>> my_dict = new HashMap<String, ArrayList<Integer>>();
        System.out.println("Enter number_of_student\n");
        Scanner myObj = new Scanner(System.in);
        int ee = Integer.valueOf(myObj.nextLine());
        for (int c = 1; c <= ee; c++) {
            System.out.println("Student_id" + c + "\n");
            System.out.println("Enter number_of_cources|\n");
            my_dict.put(String.valueOf(c), courcl1(Integer.valueOf(myObj.nextLine())));
        }
        return my_dict;
    }

    public static void finder(String id) {
        Cource_array_user_input().get(id);
    }


    public static void Student_Json_generated(String FILEPATH) throws IOException  // print csv file into proper format
    {
        String line = "";
        String data = "";
        List<String> recordlist = new ArrayList<String>();
        List<String> json1 = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILEPATH));
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

        for(int a=1;a<recordlist.size();a++){
            json1.add("\""+String.valueOf(a)+"\":[0]");
        }
        StringBuilder json = new StringBuilder(String.valueOf(json1));
        json.setCharAt(String.valueOf(json1).length()-1, '}');
        json.setCharAt(0, '{');

       File_m.Write("Out_Data/Student_course_details_Generated.json",String.valueOf(json));

}}
