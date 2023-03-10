package convertFiles_to_CSV;

import java.io.*;

public class course_XML_TO_CSV {
    public static String ReadFile(String path) { // Function to read file
        String line = "";
        String data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (line != null) {
                if (line == null) break;
                data += line.trim();
                line = br.readLine();
            }
            br.close();}
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return data;
    }

    public static String formate(String out) {  // Function to convert file to propare format

        return "id,CourseName,Instructor,CourseDuration,CourseTime,Location\n"
                +out.trim().replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","")
                .replace(".","").replace(";","").replace(",","")
                .replace("<id>","").replace("</id>",".")
                .replace("<row>","")
                .replace("<root>","").replace("</root>","")
                .replace("<CourseName>","").replace("</CourseName>",",")
                .replace("<Instructor>","").replace("</Instructor>",",")
                .replace("<CourseDuration>","").replace("</CourseDuration>",",")
                .replace("<CourseTime>","").replace("</CourseTime>",",")
                .replace("<Location>","").replace("</Location>","")
                .replace("</row>","\n");

    }

}
