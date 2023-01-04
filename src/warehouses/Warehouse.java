package warehouses;

import cars.Car;

public class Warehouse {
    private String warehouseName;
    private Forklift forklift;
    private Invoice invoice;
    private Loader loader;
    private LoadingPost loadingPost;
    private Product product;
    private Storekeeper storekeeper;
    private ParkingSpace parkingSpace;
    private static Integer numberTrucksInWarehouse;

    public Warehouse(String warehouseName, String productName) {
        this.warehouseName = warehouseName;
        this.forklift = new Forklift(this);
        this.invoice = new Invoice(this);
        this.loader = new Loader(this);
        this.loadingPost = new LoadingPost(this);
        this.product = new Product(this, productName);
        this.storekeeper = new Storekeeper(this);
        parkingSpace = new ParkingSpace();
        numberTrucksInWarehouse = 0;
    }

    public synchronized Boolean isThereRoomInWarehouseForTruck() {
        return numberTrucksInWarehouse == 0;
    }

    public Loader getLoader() {
        return loader;
    }

    public void setLoader(Loader loader) {
        this.loader = loader;
    }

    public synchronized static Integer getNumberTrucksInWarehouse() {
        return numberTrucksInWarehouse;
    }

    public synchronized static void setNumberTrucksInWarehouse(Integer numberTrucksInWarehouse) {
        Warehouse.numberTrucksInWarehouse = numberTrucksInWarehouse;
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

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public void startLoadingProcess(Car car) {
        /*TODO
           1. Машина добавляется в очередь в любом случае
           2. Если она в очереди первая или вторая, то вызов showStatus()
              у Storekeeper, у LoadingPost, у Forklift и у Loader
              Начинается отсчет времени (1 час) для warehouse.
              Срабатывает метод showStatus() у товара и у накладной.
              Удаляется из очереди.
           3. Если в очереди не первая или вторая, то ждет своей очереди.
        */
        parkingSpace.addCarToParkingSpace(car);
        if (parkingSpace.getParkingSize() == 1) {
            runMachineToWarehouse(car);
        } else if (parkingSpace.getParkingSize() == 2) {
            runMachineToWarehouse(car);
        } else {
            while(parkingSpace.getParkingSize() > 2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            startLoadingProcess(car);
        }
    }

    private synchronized void runMachineToWarehouse(Car car) {
        numberTrucksInWarehouse++;
        storekeeper.showStatus();
        loadingPost.showStatus();
        forklift.showStatus();
        loader.showStatus();
        parkingSpace.removeCarFromParkingSpace();
        car.start();
        try {
            car.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        product.showStatus();
        invoice.showStatus();
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseName='" + warehouseName + '\'' +
                '}';
    }
}
