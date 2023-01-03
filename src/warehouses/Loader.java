package warehouses;

import interfaces.DemonstratingStatus;

public class Loader implements DemonstratingStatus {

    private Warehouse warehouseName;

    @Override
    public void showStatus() {
        if (warehouseName.isThereRoomInWarehouseForTruck()) {
            System.out.println("Грузчик со склада " + warehouseName + " загружает товар");
        } else {
            System.out.println("Грузчик со склада " + warehouseName + " бездействует");
        }
    }

    public Loader(Warehouse warehouseName, Integer loaderNumber) {
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
        return "Loader{" +
                "warehouseName=" + warehouseName +
                '}';
    }
}
