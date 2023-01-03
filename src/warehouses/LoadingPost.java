package warehouses;

import interfaces.DemonstratingStatus;

public class LoadingPost implements DemonstratingStatus {

    private Warehouse warehouseName;

    public LoadingPost(Warehouse warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Override
    public void showStatus() {
        if (warehouseName.getIsTruckInWarehouse()) {
            System.out.println("Пост погрузки склада \"" + warehouseName + "\" занят");
        } else {
            System.out.println("Пост загрузки склада \"" + warehouseName + "\" пустует");
        }
    }

    public Warehouse getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(Warehouse warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Override
    public String toString() {
        return "LoadingPost{" +
                "warehouseName=" + warehouseName +
                '}';
    }
}
