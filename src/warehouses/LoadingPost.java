package warehouses;

import interfaces.DemonstratingStatus;

public class LoadingPost implements DemonstratingStatus {

    private Warehouse warehouseName;

    public LoadingPost(Warehouse warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Override
    public void showStatus() {
        if (warehouseName.areThereTrucksInWarehouse()) {
            System.out.println("Пост погрузки склада \"" + warehouseName.getWarehouseName() + "\" занят");
        } else {
            System.out.println("Пост загрузки склада \"" + warehouseName.getWarehouseName() + "\" пустует");
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
