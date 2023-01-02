package warehouses;

import interfaces.DemonstratingStatus;

public class LoadingPost implements DemonstratingStatus {

    private String loadingPostName;
    private Boolean isTruckInWarehouse;

    public LoadingPost(String loadingPostName, Boolean isTruckInWarehouse) {
        this.loadingPostName = loadingPostName;
        this.isTruckInWarehouse = isTruckInWarehouse;
    }

    @Override
    public void showStatus() {
        if (isTruckInWarehouse) {
            System.out.println("Пост загрузки \"" + loadingPostName + "\" занят");
        } else {
            System.out.println("Пост загрузки \"" + loadingPostName + "\" пустует");
        }
    }

    public String getLoadingPostName() {
        return loadingPostName;
    }

    public void setLoadingPostName(String loadingPostName) {
        this.loadingPostName = loadingPostName;
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
                "loadingPostName='" + loadingPostName + '\'' +
                ", isTruckInWarehouse=" + isTruckInWarehouse +
                '}';
    }
}
