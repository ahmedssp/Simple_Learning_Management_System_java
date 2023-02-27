import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jason_data {
     //A1=studentlist_fainal_txt_file_path
     //A2=courcetlist_fainal_txt_file_path
     //A3=courcetlist_fainal_txt_file_path
     //A4=student_id
    public static void student_data(String A1,String A2,String A3,Integer A4){
       //tsts
//        System.out.println(File_line_to_array.fun_E(A1,A3)[1]);
//        System.out.println(File_line_to_array.fun_Line_COURCE(A2).get(JASON_SH.FU("Out_Data/Student_course_details.json", "1").get(1)));
          //ok
//        System.out.println();

//
        System.out.println ("====================================================================================");
        System.out.println("Student Details page");
        System.out.println ("====================================================================================");
        System.out.println ("Name:"+File_line_to_array.fun_E(A1,A4)[1]+"           "+"Grade:"+File_line_to_array.fun_E(A1,A4)[2]+"          "+ "Email:"+File_line_to_array.fun_E(A1,A4)[3]);
        System.out.println ("------------------------------------------------------------------------------------");
        System.out.println ( " Enrolled courses.");
          String v=tst.jason_search_val(A3, String.valueOf(A4));
         for(int x = 0; x <v.length(); x++){
             System.out.println(File_line_to_array.fun_Line_COURCE(A2).get(Character.getNumericValue(v.charAt(x))));
         }

        System.out.println ("------------------------------------------------------------------------------------");


    }
}
