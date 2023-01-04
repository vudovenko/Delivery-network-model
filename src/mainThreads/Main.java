package mainThreads;

import cars.Truck;
import warehouses.Warehouse;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse("Склад1", "Железо");
        warehouse.startLoadingProcess(new Truck(30));
    }
}
