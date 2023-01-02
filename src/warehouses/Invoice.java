package warehouses;

import interfaces.DemonstratingStatus;

public class Invoice implements DemonstratingStatus {
    private String warehouseName;
    private Boolean isLoadingCompleted;

    @Override
    public void showStatus() {
        if (isLoadingCompleted) {
            System.out.println("Накаладная со склада " + warehouseName + " выдана водителю");
        } else {
            System.out.println("Погрузка товара на складе " + warehouseName + "еще не закончена");
        }
    }

    public Invoice(String warehouseName, Boolean isLoadingCompleted) {
        this.warehouseName = warehouseName;
        this.isLoadingCompleted = isLoadingCompleted;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Boolean getLoadingCompleted() {
        return isLoadingCompleted;
    }

    public void setLoadingCompleted(Boolean loadingCompleted) {
        isLoadingCompleted = loadingCompleted;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "warehouseName='" + warehouseName + '\'' +
                ", isLoadingCompleted=" + isLoadingCompleted +
                '}';
    }
}
