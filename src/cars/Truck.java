package cars;

public class Truck extends Car {

    public Truck(Integer speed, Integer timeInWarehouse) {
        super(speed, timeInWarehouse);
    }

    @Override
    public String toString() {
        return "Грузовик";
    }
}
