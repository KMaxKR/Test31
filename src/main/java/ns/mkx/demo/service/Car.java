package ns.mkx.demo.service;

public class Car {
    private int car_id;
    private String car_name;
    private String car_specification_name;
    private int car_hp;
    private double car_price;

    public Car(int car_id, String car_name, String car_specification_name, int car_hp, double car_price){
        this.car_id = car_id;
        this.car_name = car_name;
        this.car_specification_name = car_specification_name;
        this.car_hp = car_hp;
        this.car_price = car_price;
    }

    @Override
    public String toString() {
        return "Car: " + car_id + " " + car_name + " " +
                car_specification_name + " " +
                car_hp + " " + car_price;
    }
}
