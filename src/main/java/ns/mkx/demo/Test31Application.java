package ns.mkx.demo;

import ns.mkx.demo.databaseService.DBHandler;
import ns.mkx.demo.fileService.FileService;
import ns.mkx.demo.service.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Test31Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Test31Application.class, args);
	}

	@Qualifier("database")
	@Autowired
	DBHandler database;

	@Qualifier("fileService")
	@Autowired
	FileService fileService;

	@Override
	public void run(String... args) throws Exception {
		database.insertIntoDB(1,"Mercedes", "GT 63S", 689, 164586.89);
		database.insertIntoDB(2,"BMW", "F90", 700, 120500);
		database.insertIntoDB(3,"BMW", "F30", 420, 34599.39);
		System.out.println(database.getDBValues());
		fileService.createFile("test");
		fileService.writeIntoFile("test");
		fileService.readFromFile("test");
	}
}
