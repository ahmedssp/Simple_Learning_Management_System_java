import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Json_Search {

    public static String  jason_search_val(String path,String S_ID) { // Function to read file
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
            if (x[i].equals(S_ID)) {
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
//        System.out.println("1:"+data); //test

        String data2= data.strip().replace("{","").replace("}","").replace(",","")
                .replace(" ","").replace(":","");
        String[]x=data2.strip().split("\"");

//        System.out.println("2:"+Arrays.toString(x)); //test

//        System.out.println(Arrays.toString(x));//test
        Integer q=-1;String val="",val2="";
        for (int i = 0; i < x.length; i++) {
            if (x[i].equals(S_ID)) {
                q=i+1;
                break;
            }
        }
        if(q==-1){
            System.out.println("This student hasn't enrolled in any courses");
            val2="";
        }

        val=x[q].replace("[","").replace(" ","").replace("]","");
        val2=val.strip();

        for(int Z = 0; Z <val2.length(); Z++){
//            System.out.println(val.charAt(Z));
            if(val2.contains(C_ID) ||val2.length()>5) {break;}
            else val2=val2+C_ID;
        }
        ArrayList<String> u = new ArrayList<>();
        ArrayList<String> u2 = new ArrayList<>();
        int c=0;

//        System.out.println(val2);// TEST

        for(String Q:x){u.add (Q);}
        u.add(q,"["+val2+"]");
        u.remove(q+1);u.remove(0);

        for(String p:u){
            c++;
            if(c%2!=0){u2.add ("\""+p+"\"");}else {u2.add (Arrays.toString(p.replace("[","").replace("]","").split("")).replace(",","."));}
        }

        return u2;
//          File_m.Write("Out_Data/Student_course_details2.json",Format_jason.jason_format(File_m.ReadFile("Out_Data/Student_course_details2.json"))); //write data to jason format final
    }


    public static ArrayList<String> Remove_COURCE_Array(String path, String S_ID, String C_ID_un) {
        // Function to read file
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
//        System.out.println("1:"+data); //test

        String data2= data.strip().replace("{","").replace("}","").replace(",","")
                .replace(" ","").replace(":","");
        String[]x=data2.strip().split("\"");

//        System.out.println("2:"+Arrays.toString(x)); //test

//        System.out.println(Arrays.toString(x));//test
        Integer q=-1;String val="",val2="";
        for (int i = 0; i < x.length; i++) {
            if (x[i].equals(S_ID)) {
                q=i+1;
                break;
            }
        }
        if(q==-1){
            System.out.println("This student hasn't enrolled in any courses");
            val2="";
        }

        val=x[q].replace("[","").replace(" ","").replace("]","");
        val2=val.strip();


        for(int Z = 0; Z <val2.length(); Z++){
//            System.out.println(val.charAt(Z));
            if(!val2.contains(C_ID_un)||val2.length()<1) {break;}
            else val2=val2.replace(C_ID_un,"");
        }
        ArrayList<String> u = new ArrayList<>();
        ArrayList<String> u2 = new ArrayList<>();
        int c=0;

//        System.out.println(val2);// TEST

        for(String Q:x){u.add (Q);}
        u.add(q,"["+val2+"]");
        u.remove(q+1);u.remove(0);

        for(String p:u){
            c++;
            if(c%2!=0){u2.add ("\""+p+"\"");}else {u2.add (Arrays.toString(p.replace("[","").replace("]","").split("")).replace(",","."));}
        }

        return u2;
    }

    public static ArrayList<String> jason_search_val_un_en(String path, String S_ID, String C_ID_un , String C_ID_en) { // Function to read file
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
//        System.out.println("1:"+data); //test

        String data2= data.strip().replace("{","").replace("}","").replace(",","")
                .replace(" ","").replace(":","");
        String[]x=data2.strip().split("\"");

//        System.out.println("2:"+Arrays.toString(x)); //test

//        System.out.println(Arrays.toString(x));//test
        Integer q=-1;String val="",val2="";
        for (int i = 0; i < x.length; i++) {
            if (x[i].equals(S_ID)) {
                q=i+1;
                break;
            }
        }
        if(q==-1){
            System.out.println("This student hasn't enrolled in any courses");
            val2="";
        }

        val=x[q].replace("[","").replace(" ","").replace("]","");
        val2=val.strip();

        for(int Z = 0; Z <val2.length(); Z++){
            if(val2.contains(C_ID_en) ||val2.length()>5) {break;} else val2=val2+C_ID_en;
            if(!val2.contains(C_ID_un)||val2.length()<1) {break;} else val2=val2.replace(C_ID_un,"");
        }
        ArrayList<String> u = new ArrayList<>();
        ArrayList<String> u2 = new ArrayList<>();
        int c=0;

//        System.out.println(val2);// TEST

        for(String Q:x){u.add (Q);}
        u.add(q,"["+val2+"]");
        u.remove(q+1);u.remove(0);

        for(String p:u){
            c++;
            if(c%2!=0){u2.add ("\""+p+"\"");}else {u2.add (Arrays.toString(p.replace("[","").replace("]","").split("")).replace(",","."));}
        }

        return u2;
//          File_m.Write("Out_Data/Student_course_details2.json",Format_jason.jason_format(File_m.ReadFile("Out_Data/Student_course_details2.json"))); //write data to jason format final
    }


}