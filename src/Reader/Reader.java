package Reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    public static Scanner read(String filepath){
        File file = new File(filepath);
        try {
            Scanner fileArray = new Scanner(file);
            return fileArray;
        }catch (FileNotFoundException e){
            System.out.println( e.getMessage() );
            return null;
        }

    }
}
