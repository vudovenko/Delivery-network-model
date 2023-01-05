package baseObjects;

import cars.Truck;
import mainThreads.TimeClass;
import towns.OrderRequest;
import towns.Store;
import towns.Town;

import java.util.ArrayDeque;

public class CarPark {
    private static ArrayDeque<Truck> trucks;

    public CarPark() {
        trucks = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            trucks.addLast(new Truck(45, 30, 1));
        }
    }

    public static void sendCarToWarehouse(Warehouse warehouse, OrderRequest orderRequest) {
        System.out.println("\nГрузовик едет на склад " + warehouse.getWarehouseName() + "\n");
        Truck truck = trucks.pollFirst();
        truck.setTown(orderRequest.getTown());
        truck.setStore(orderRequest.getStore());
        truck.setTypeProduct(orderRequest.getTypeProduct());

        warehouse.runMachineToWarehouse(truck);
    }

    public static void sendCarToPark(Truck truck) {
        new Thread(() -> {
            try {
                Thread.sleep(Store.calculateTravelTime(truck) * TimeClass.VIRTUAL_HOUR);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            trucks.addLast(truck);
            System.out.println("Грузовик прибыл в парк. " +
                    "Машин в парке: " + trucks.size() + " штук");
        }).start();
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
