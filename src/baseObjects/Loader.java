package baseObjects;

import interfaces.DemonstratingStatus;

public class Loader implements DemonstratingStatus {

    private Warehouse warehouseName;

    @Override
    public void showStatus() {
        if (warehouseName.areThereTrucksInWarehouse()) {
            System.out.println("Грузчик со склада " + warehouseName.getWarehouseName() + " загружает товар");
        } else {
            System.out.println("Грузчик со склада " + warehouseName.getWarehouseName() + " бездействует");
        }
    }

    public Loader(Warehouse warehouseName) {
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
