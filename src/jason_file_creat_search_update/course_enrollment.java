package jason_file_creat_search_update;

import java.io.IOException;
import java.util.*;

class course_enrollment
{
    public static  ArrayList<Integer> courcl1(Integer number_of_cources){

        ArrayList<Integer> cource=new ArrayList<>();
        ArrayList<ArrayList<Integer>>data = new ArrayList<>();

        for (int a=0;a<number_of_cources;a++){
            System.out.println("Enter cource_id"+a+"\n");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            cource.add(Integer.valueOf(myObj.nextLine()));
        }
        return cource;
    }

    public static  HashMap<String, ArrayList<Integer>> Cource_array_user_input(){

        HashMap<String, ArrayList<Integer>> my_dict = new  HashMap<String, ArrayList<Integer>>();
        System.out.println("Enter number_of_student\n");
        Scanner myObj = new Scanner(System.in);
        int ee=Integer.valueOf(myObj.nextLine());
        for (int c=1;c<=ee ;c++){
            System.out.println("Student_id"+ c+"\n");
            System.out.println("Enter number_of_cources|\n");
            my_dict.put(String.valueOf(c),courcl1(Integer.valueOf(myObj.nextLine())));
        }
        return my_dict;
    }
    public  static void finder(String id){
        Cource_array_user_input().get(id);
    }

    public static void course_enroll(String PATH,String s_id,String c_id) throws IOException {
        String ee=String.valueOf(Json_Search.Add_COURCE_Array(PATH, s_id, c_id)); // convert Arraylist to String
         ee= ee.strip().replace("\",","\":").replace(" ","").replace(".",",");
        StringBuilder json = new StringBuilder(ee);
        json.setCharAt(ee.length()-1, '}');json.setCharAt(0, '{');
        File_m.Write(PATH, String.valueOf(json)); //write data to jason format final
    }
    public static void course_unenroll(String PATH,String s_id,String c_id) throws IOException {
//        ArrayList<String> TXT=new ArrayList<>();
        //serach and modyfay cource value data
        String ee=String.valueOf(Json_Search.Remove_COURCE_Array(PATH, s_id, c_id)); // convert Arraylist to String
        ee= ee.strip().replace("\",","\":").replace(" ","").replace(".",",");

        StringBuilder json = new StringBuilder(ee);
        json.setCharAt(ee.length()-1, '}');json.setCharAt(0, '{');
        File_m.Write(PATH, String.valueOf(json)); //write data to jason format final

    }

    public static void course_enroll_unenroll(String PATH,String s_id,String c_id_un,String c_id_en) throws IOException {
//        ArrayList<String> TXT=new ArrayList<>();
        HashMap<String, ArrayList<String>> my_dict = new HashMap<String, ArrayList<String>>();

        //serach and modyfay cource value data
        String ee=String.valueOf(Json_Search.jason_search_val_un_en(PATH, s_id, c_id_un,c_id_en)); // convert Arraylist to String
        ee= ee.strip().replace("\",","\":").replace(" ","").replace(".",",");

        StringBuilder json = new StringBuilder(ee);
        json.setCharAt(ee.length()-1, '}');json.setCharAt(0, '{');

        File_m.Write(PATH, String.valueOf(json)); //write data to jason format final

    }


}
