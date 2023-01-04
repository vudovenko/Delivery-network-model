package towns;

import interfaces.DemonstratingStatus;
import mainThreads.Main;
import mainThreads.TimeClass;

import java.util.List;

public class Town implements DemonstratingStatus {
    private List<Store> stores;
    private Integer distanceToBase;
    private Integer demand;

    public Town(Integer numberStores, Integer distanceToBase, Integer demand) {
        for (int i = 1; i <= numberStores; ++i) {
            stores.add(new Store(this, i));
        }
        this.distanceToBase = distanceToBase;
        this.demand = demand;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public Integer getDistanceToBase() {
        return distanceToBase;
    }

    public void setDistanceToBase(Integer distanceToBase) {
        this.distanceToBase = distanceToBase;
    }

    public Integer getDemand() {
        return demand;
    }

    public void setDemand(Integer demand) {
        this.demand = demand;
    }

    public void generateRequest() {
        try {
            Thread.sleep(Main.randomNumberInRange(0, demand * 24 * TimeClass.VIRTUAL_HOUR));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        OrderRequest orderRequest = new OrderRequest(this,
                Main.randomNumberInRange(0, stores.size()),
                generateRandomTypeProduct());
        //Base.getProductRequest(orderRequest);
    }

    public TypeProduct generateRandomTypeProduct() {
        int randomNumber = Main.randomNumberInRange(1, 4);
        if (randomNumber == 1) {
            return TypeProduct.HEAVY_OVERSIZE;
        } else if (randomNumber == 2) {
            return TypeProduct.HEAVY_EURO_PALLETS;
        } else if (randomNumber == 3) {
            return TypeProduct.PLUMBING;
        } else {
            return TypeProduct.LIGHT_EURO_PALLETS;
        }
    }

    @Override
    public void showStatus() {
        for (Store store : stores) {
            store.showStatus();
        }
    }
}
