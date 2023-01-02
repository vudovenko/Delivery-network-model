package warehouses;

import interfaces.DemonstratingStatus;

public class Storekeeper implements DemonstratingStatus {

    private String warehouseName;
    private Boolean isTruckInWarehouse;

    @Override
    public void showStatus() {
        if (isTruckInWarehouse) {
            System.out.println("Кладовщик склада " + warehouseName + " идет на пост загрузки");
        } else {
            System.out.println("Кладовщик склада " + warehouseName + " бездействует");
        }
    }

    public Storekeeper(String warehouseName, Boolean isTruckInWarehouse) {
        this.warehouseName = warehouseName;
        this.isTruckInWarehouse = isTruckInWarehouse;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Override
    public String toString() {
        return "Storekeeper{" +
                "warehouseName='" + warehouseName + '\'' +
                '}';
    }
}
