package warehouses;

import cars.Car;

public class Warehouse {
    private String warehouseName;
    private Forklift forklift;
    private Invoice invoice;
    private Loader loaders;
    private LoadingPost loadingPost;
    private Product product;
    private Storekeeper storekeeper;
    private static Integer numberTrucksInStock;

    public Warehouse(String warehouseName, String productName) {
        this.warehouseName = warehouseName;
        this.forklift = new Forklift(this);
        this.invoice = new Invoice(this);
        this.loaders = new Loader(this, 2);
        this.loadingPost = new LoadingPost(this);
        this.product = new Product(this, productName);
        this.storekeeper = new Storekeeper(this);
        numberTrucksInStock = 0;
    }

    public Boolean isThereRoomInWarehouseForTruck() {
        if (numberTrucksInStock == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Loader getLoaders() {
        return loaders;
    }

    public void setLoaders(Loader loaders) {
        this.loaders = loaders;
    }

    public static Integer getNumberTrucksInStock() {
        return numberTrucksInStock;
    }

    public static void setNumberTrucksInStock(Integer numberTrucksInStock) {
        Warehouse.numberTrucksInStock = numberTrucksInStock;
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
        /*TODO 1. Машина добавляется в очередь в любом случае
           2. Если она в очереди первая или вторая, то вызов showStatus()
              у Storekeeper, у LoadingPost, у Forklift и у Loader
              Начинается отсчет времени (1 час) для warehouse.
              Срабатывает метод showStatus() у товара и у накладной.
              Удаляется из очереди.
           3. Если в очереди не первая или вторая, то ждет своей очереди.
        */
    }
}
