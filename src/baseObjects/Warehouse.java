package baseObjects;

import cars.Car;
import cars.Kamaz;
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
    private volatile Boolean hasKamazArrived;

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
        hasKamazArrived = false;
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

    public Boolean getHasKamazArrived() {
        return hasKamazArrived;
    }

    public void setHasKamazArrived(Boolean hasKamazArrived) {
        this.hasKamazArrived = hasKamazArrived;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (numberTrucksInWarehouse < 2 && parkingSpace.getParkingSize() > 0) {
                    while (hasKamazArrived && numberTrucksInWarehouse != 0) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Car car = parkingSpace.removeCarFromParkingSpace();
                    startLoadingProcess(car);
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
        if (car instanceof Kamaz) {
            hasKamazArrived = !hasKamazArrived;
        }
        parkingSpace.addCarToParkingSpace(car);
        System.out.println(car + " прибыл на парковку склада " + warehouseName);
    }

    private void startLoadingProcess(Car car) {
        synchronized (this) {
            numberTrucksInWarehouse++;
        }
        if (car instanceof Truck) {
            System.out.println("\n");
            storekeeper.showStatus();
            loadingPost.showStatus();
            forklift.showStatus();
            loader.showStatus();
        }
        sendFromWarehouse(car);
    }

    private void sendFromWarehouse(Car car) {
        new Thread(() -> {
            try {
                Thread.sleep((long) TimeClass.VIRTUAL_HOUR * car.getTimeInWarehouse());
                synchronized (this) {
                    if (car instanceof Truck) {
                        product.showStatus();
                        invoice.showStatus();
                    }
                    System.out.println("numberTrucksInWarehouse = " + numberTrucksInWarehouse + "\n");
                    numberTrucksInWarehouse--;
                    System.out.println(car + " выехал со склада " + warehouseName);
                    if (car instanceof Truck) {
                        CarPark.sendCarToPark((Truck) car);
                    } else {
                        hasKamazArrived = !hasKamazArrived;
                    }
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
