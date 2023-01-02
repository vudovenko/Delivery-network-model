package warehouses;

import interfaces.DemonstratingStatus;

public class Loader implements DemonstratingStatus {

    private Warehouse warehouseName;
    private Integer loaderNumber;
    private Boolean isTruckInWarehouse;

    @Override
    public void showStatus() {
        if (isTruckInWarehouse) {
            System.out.println("Грузчик № " + loaderNumber
                    + " склада " + warehouseName + " загружает товар");
        } else {
            System.out.println("Грузчик № " + loaderNumber
                    + " склада " + warehouseName + " бездействует");
        }
    }

    public Loader(Warehouse warehouseName, Integer loaderNumber, Boolean isTruckInWarehouse) {
        this.warehouseName = warehouseName;
        this.loaderNumber = loaderNumber;
        this.isTruckInWarehouse = isTruckInWarehouse;
    }

    public Warehouse getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(Warehouse warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getLoaderNumber() {
        return loaderNumber;
    }

    public void setLoaderNumber(Integer loaderNumber) {
        this.loaderNumber = loaderNumber;
    }

    public Boolean getTruckInWarehouse() {
        return isTruckInWarehouse;
    }

    public void setTruckInWarehouse(Boolean truckInWarehouse) {
        isTruckInWarehouse = truckInWarehouse;
    }

    @Override
    public String toString() {
        return "Loader{" +
                "loaderName='" + warehouseName + '\'' +
                ", isTruckInWarehouse=" + isTruckInWarehouse +
                '}';
    }
}
