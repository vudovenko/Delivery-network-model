package baseObjects;

import cars.Kamaz;
import mainThreads.Main;
import mainThreads.TimeClass;
import towns.OrderRequest;
import towns.TypeProduct;

import java.util.ArrayList;
import java.util.List;

public class Base {

    private static List<Warehouse> warehouses;

    public Base(List<Warehouse> warehouses) {
        Base.warehouses = warehouses;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        Base.warehouses = warehouses;
    }

    public static void sendKamazToWarehouses() {
        new Thread(() -> {
            while (true) {
                Kamaz kamaz = new Kamaz(25, 20, 4);
                try {
                    Thread.sleep((long) Main
                            .randomNumberInRange(0, kamaz.getTimeInWarehouse()) * 24 * TimeClass.VIRTUAL_HOUR);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (Warehouse warehouse : warehouses) {
                    warehouse.runMachineToWarehouse(kamaz);
                    while (warehouse.getHasKamazArrived()) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();
    }

    public static void getProductRequest(OrderRequest orderRequest) {
        System.out.printf("База получила запрос из города " + orderRequest.getTown().getTownName()
                + " от магазина №" + orderRequest.getStore().getId()
                + " на товар " + orderRequest.getTypeProduct().getName());
        Warehouse warehouse = Base.findSuitableWarehouse(orderRequest.getTypeProduct());

        CarPark.sendCarToWarehouse(warehouse, orderRequest);
    }

    public static Warehouse findSuitableWarehouse(TypeProduct typeProduct) {
        if (typeProduct == TypeProduct.HEAVY_OVERSIZE) {
            return findFirstAndSecondWarehouseForHeavyOversize();
        } else {
            for (Warehouse warehouse : warehouses) {
                if (warehouse.getProduct().getTypeProduct().equals(typeProduct)) {
                    return warehouse;
                }
            }
        }
        return null;
    }

    private static Warehouse findFirstAndSecondWarehouseForHeavyOversize() {
        List<Warehouse> warehousesForHeavyOversize = new ArrayList<>();
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getProduct().getTypeProduct() == TypeProduct.HEAVY_OVERSIZE) {
                warehousesForHeavyOversize.add(warehouse);
            }
        }
        return determineWarehouseWithMostParkingSpaces(warehousesForHeavyOversize);
    }

    private static Warehouse determineWarehouseWithMostParkingSpaces(List<Warehouse> warehousesForHeavyOversize) {
        if (warehousesForHeavyOversize.get(0).getParkingSpace().getParkingSize() <
                warehousesForHeavyOversize.get(1).getParkingSpace().getParkingSize()) {
            return warehousesForHeavyOversize.get(0);
        } else {
            return warehousesForHeavyOversize.get(1);
        }
    }

    @Override
    public String toString() {
        return "Base{" +
                "warehouses=" + warehouses +
                '}';
    }
}
