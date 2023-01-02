package warehouses;

public class Storekeeper {

    private String warehouseName;

    public void GoToLoadingPost() {
        System.out.println("Кладовщик склада " + warehouseName + " идет на пост загрузки");
    }

    public Storekeeper(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Override
    public String toString() {
        return "Storekeeper{" +
                "warehouseName='" + warehouseName + '\'' +
                '}';
    }
}
