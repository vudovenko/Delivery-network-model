package warehouses;

import cars.Truck;

import java.util.ArrayDeque;

public class CarPark {
    private static ArrayDeque<Truck> trucks;

    public CarPark(ArrayDeque<Truck> trucks) {
        CarPark.trucks = trucks;
    }

    public static void sendCarToWarehouse(Warehouse warehouse) {
        System.out.println("Грузовик едет на склад " + warehouse);
        warehouse.runMachineToWarehouse(trucks.pollFirst());
    }

    public ArrayDeque<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(ArrayDeque<Truck> trucks) {
        CarPark.trucks = trucks;
    }

    @Override
    public String toString() {
        return "CarPark{" +
                "trucks=" + trucks +
                '}';
    }
}
