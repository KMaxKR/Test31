package ns.mkx.demo.fileService;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


@Component("fileReader")
public class fileReader {
    public List<String> readFile(String fileName){
        List<String> list = new ArrayList<>();
        try(BufferedReader buffered = new BufferedReader(new java.io.FileReader(fileName))){
            String s;
            while((s = buffered.readLine()) != null){
                list.add(s);
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return list;
    }
}
