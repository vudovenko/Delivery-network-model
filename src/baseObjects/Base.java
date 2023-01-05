package baseObjects;

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

    public static void getProductRequest(OrderRequest orderRequest) {
        System.out.printf("База получила запрос из города \"" + orderRequest.getTown().getTownName()
                + "\" от магазина №" + orderRequest.getShopId()
                + " на товар \"" + orderRequest.getTypeProduct().getName() + "\"");
        Warehouse warehouse = Base.findSuitableWarehouse(orderRequest.getTypeProduct());

        CarPark.sendCarToWarehouse(warehouse);
    }

    public static Warehouse findSuitableWarehouse(TypeProduct typeProduct) {
        if (areThereMoreFreeSpacesInFirstParkingLot(typeProduct)) {
            return findFirstWarehouseForHeavyOversize();
        } else if (areThereMoreFreeSpacesInFirstParkingLot(typeProduct)) {
            return findSecondWarehouseForHeavyOversize();
        } else {
            for (Warehouse warehouse : warehouses) {
                if (warehouse.getProduct().getTypeProduct().equals(typeProduct)) {
                    return warehouse;
                }
            }
        }
        return null;
    }

    private static Boolean areThereMoreFreeSpacesInFirstParkingLot(TypeProduct typeProduct) {
        return typeProduct == TypeProduct.HEAVY_OVERSIZE &&
                findFirstWarehouseForHeavyOversize().getParkingSpace().getParkingSize() <
                        findSecondWarehouseForHeavyOversize().getParkingSpace().getParkingSize();
    }

    private static Warehouse findFirstWarehouseForHeavyOversize() {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getProduct().getTypeProduct() == TypeProduct.HEAVY_OVERSIZE) {
                return warehouse;
            }
        }
        return null;
    }

    private static Warehouse findSecondWarehouseForHeavyOversize() {
        Integer counter = 0;
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getProduct().getTypeProduct() == TypeProduct.HEAVY_OVERSIZE && counter == 1) {
                return warehouse;
            } else {
                counter++;
            }
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
