package towns;

import interfaces.DemonstratingStatus;
import mainThreads.Main;
import mainThreads.TimeClass;
import warehouses.Base;

import java.util.List;

public class Town implements DemonstratingStatus {
    private List<Store> stores;
    private Integer distanceToBase;
    private Integer demand;
    private String townName;

    public Town(Integer numberStores, Integer distanceToBase, Integer demand, String townName) {
        for (int i = 1; i <= numberStores; ++i) {
            stores.add(new Store(this, i));
        }
        this.distanceToBase = distanceToBase;
        this.demand = demand;
        this.townName = townName;
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

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public void generateRequest() {
        try {
            Thread.sleep(Main.randomNumberInRange(0, demand * 24 * TimeClass.VIRTUAL_HOUR));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Integer randomStoreId = Main.randomNumberInRange(0, stores.size());
        Store store = new Store(this, randomStoreId);
        store.setIsDemandSatisfied(false);
        stores.set(randomStoreId, store);
        stores.get(randomStoreId).showStatus();
        OrderRequest orderRequest = new OrderRequest(this, randomStoreId,
                stores.get(randomStoreId).getThisProductNeed());
        Base.getProductRequest(orderRequest);
    }

    @Override
    public void showStatus() {
        for (Store store : stores) {
            store.showStatus();
        }
    }
}
