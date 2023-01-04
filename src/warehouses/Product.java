package warehouses;

import interfaces.DemonstratingStatus;
import towns.TypeProduct;

public class Product implements DemonstratingStatus {
    private Warehouse warehouseName;
    private TypeProduct typeProduct;

    public Product(Warehouse warehouseName, TypeProduct typeProduct) {
        this.warehouseName = warehouseName;
        this.typeProduct = typeProduct;
    }

    public Warehouse getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(Warehouse warehouseName) {
        this.warehouseName = warehouseName;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public void showStatus() {
        if (warehouseName.areThereTrucksInWarehouse()) {
            System.out.println("Товар " + typeProduct
                    + " со склада " + warehouseName.getWarehouseName() + " загружается в грузовик");
        } else {
            System.out.println("Товар " + typeProduct
                    + " со склада " + warehouseName.getWarehouseName() + " лежит");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "warehouseName=" + warehouseName +
                ", typeProduct=" + typeProduct +
                '}';
    }
}
