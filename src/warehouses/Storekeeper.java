package warehouses;

import interfaces.DemonstratingStatus;

public class Storekeeper implements DemonstratingStatus {

    private Warehouse warehouseName;

    @Override
    public void showStatus() {
        if (warehouseName.isThereRoomInWarehouseForTruck()) {
            System.out.println("Кладовщик склада " + warehouseName.getWarehouseName() + " идет на пост загрузки");
        } else {
            System.out.println("Кладовщик склада " + warehouseName.getWarehouseName() + " бездействует");
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
