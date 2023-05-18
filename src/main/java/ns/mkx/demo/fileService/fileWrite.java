package ns.mkx.demo.fileService;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

@Component("fileWriter")
public class fileWrite {

    public void writeIntoFile(String fileName, List<String> objectList){
        try(BufferedWriter buffered = new BufferedWriter(new FileWriter(fileName))){
            for(String element: objectList){
                buffered.write(element);
                buffered.newLine();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
