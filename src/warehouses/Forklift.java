package warehouses;

import interfaces.DemonstratingStatus;

public class Forklift implements DemonstratingStatus {
    private String warehouseName;
    private Boolean isTruckInWarehouse;

    @Override
    public void showStatus() {
        if (isTruckInWarehouse) {
            System.out.println("Погрузчик начал погрузку на складе " + warehouseName);
        } else {
            System.out.println("Погрузчик свободен " + warehouseName);
        }
    }

    public Forklift(String warehouseName, Boolean isTruckInWarehouse) {
        this.warehouseName = warehouseName;
        this.isTruckInWarehouse = isTruckInWarehouse;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
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
        return "Forklift{" +
                "warehouseName='" + warehouseName + '\'' +
                ", isTruckInWarehouse=" + isTruckInWarehouse +
                '}';
    }
}
