package warehouses;

import towns.OrderRequest;
import towns.TypeProduct;

import java.util.List;

public class Base {

    private List<Warehouse> warehouses;

    public Base(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    private static void getProductRequest(OrderRequest orderRequest) {
        System.out.printf("База получила запрос из города \"" + orderRequest.getTown()
                + "\" от магазина №" + orderRequest.getShopId()
                + " на товар \"" + orderRequest.getTypeProduct() + "\"");

    }

    private Warehouse findSuitableWarehouse(TypeProduct typeProduct) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getProduct().getTypeProduct().equals(typeProduct)) {
                /*
                * todo
                *  доделать поиск склада*/
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
