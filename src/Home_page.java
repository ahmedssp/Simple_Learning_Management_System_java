import java.io.IOException;
import java.util.Scanner;

public class Home_page {
    public static void main(String[] args) throws IOException {
        // Application GUI
        System.out.println("Welcome to LMS");
        System.out.println("created by: Ahmed Mostafa - March 1, 2023 ");
        System.out.println("====================================================================================================");
        System.out.println("Home page");
        System.out.println("====================================================================================================");
        System.out.println("Student List:");
        // prepare course data list and print student dada list
        String cources=course_XML_TO_CSV.formate((course_XML_TO_CSV.ReadFile("Input_Data/coursedata_G.xml"))) ; //convert TXT file into CSV format
        File_m.Creat_New_file("Out_Data/cource_list_CSV.csv"); // creat new file name.csv
        File_m.Write("Out_Data/cource_list_CSV.csv",cources ); //Write data into CSV file
        //_________________________Convert Student TXT File to CSV manipulation and print it___________________________________________________________
        String Student_DATA_out =student_txt_to_CSV.formate(student_txt_to_CSV.ReadFile("Input_Data/student-data_G.txt"));
        File_m.Write("Out_Data/student-data_out.csv",Student_DATA_out );
        manipulation_student_data_print.Present_csv("Out_Data/student-data_out.csv",7);
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //______________________________________________________Select required student______________________________________________________________________
        String studentId;

        while (true) {

            System.out.print("please select the required student: ");

            try {Scanner scanner = new Scanner(System.in);
                studentId = scanner.next();
                jason_data.student_data("Out_Data/student-data_out.csv","Out_Data/cource_list_CSV.csv","Out_Data/Student_course_details_Generated.json", Integer.valueOf(studentId)); }
            catch (NumberFormatException e) { System.out.println("Invalid Student ID.");continue; }
            catch (IndexOutOfBoundsException e) { System.out.println("Student ID not listed.");continue; }

           boolean x=true;
           while (x){
              jason_data.student_data("Out_Data/student-data_out.csv","Out_Data/cource_list_CSV.csv","Out_Data/Student_course_details_Generated.json", Integer.valueOf(studentId));

            System.out.println("Please choose from the following : ");
               System.out.println("a - Enroll in a course");
               System.out.println("d - Unenrollfrom an existing course");
               System.out.println("r - Replacing an existing course");
               System.out.println("b - Back to the main page\n");
               System.out.println("please select the required action:>");
               Scanner S = new Scanner(System.in);

               String User_input = S.next();
               if (User_input.equals("b")){x=false;};
               if (!(User_input.equals("a")||User_input.equals("d")||User_input.equals("r")||User_input.equals("b"))){System.out.println("Invalid Action.");continue;}

               switch (User_input) {
                   //________________________________________enroll from a course______________________________
                   case "a": {
                       System.out.println("Enrollment page");
                       System.out.println("====================================================================================================");

                       //print cource ditails
                       System.out.println(cources);

                       //console message
                       System.out.println("Please make one of the following:\n");
                       Scanner s2 = new Scanner(System.in);
                       String C_ID;
                       boolean PAGE1 = true;
                       while (PAGE1) {
                           System.out.println("-Enter the course ID that you want to enroll:");
                           System.out.println("OR-Enter \"b\" to go back to the menu Page:");
                           try {
                               C_ID = s2.next();
                               if  (C_ID.equals("b")) {PAGE1 = false;}
                               else {course_enrollment.course_enroll("Out_Data/Student_course_details_Generated.json",studentId,C_ID);continue;}
                           }
                           catch (NumberFormatException | IndexOutOfBoundsException e){System.out.println("Wrong choice! please enter a valid Course Id");continue;}

                       }
                       break;
                   }
                   //___________________________________________Unenroll from a course_________________________________________

                   case "d": {
                       //convert xml to csv and present

                       System.out.println(cources);

                       //messege to console
                       System.out.println("Please make one of the following:\n");
                       Scanner s2 = new Scanner(System.in);
                       String C_ID;
                       boolean PAGE = true;
                       while (PAGE) {

                           System.out.println("Enter the course ID that you want to unenroll:");
                           System.out.println("Enter \"b\" to go back to the menu page:");
                           try {
                               C_ID = s2.next();
                               if (C_ID.equals("b")) {PAGE = false;}
                               else {course_enrollment.course_unenroll("Out_Data/Student_course_details_Generated.json",studentId,C_ID) ;continue;}
                           }
                           catch (NumberFormatException | IndexOutOfBoundsException e){System.out.println("Wrong choice! please enter a valid Course Id");continue;}

                   }
                       break;

               }
               //____________________________________replace from a course___________________________________

                   case "r": {
                       boolean po = true;String c_d_r;String c_di_add;

                       while (po){
                           Scanner s3= new Scanner(System.in);
                           System.out.println("Enter the course id that you want to be replaced :");
                           System.out.println("Enter \"b\" to go back to the menu page:");

                              c_d_r = s3.next();

                           if (c_d_r.equals("b")) {po = false;}
                           if (!(c_d_r.contains(Json_Search.value_o))||c_d_r.length()>=2){System.out.println("Invalid course Id!");continue;}
                           else {
                               System.out.println("Available Courses");
                               System.out.println("====================================================================================================");
                               System.out.println(cources);
                               System.out.println("Please enter the required course id to replace:");
                               try {
                                   c_di_add=s3.next();

                                   course_enrollment.course_enroll_unenroll("Out_Data/Student_course_details_Generated.json",studentId,c_d_r,c_di_add);
                               }catch (NumberFormatException | IndexOutOfBoundsException e){System.out.println("Invalid course Id!");continue;}


                               System.out.println("Courses replaced successfully from "+File_line_to_array.fun_E("Out_Data/cource_list_CSV.csv", Integer.valueOf(c_d_r))[1]+" to "+File_line_to_array.fun_E("Out_Data/cource_list_CSV.csv", Integer.valueOf(c_di_add))[1]+" course\n");break;
                           }

                       }

                   }break;
           }
        }

    }
  }
 }

