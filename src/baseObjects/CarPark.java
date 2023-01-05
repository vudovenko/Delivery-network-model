package baseObjects;

import cars.Truck;

import java.util.ArrayDeque;

public class CarPark {
    private static ArrayDeque<Truck> trucks;

    public CarPark() {
        trucks = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            trucks.addLast(new Truck(30, 1)); // todo поработать над скоростью траков
        }
    }

    public static void sendCarToWarehouse(Warehouse warehouse) {
        System.out.println("\nГрузовик едет на склад " + warehouse.getWarehouseName() + "\n");
        warehouse.runMachineToWarehouse(trucks.pollFirst());
    }

    public static void sendCarToPark(Truck truck) {
        trucks.addLast(truck);
        System.out.println("Грузовик прибыл в парк. " +
                "Машин в парке: " + trucks.size() + " штук");
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
