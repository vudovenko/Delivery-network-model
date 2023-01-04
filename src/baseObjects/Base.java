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
        System.out.printf("База получила запрос из города \"" + orderRequest.getTown()
                + "\" от магазина №" + orderRequest.getShopId()
                + " на товар \"" + orderRequest.getTypeProduct() + "\"");
        Warehouse warehouse = Base.findSuitableWarehouse(orderRequest.getTypeProduct());

        CarPark.sendCarToWarehouse(warehouse);
    }

    public static Warehouse findSuitableWarehouse(TypeProduct typeProduct) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getProduct().getTypeProduct().equals(typeProduct)) {
                return warehouse;
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
