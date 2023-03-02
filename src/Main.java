import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
//        tst.ReadFile("Out_Data/Student_course_details.json","3");

////        1-  student_txt_to_CSV
//        String Student_DATA_out =student_txt_to_CSV.formate(student_txt_to_CSV.ReadFile("Input_Data/student-data_G.txt"));
//        File_m.Creat_New_file("Out_Data/student-data_out.csv");
//        File_m.Write("Out_Data/student-data_out.csv",Student_DATA_out );
//        System.out.println(Student_DATA_out);
// //_________________________________________________________________________________________________________________________________
//         // 2-course_XML_TO_CSV
//        String data=course_XML_TO_CSV.formate((course_XML_TO_CSV.ReadFile("Input_Data/coursedata_G.xml"))) ; //convert TXT file into CSV format
//        File_m.Creat_New_file("Out_Data/cource_list_CSV.csv"); // creat new file name.csv
//        File_m.Write("Out_Data/cource_list_CSV.csv",data ); //Write data into CSV file
//        System.out.println(data); // Read New CSV file data and print it
//////////_________________________________________________________________________________________________________________________________
////        //3-Implement data manipulation functionalities  student data
//        manipulation_student_data_print.fun("Out_Data/student-data_out.csv",7);
////////_________________________________________________________________________________________________________________________________
////         //   create jason file by user input from console
//        HashMap<String, ArrayList<Integer>> x;
//        x=My_Dictionary.Cource_array_user_input(); //create Dictunary data file from user input :return HashMap<String, ArrayList<Integer>>
//        read_arry_li.write_file_Row_jason(x,"Out_Data/Student_course_details2.json"); // write data into txt file on jason row format
//        String jason =Format_jason.jason_format(File_m.ReadFile("Out_Data/Student_course_details2.json")); //format data to jason format
//        File_m.Write("Out_Data/Student_course_details2.json",jason); //write data to jason format final
////
////            //create function that search on jason file and prints specific student data in organized style
//        jason_data.student_data("Out_Data/student-data_out.csv","Out_Data/cource_list_CSV.csv","Out_Data/Student_course_details.json",5);
///_________________________________________________________________________________________________________________________________
        // enrollment course
        course_enrollment.course_enroll("Out_Data/Student_course_details2.json","1","5");
///_________________________________________________________________________________________________________________________________

        //unenrollment course
        course_enrollment.uncourse_enroll("Out_Data/Student_course_details2.json","2","0");
///_________________________________________________________________________________________________________________________________

        //unenroll and enroll course
        course_enrollment.course_enroll_unenroll("Out_Data/Student_course_details2.json","3","3","8");
        

    }
    }
