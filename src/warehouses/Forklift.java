package warehouses;

import interfaces.DemonstratingStatus;

public class Forklift implements DemonstratingStatus {
    private Warehouse warehouseName;

    @Override
    public void showStatus() {
        if (warehouseName.getIsTruckInWarehouse()) {
            System.out.println("Погрузчик начал погрузку на складе " + warehouseName);
        } else {
            System.out.println("Погрузчик свободен " + warehouseName);
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
