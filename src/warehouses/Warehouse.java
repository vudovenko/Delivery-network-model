package warehouses;

import cars.Car;

public class Warehouse {
    private String warehouseName;
    private Forklift forklift;
    private Invoice invoice;
    private Loader loader; //TODO реализовать номер грузчика на складе
    private LoadingPost loadingPost;
    private Product product;
    private Storekeeper storekeeper;
    private static Boolean isTruckInWarehouse;

    public Warehouse(String warehouseName, String productName) {
        this.warehouseName = warehouseName;
        this.forklift = new Forklift(this);
        this.invoice = new Invoice(this);
        this.loader = new Loader(this, 2);
        this.loadingPost = new LoadingPost(this);
        this.product = new Product(this, productName);
        this.storekeeper = new Storekeeper(this);
    }

    public static Boolean getIsTruckInWarehouse() {
        return isTruckInWarehouse;
    }

    public static void setIsTruckInWarehouse(Boolean isTruckInWarehouse) {
        Warehouse.isTruckInWarehouse = isTruckInWarehouse;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Forklift getForklift() {
        return forklift;
    }

    public void setForklift(Forklift forklift) {
        this.forklift = forklift;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Loader getLoader() {
        return loader;
    }

    public void setLoader(Loader loader) {
        this.loader = loader;
    }

    public LoadingPost getLoadingPost() {
        return loadingPost;
    }

    public void setLoadingPost(LoadingPost loadingPost) {
        this.loadingPost = loadingPost;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public void startLoadingProcess(Car car) {

    }
}
