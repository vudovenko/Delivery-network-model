package cars;

public class Kamaz extends Car {

    public Kamaz(Integer speed, Integer timeInWarehouse) {
        super(speed, timeInWarehouse);
    }

    @Override
    public String toString() {
        return "Камаз";
    }
}
