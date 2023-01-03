package warehouses;

import interfaces.DemonstratingStatus;

public class Storekeeper implements DemonstratingStatus {

    private Warehouse warehouseName;

    @Override
    public void showStatus() {
        if (warehouseName.getIsTruckInWarehouse()) {
            System.out.println("Кладовщик склада " + warehouseName + " идет на пост загрузки");
        } else {
            System.out.println("Кладовщик склада " + warehouseName + " бездействует");
        }
    }

    public Storekeeper(Warehouse warehouseName) {
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
        return "Storekeeper{" +
                "warehouseName=" + warehouseName +
                '}';
    }
}
