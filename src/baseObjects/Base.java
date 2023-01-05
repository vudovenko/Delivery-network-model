package baseObjects;

import cars.Kamaz;
import towns.OrderRequest;
import towns.TypeProduct;

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
            Kamaz kamaz = new Kamaz(25, 3);
            for (Warehouse warehouse : warehouses) {
                warehouse.runMachineToWarehouse(kamaz);
                while(warehouse.getHasKamazArrived()) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    public static void getProductRequest(OrderRequest orderRequest) {
        System.out.printf("База получила запрос из города \"" + orderRequest.getTown().getTownName()
                + "\" от магазина №" + orderRequest.getShopId()
                + " на товар \"" + orderRequest.getTypeProduct().getName() + "\"");
        Warehouse warehouse = Base.findSuitableWarehouse(orderRequest.getTypeProduct());

        CarPark.sendCarToWarehouse(warehouse);
    }

    public static Warehouse findSuitableWarehouse(TypeProduct typeProduct) {
        if (typeProduct == TypeProduct.HEAVY_OVERSIZE && warehouses.get(0).getParkingSpace().getParkingSize() >
                warehouses.get(1).getParkingSpace().getParkingSize()) {
            return warehouses.get(1);
        } else if (typeProduct == TypeProduct.HEAVY_OVERSIZE && warehouses.get(0).getParkingSpace().getParkingSize() <
                warehouses.get(1).getParkingSpace().getParkingSize()) {
            return warehouses.get(0);
        } else {

        }
        return null;
    }

    @Override
    public String toString() {
        return "Base{" +
                "warehouses=" + warehouses +
                '}';
    }
}
