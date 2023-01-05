package cars;

public class Kamaz extends Car {

    public Kamaz(Integer nightSpeed, Integer daySpeed, Integer timeInWarehouse) {
        super(nightSpeed, daySpeed, timeInWarehouse);
    }

    @Override
    public String toString() {
        return "Камаз";
    }
}
