package ns.mkx.demo.databaseService;

import ns.mkx.demo.service.Car;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("database")
public class DBHandler extends Config {
    Connection connection;
    public Connection getConnection() throws SQLException {
        String connectionString = "jdbc:mysql://" + localhost + ":" + port + "/" + databaseName;
        connection = DriverManager.getConnection(connectionString, user, password);
        return connection;
    }
    public List<Car> getDBValues() throws SQLException, NullPointerException {
        getConnection();
        List<Car> list = new ArrayList<>();
        String getValues = "SELECT * FROM " + Const.CAR_DATABASE;
        PreparedStatement prSt = connection.prepareStatement(getValues);
        ResultSet set = prSt.executeQuery();
        while(set.next()){
            int car_id = set.getInt(1);
            String car_name = set.getString(2);
            String car_specification_name = set.getString(3);
            int car_hp = set.getInt(4);
            double car_price = set.getDouble(5);
            list.add(new Car(car_id, car_name, car_specification_name, car_hp, car_price));
        }
        prSt.close();
        return list;
    }
    public void insertIntoDB(int car_id, String car_name, String car_specification_name, int car_hp, double car_price) throws SQLException {
        getConnection();
        String insertValues = "INSERT INTO " + Const.CAR_DATABASE +"(" + Const.CAR_ID + ", " + Const.CAR_NAME + ", " + Const.CAR_SPECIFICATION_NAME + ", " + Const.CAR_HP + ", " + Const.CAR_PRICE +") VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement prSt = connection.prepareStatement(insertValues);
            prSt.setInt(1, car_id);
            prSt.setString(2, car_name);
            prSt.setString(3, car_specification_name);
            prSt.setInt(4, car_hp);
            prSt.setDouble(5, car_price);
            prSt.execute();
            prSt.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
