package warehouses;

import interfaces.DemonstratingStatus;

public class Product implements DemonstratingStatus {
    private Warehouse warehouseName;
    private String productName;

    public Product(Warehouse warehouseName, String productName) {
        this.warehouseName = warehouseName;
        this.productName = productName;
    }

    public Warehouse getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(Warehouse warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void showStatus() {
        if (warehouseName.getIsTruckInWarehouse()) {
            System.out.println("Товар " + productName
                    + " со склада " + warehouseName + " загружается в грузовик");
        } else {
            System.out.println("Товар " + productName
                    + " со склада " + warehouseName + " лежит");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "warehouseName=" + warehouseName +
                ", productName='" + productName + '\'' +
                '}';
    }
}
