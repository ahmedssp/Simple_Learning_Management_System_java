import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.*;


public class Json_Search {

     //read value of json file for specific Cource id
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
        if(val2.equals("0")){System.out.println("The student hasn't enrolled in any course yet.");}

        return val2;
    }
    public static boolean chk=true;
    public static ArrayList<String> Add_COURCE_Array(String path, String S_ID, String C_ID) {
        // Function to read file
        String line = "";
        String data = "";

        ArrayList<String> R = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (line != null) {
                if (line == null) break;
                data += line;
                line = br.readLine();}
            br.close();}
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
//        System.out.println(data);

        String data2= data.strip().replace("{","").replace("}","").replace(",","")
                .replace(" ","").replace(":","");
//        System.out.println(data2);

        String[]x=data2.strip().split("\"");

//        System.out.println(Arrays.toString(x));

        Integer q=-1;String val="",val2="",val3="";
        for (int i = 0; i < x.length; i++) {
            if (x[i].equals(S_ID)) {
                q=i+1;
                break;}
        }
        if(q==-1){
            System.out.println("This student id Not Listed in student data file");
            val2="";val3="";
        }
        val=x[q].replace("[","").replace(" ","").replace("]","");
        val2=val.strip();
//        System.out.println(val);

            if(val2.contains(C_ID) ||val2.length()>5||!(Integer.valueOf(C_ID) ==(int)Integer.valueOf(C_ID))) {chk=false;System.out.println("Failed to enroll:"+File_line_to_array.fun_E("Out_Data/cource_list_CSV.csv", Integer.valueOf(C_ID))[1]+" course Because it may be repeated or reached to max number to enrollment  \n");;}
            else {val2=(val2+C_ID).replace("0","");System.out.println("The student is Enrolled Successfully in the"+File_line_to_array.fun_E("Out_Data/cource_list_CSV.csv", Integer.valueOf(C_ID))[1]+" course\n");chk=true;}


        ArrayList<String> u = new ArrayList<>();
        ArrayList<String> u2 = new ArrayList<>();
        int c=0;
//        System.out.println(val2);// TEST
        for(String Q:x){u.add (Q);}

//        System.out.println(u);

        u.add(q,"["+val2+"]");

        u.remove(q+1);u.remove(0);
        for(String p:u){
            c++;
            if(c%2!=0){u2.add ("\""+p+"\"");}else {u2.add (Arrays.toString(p.replace("[","").replace("]","").split("")).replace(",","."));}
        }

        return u2;
    }
     public static boolean un_x=true;
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

        String data2= data.strip().replace("{","").replace("}","").replace(",","")
                .replace(" ","").replace(":","");
        String[]x=data2.strip().split("\"");

        Integer q=-1;String val="",val2="";
        for (int i = 0; i < x.length; i++) {
            if (x[i].equals(S_ID)) {
                q=i+1;
                break;}
        }
        if(q==-1){
            System.out.println("This student hasn't enrolled in any courses");
            val2="";
        }
        val=x[q].replace("[","").replace(" ","").replace("]","");
        val2=val.strip();
            if(!(Integer.valueOf(C_ID_un) ==(int)Integer.valueOf(C_ID_un))){System.out.println("you inter invalid Course ID");un_x=false;}
            if(val2.length()<=1||!(val2.contains(C_ID_un)) ) {System.out.println("Faild to unenroll: The student as only one or no courses to unenroll from\n");un_x=false;}
            else {val2=val2.replace(C_ID_un,"").replace("0","");System.out.println("The student is unEnrolled Successfully in the"+File_line_to_array.fun_E("Out_Data/cource_list_CSV.csv", Integer.valueOf(C_ID_un))[1]+" course\n");}

        ArrayList<String> u = new ArrayList<>();
        ArrayList<String> u2 = new ArrayList<>();
        int c=0;

        for(String Q:x){u.add (Q);}
        u.add(q,"["+val2+"]");
        u.remove(q+1);u.remove(0);

        for(String p:u){
            c++;
            if(c%2!=0){u2.add ("\""+p+"\"");}else {u2.add (Arrays.toString(p.replace("[","").replace("]","").split("")).replace(",","."));}
        }

        return u2;
    }

    public static String value_o="";
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


           if(val2.contains(C_ID_en) ||val2.length()>5||!(Integer.valueOf(C_ID_en) ==(int)Integer.valueOf(C_ID_en))) {chk=false;System.out.println("Failed to enroll:"+File_line_to_array.fun_E("Out_Data/cource_list_CSV.csv", Integer.valueOf(C_ID_en))[1]+" course Because it may be repeated or reached to max number to enrollment  \n");;}
           else {val2=(val2+C_ID_en).replace("0","");;chk=true;}

           if(!(Integer.valueOf(C_ID_un) ==(int)Integer.valueOf(C_ID_un))){System.out.println("you inter invalid Course ID");un_x=false;}
           if(val2.length()<=1||!(val2.contains(C_ID_un)) ) {System.out.println("Faild to unenroll: The student as only one or no courses to unenroll from\n");un_x=false;}
           else {val2=val2.replace(C_ID_un,"").replace("0","");;}
           value_o=val2;


             ArrayList<String> u = new ArrayList<>();
             ArrayList<String> u2 = new ArrayList<>();
             int c=0;

        for(String Q:x){u.add (Q);}
        u.add(q,"["+val2+"]");
        u.remove(q+1);u.remove(0);

        for(String p:u){
            c++;
            if(c%2!=0){u2.add ("\""+p+"\"");}else {u2.add (Arrays.toString(p.replace("[","").replace("]","").split("")).replace(",","."));}
        }

        return u2;
    }


}