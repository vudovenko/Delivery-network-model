package warehouses;

import interfaces.DemonstratingStatus;

public class Loader implements DemonstratingStatus {

    private String warehouseName;
    private Integer loaderNumber;
    private Boolean isTruckInWarehouse;

    @Override
    public void showStatus() {
        if (isTruckInWarehouse) {
            System.out.println("Грузчик № " + loaderNumber
                    + " склада " + warehouseName + " идет на пост загрузки");
        } else {
            System.out.println("Грузчик № " + loaderNumber
                    + " склада " + warehouseName + " бездействует");
        }
    }

    public Loader(String warehouseName, Integer loaderNumber, Boolean isTruckInWarehouse) {
        this.warehouseName = warehouseName;
        this.loaderNumber = loaderNumber;
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
        return "Loader{" +
                "loaderName='" + warehouseName + '\'' +
                ", isTruckInWarehouse=" + isTruckInWarehouse +
                '}';
    }
}
