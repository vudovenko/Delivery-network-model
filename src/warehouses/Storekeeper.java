package warehouses;

import interfaces.DemonstratingStatus;

public class Storekeeper implements DemonstratingStatus {

    private Warehouse warehouseName;
    private Boolean isTruckInWarehouse;

    @Override
    public void showStatus() {
        if (isTruckInWarehouse) {
            System.out.println("Кладовщик склада " + warehouseName + " идет на пост загрузки");
        } else {
            System.out.println("Кладовщик склада " + warehouseName + " бездействует");
        }
    }

    public Storekeeper(Warehouse warehouseName, Boolean isTruckInWarehouse) {
        this.warehouseName = warehouseName;
        this.isTruckInWarehouse = isTruckInWarehouse;
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

    @Override
    public String toString() {
        return "Storekeeper{" +
                "warehouseName=" + warehouseName +
                ", isTruckInWarehouse=" + isTruckInWarehouse +
                '}';
    }
}
