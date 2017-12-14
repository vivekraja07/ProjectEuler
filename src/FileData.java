//package textfiles;
import java.io.IOException;

public class FileData
{

    public static String[] moo() throws IOException
    {
        String file_name="/Users/vivekraja07/Desktop/EulersProject/Sherry.txt";

        try{
            ReadFile file= new ReadFile(file_name);
            String [] aryLines= file.OpenFile();
            return aryLines;
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}