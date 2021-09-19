import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {
    public void fileWriter(String line){
    try
    {
        File file = new File("moria.txt");
        BufferedWriter outputFile = new BufferedWriter(
                new FileWriter(file,true));

        outputFile.write(line);
        outputFile.newLine();
        outputFile.close();
    }
        catch (IOException fileError)
        {
            System.out.println("Problems found: " +
                        fileError.getMessage() );
        }
    }
}
