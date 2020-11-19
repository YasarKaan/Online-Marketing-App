package Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Write {
    public void writeFile(String user)  {
        try {
            String filename = "Yeni Metin Belgesi (2).txt";
            FileWriter fw = new FileWriter( filename, true );
            fw.write( "\n"+user );
            fw.close();
        } catch (IOException ioe) {
            System.err.println( "IOException: " + ioe.getMessage() );
        }
    }
}
