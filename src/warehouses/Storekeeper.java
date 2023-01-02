package warehouses;

import interfaces.DemonstratingStatus;

public class Storekeeper implements DemonstratingStatus {

    private String storekeeperName;
    private Boolean isTruckInWarehouse;

    @Override
    public void showStatus() {
        if (isTruckInWarehouse) {
            System.out.println("Кладовщик склада " + storekeeperName + " идет на пост загрузки");
        } else {
            System.out.println("Кладовщик склада " + storekeeperName + " бездействует");
        }
    }

    public Storekeeper(String storekeeperName, Boolean isTruckInWarehouse) {
        this.storekeeperName = storekeeperName;
        this.isTruckInWarehouse = isTruckInWarehouse;
    }

    public String getStorekeeperName() {
        return storekeeperName;
    }

    public void setStorekeeperName(String storekeeperName) {
        this.storekeeperName = storekeeperName;
    }

    @Override
    public String toString() {
        return "Storekeeper{" +
                "warehouseName='" + storekeeperName + '\'' +
                '}';
    }
}
