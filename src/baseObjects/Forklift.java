package baseObjects;

import interfaces.DemonstratingStatus;

public class Forklift implements DemonstratingStatus {
    private Warehouse warehouseName;

    @Override
    public void showStatus() {
        if (warehouseName.areThereTrucksInWarehouse()) {
            System.out.println("Погрузчик начал погрузку на складе " + warehouseName.getWarehouseName());
        } else {
            System.out.println("Погрузчик на складе " + warehouseName.getWarehouseName() + " свободен");
        }
    }

    public Forklift(Warehouse warehouseName) {
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
        return "Forklift{" +
                "warehouseName=" + warehouseName +
                '}';
    }
}
