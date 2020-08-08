package shop.tools;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class FileTools {



    public void writeInLogFile(List<String> logs, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        for (String line : logs) {
            writer.write(String.format("%s%n", line));
        }
        writer.close();
    }
    
    public void deleteContentOfFile(String filePath) {
    	
    	
    }
}
