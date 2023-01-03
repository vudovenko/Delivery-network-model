package warehouses;

import interfaces.DemonstratingStatus;

public class Loader implements DemonstratingStatus {

    private Warehouse warehouseName;
    private Integer loaderNumber;

    @Override
    public void showStatus() {
        if (warehouseName.getIsTruckInWarehouse()) {
            System.out.println("Грузчик № " + loaderNumber
                    + " склада " + warehouseName + " загружает товар");
        } else {
            System.out.println("Грузчик № " + loaderNumber
                    + " склада " + warehouseName + " бездействует");
        }
    }

    public Loader(Warehouse warehouseName, Integer loaderNumber) {
        this.warehouseName = warehouseName;
        this.loaderNumber = loaderNumber;
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

    @Override
    public String toString() {
        return "Loader{" +
                "warehouseName=" + warehouseName +
                ", loaderNumber=" + loaderNumber +
                '}';
    }
}
