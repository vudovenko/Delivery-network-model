package warehouses;

import interfaces.DemonstratingStatus;

public class Product implements DemonstratingStatus {

    private Warehouse warehouseName;
    private Boolean isTruckInWarehouse;
    private String productName;

    public Product(Warehouse warehouseName, Boolean isTruckInWarehouse, String productName) {
        this.warehouseName = warehouseName;
        this.isTruckInWarehouse = isTruckInWarehouse;
        this.productName = productName;
    }

    public Warehouse getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(Warehouse warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Boolean getTruckInWarehouse() {
        return isTruckInWarehouse;
    }

    public void setTruckInWarehouse(Boolean truckInWarehouse) {
        isTruckInWarehouse = truckInWarehouse;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void showStatus() {
        if (isTruckInWarehouse) {
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
                "warehouseName='" + warehouseName + '\'' +
                ", isTruckInWarehouse=" + isTruckInWarehouse +
                ", productName='" + productName + '\'' +
                '}';
    }
}
