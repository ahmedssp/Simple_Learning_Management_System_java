package deluging_test;// Java program to write HashMap to a file

import java.io.*;
import java.util.*;

public  class read_arry_li {
    public static void write_file_Row_jason(HashMap<String, ArrayList<Integer>> Dictunary,String out_file_path){
        BufferedWriter bf = null;
        try {
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(new File(out_file_path)));
            // iterate map entries
            for (Map.Entry<String, ArrayList<Integer>> entry :
                    Dictunary.entrySet()) {

                // put key and value separated by a colon
                bf.write("\""+entry.getKey()+ "\""+ ":"
                        + entry.getValue());
                // new line
                bf.newLine();
            }
            bf.flush();
        }
        catch (IOException e) {e.printStackTrace();}
        finally {try {bf.close();} catch (Exception e) {}}
    }


    public static void write_file_Row_jason2(HashMap<Integer, ArrayList<Integer>> Dictunary,String out_file_path){
        BufferedWriter bf = null;
        try {
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(new File(out_file_path)));
            // iterate map entries
            for (Map.Entry<Integer, ArrayList<Integer>> entry :
                    Dictunary.entrySet()) {

                // put key and value separated by a colon
                bf.write("\""+entry.getKey()+ "\""+ ":"
                        + entry.getValue());
                // new line
                bf.newLine();
            }
            bf.flush();
        }
        catch (IOException e) {e.printStackTrace();}
        finally {try {bf.close();} catch (Exception e) {}}
    }

}