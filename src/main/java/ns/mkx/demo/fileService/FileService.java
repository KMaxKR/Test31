package ns.mkx.demo.fileService;

import ns.mkx.demo.databaseService.DBHandler;
import ns.mkx.demo.service.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component("fileService")
public class FileService{
    @Qualifier("database")
    @Autowired
    private DBHandler database;

    @Qualifier("fileWriter")
    @Autowired
    private fileWrite writer;

    @Qualifier("fileReader")
    @Autowired
    private fileReader reader;

    public void createFile(String fileName){
        File file = new File(fileName);
        try{
            file.createNewFile();
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public void writeIntoFile(String fileName) throws SQLException {
        List<String> list = new ArrayList<>();
        for (Car element: database.getDBValues()){
            list.add(String.valueOf(element));
        }
        writer.writeIntoFile(fileName, list);
    }
    public void readFromFile(String fileName){
        System.out.println(reader.readFile(fileName));
    }
}
