package cars;

import towns.Town;

public class Truck extends Car {

    private Town town;

    public Truck(Integer speed, Integer timeInWarehouse, Town town) {

        super(speed, timeInWarehouse);
    }

    @Override
    public String toString() {
        return "Грузовик";
    }
}
