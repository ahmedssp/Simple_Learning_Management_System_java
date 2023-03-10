package jason_file_creat_search_update;

public class Format_jason {
    public  static String jason_format(String rowdata_jason){
        String jason="{"+rowdata_jason.replace("=",":").replace("]","],")+"}";
        return jason.replace(",}","}");
    }

}
