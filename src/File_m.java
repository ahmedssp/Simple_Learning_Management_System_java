import java.io.*;

public class File_m {
    public static String Creat_New_file(String name) throws IOException  //Create new file  function
    {
        File x = new File(name);
        if (x.createNewFile()) {
        }
        return "New file name:"+x.getName();

    }
    static void AddToFile(String path, String content) throws IOException   {
            try {

                File file = new File(path);

                // if file doesnt exists, then create it
                if (!file.exists())
                    file.createNewFile();

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    static void Write(String name, String content) throws IOException // write on file function
    {
        FileWriter w = new FileWriter(name);
        w.write(content);
        w.close();
    }
    public static String ReadFile(String path) { // Function to read file
        String line = "";
        String data = "";
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
        return data;
    }
}
