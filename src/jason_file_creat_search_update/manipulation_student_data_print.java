package jason_file_creat_search_update;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class manipulation_student_data_print {
    public static void Present_csv(String FILEPATH, int colom)  // print csv file into proper format
    {
        String line = "";
        String data = "";
        List<String> recordlist = new ArrayList<String>();
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
        String[][] outputarray = new String[recordlist.size()][colom];
        String[] line_array;
//        System.out.println(recordlist.get(0));

        for (int i = 0; i < recordlist.size(); i++) {
            line_array = recordlist.get(i).split(",");
            for (int j = 0; j < line_array.length; j++) {
                if (line_array[j].length() > 3 && line_array[j].length() < 20) {
                    outputarray[i][j] = line_array[j] + "                      ";
                } else if (line_array[j].length() > 10 && line_array[j].length() < 18) {
                    outputarray[i][j] = line_array[j] + "             ";
                } else if (j > 5) {
                    outputarray[i][j] = line_array[j] + "                ";
                } else {
                    outputarray[i][j] = line_array[j];
                }

            }
        }
//        System.out.println("---------------------------------------------------------------------------------------\n");
//        System.out.println("                            Current Student List");
//        System.out.println("---------------------------------------------------------------------------------------");

        for (int c = 0; c < outputarray.length; c++) {
            System.out.println(outputarray[c][0] + " " + outputarray[c][1] + "  " + outputarray[c][2] + "                " + outputarray[c][3] + "              " + outputarray[c][4]
                    + "                                                  " + outputarray[c][5] + "                                                         " + outputarray[c][6]);
        }

    }
}
