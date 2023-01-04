package towns;

import interfaces.DemonstratingStatus;

import java.util.ArrayList;
import java.util.List;

public class Town implements DemonstratingStatus {
    private List<Store> stores;
    private Integer distanceToBase;
    private Double demand;

    public Town(Integer numberStores, Integer distanceToBase, Double demand) {
        for (int i = 0; i < numberStores; ++i) {
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

    public Double getDemand() {
        return demand;
    }

    public void setDemand(Double demand) {
        this.demand = demand;
    }

    @Override
    public void showStatus() {
        for (Store store : stores) {
            store.showStatus();
        }
    }
}
