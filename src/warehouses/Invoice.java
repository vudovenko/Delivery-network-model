package warehouses;

import interfaces.DemonstratingStatus;

public class Invoice implements DemonstratingStatus {
    private Warehouse warehouseName;

    @Override
    public void showStatus() {
        if (warehouseName.getIsTruckInWarehouse()) {
            System.out.println("Накладная со склада " + warehouseName + " выдана водителю");
        } else {
            System.out.println("Погрузка товара на складе " + warehouseName + "еще не закончена");
        }
    }

    public Invoice(Warehouse warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Warehouse getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(Warehouse warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "warehouseName=" + warehouseName +
                '}';
    }
}
