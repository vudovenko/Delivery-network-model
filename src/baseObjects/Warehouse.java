package baseObjects;

import cars.Car;
import cars.Truck;
import mainThreads.TimeClass;
import towns.TypeProduct;

public class Warehouse extends Thread {
    private String warehouseName;
    private Forklift forklift;
    private Invoice invoice;
    private Loader loader;
    private LoadingPost loadingPost;
    private Product product;
    private Storekeeper storekeeper;
    private ParkingSpace parkingSpace;
    private static Integer numberTrucksInWarehouse;

    public Warehouse(String warehouseName, TypeProduct typeProduct) {
        this.warehouseName = warehouseName;
        this.forklift = new Forklift(this);
        this.invoice = new Invoice(this);
        this.loader = new Loader(this);
        this.loadingPost = new LoadingPost(this);
        this.product = new Product(this, typeProduct);
        this.storekeeper = new Storekeeper(this);
        parkingSpace = new ParkingSpace();
        numberTrucksInWarehouse = 0;
    }

    public synchronized Boolean areThereTrucksInWarehouse() {
        return numberTrucksInWarehouse != 0;
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

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
//                System.out.println("\nnumberTrucksInWarehouse = " + numberTrucksInWarehouse);
//                System.out.println("parkingSpace.getParkingSize() = " + parkingSpace.getParkingSize());
//                System.out.println("numberTrucksInWarehouse < 2 && parkingSpace.getParkingSize() != 0 = "
//                        + (numberTrucksInWarehouse < 2 && parkingSpace.getParkingSize() != 0) + "\n");
                if (numberTrucksInWarehouse < 2 && parkingSpace.getParkingSize() > 0) {
                    Truck truck = (Truck) parkingSpace.removeCarFromParkingSpace();
                    startLoadingProcess(truck);
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void runMachineToWarehouse(Car car) {
        synchronized (this) {
            parkingSpace.addCarToParkingSpace(car);
        }
    }

    private void startLoadingProcess(Truck truck) {
        synchronized (this) {
            numberTrucksInWarehouse++;
        }
        System.out.println("\n");
        storekeeper.showStatus();
        loadingPost.showStatus();
        forklift.showStatus();
        loader.showStatus();
        new Thread(() -> {
            try {
                Thread.sleep(TimeClass.VIRTUAL_HOUR);
                synchronized (this) {
                    product.showStatus();
                    invoice.showStatus();
                    System.out.println("numberTrucksInWarehouse = " + numberTrucksInWarehouse + "\n");
                    numberTrucksInWarehouse--;
                    System.out.println("Грузовик выехал со склада " + warehouseName);
                    CarPark.sendCarToPark(truck);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseName='" + warehouseName + '\'' +
                '}';
    }
}
