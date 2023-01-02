package warehouses;

import interfaces.DemonstratingStatus;

public class LoadingPost implements DemonstratingStatus {

    private String warehouseName;
    private Boolean isTruckInWarehouse;

    public LoadingPost(String warehouseName, Boolean isTruckInWarehouse) {
        this.warehouseName = warehouseName;
        this.isTruckInWarehouse = isTruckInWarehouse;
    }

    @Override
    public void showStatus() {
        if (isTruckInWarehouse) {
            System.out.println("Пост погрузки склада \"" + warehouseName + "\" занят");
        } else {
            System.out.println("Пост загрузки склада \"" + warehouseName + "\" пустует");
        }
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
        return "LoadingPost{" +
                "loadingPostName='" + warehouseName + '\'' +
                ", isTruckInWarehouse=" + isTruckInWarehouse +
                '}';
    }
}
