import com.sun.jdi.Value;

import java.util.*;

class My_Dictionary
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

}
